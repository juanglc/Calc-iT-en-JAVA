package archivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

public class Archivo{

    static Scanner sc = new Scanner(System.in);
    static FileWriter writer;
    static int i = 1;

    //poner que el archivo se autoelimine después de subir a la nube

    public static File crearArchivo()
    {
        System.out.println("Ingrese la ruta de la carpeta donde desea guardar el archivo de forma temporal para poder ser enviado a su correo:");
        System.out.println("Introduzca el directorio de la siguiente forma: C:\\Users\\Usuario\\Desktop\\Carpeta\\CarpetaDestino (sin comillas)");
        String dir = sc.nextLine();
        File file = null;
        try
        {
            System.out.println("Ingrese el nombre que desea ponerle al archivo (sólo indique el nombre. no incluya el .txt):");
            String nombreArchivo = sc.nextLine();
            dir =  dir+"\\"+nombreArchivo+".txt";
            file = new File(dir);
            writer = new FileWriter(file);
        }
        catch (IOException e)
        {
            System.out.println("Error al crear el archivo");
            e.printStackTrace();
        }
        return file;
    }

    public static void escribirEnArchivo(String texto)
    {
        if (writer != null)
        {
            try
            {
                writer.write(i + ". "+texto+"\n");
                i++;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void cerrarArchivo()
    {
        if (writer != null)
        {
            try
            {
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}


