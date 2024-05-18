package Correo;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import static com.google.api.services.gmail.GmailScopes.GMAIL_SEND;
import static javax.mail.Message.RecipientType.TO;

public class Correo
{
    private static final Scanner sc = new Scanner(System.in);
    private static final String correoSalida = "juanguiloco3@gmail.com";
    private static Gmail servicio;

    public Correo() throws GeneralSecurityException, IOException
    {
        NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        servicio = new Gmail.Builder(HTTP_TRANSPORT, jsonFactory, credenciales(HTTP_TRANSPORT, jsonFactory))
                .setApplicationName("Correo de prueba")
                .build();
    }


    public static void enviarCorreo(String correoDestino, String pathArchivo) throws GeneralSecurityException, IOException, MessagingException
    {
        String asunto = "Resultados Calc iT";
        String mensaje = """
            Hola,
            
            ¡Gracias por confiar en nosotros!
            """;
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(correoSalida));
        email.addRecipient(TO, new InternetAddress(correoDestino));
        email.setSubject(asunto);

        Multipart multipart = new MimeMultipart();
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(mensaje);
        multipart.addBodyPart(messageBodyPart);

        MimeBodyPart adjunto = new MimeBodyPart();
        FileDataSource fuente = new FileDataSource(pathArchivo);
        adjunto.setDataHandler(new DataHandler(fuente));
        adjunto.setFileName(fuente.getName());
        multipart.addBodyPart(adjunto);

        email.setContent(multipart);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] bitsMensajeSinProcesar = buffer.toByteArray();
        String mensajeCodificado = java.util.Base64.getUrlEncoder().encodeToString(bitsMensajeSinProcesar);
        com.google.api.services.gmail.model.Message msj = new com.google.api.services.gmail.model.Message();
        msj.setRaw(mensajeCodificado);

        try
        {
            msj = servicio.users().messages().send("me", msj).execute();
            System.out.println("\n\n¡El correo fue enviado exitosamente!\nDe no encontrarlo en la bandeja de entrada, por favor revise la carpeta de spam.\n¡Hasta luego!");
            System.out.println("\n\nMensaje enviado con ID: " + msj.getId());
        }
        catch (GoogleJsonResponseException e)
        {
            GoogleJsonError error = e.getDetails();
            if (error.getCode() == 403)
            {
                System.err.println("No es posible mandar el correo: "+e.getDetails());
            }
            else
            {
                throw e;
            }
        }
    }

    private static Credential credenciales(final NetHttpTransport HTTP_TRANSPORT, GsonFactory jsonFactory) throws IOException {
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(Correo.class.getResourceAsStream("/credenciales.json")));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, jsonFactory, clientSecrets, Set.of(GMAIL_SEND))
                .setDataStoreFactory(new FileDataStoreFactory(Paths.get("tokens").toFile()))
                .setAccessType("offline")
                .build();

        LocalServerReceiver recibidor = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, recibidor).authorize("user");
    }
}
