package FigurasCirculares;

import java.util.InputMismatchException;
import java.util.Scanner;
import archivo.Archivo;

public class Esfera extends FigurasCirculares
{
    static Scanner sc = new Scanner(System.in);

    public Esfera(double radio, double altura)
    {
        super(radio, altura);
        this.radio = radio;
        this.altura = altura;
    }

    public double area()
    {
        area = 4 * PI * Math.pow(radio, 2);
        String resultado = "El área de la esfera es: " + area;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area;
    }

    public double volumen()
    {
        volumen = (4.0 / 3.0) * PI * Math.pow(radio, 3);
        String resultado = "El volumen de la esfera es: " + volumen;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return volumen;
    }

    public void todo()
    {
        area();
        volumen();
    }

    public static Esfera solicitarDatosEsfera()
    {
        boolean i = true;
        double radioEsfera = 0;
        System.out.println("Ingrese el radio de la esfera:");
        while (i)
        {
            try
            {
                radioEsfera = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        double alturaEsfera = 0;
        return new Esfera(radioEsfera, alturaEsfera);
    }
}
