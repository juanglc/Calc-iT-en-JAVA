package FigurasCirculares;

import java.util.InputMismatchException;
import java.util.Scanner;
import archivo.Archivo;

public class Circulo extends FigurasCirculares
{

    static Scanner sc = new Scanner(System.in);
    public Circulo(double radio, double altura)
    {
        super(radio, altura);
        this.radio = radio;
        this.altura = altura;
    }

    public double area()
    {
        area = PI * Math.pow(radio, 2);
        String resultado = "El área del círculo es: " + area;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area;
    }

    public static Circulo solicitarDatosCirculo()
    {
        Scanner sc = new Scanner(System.in);
        boolean i = true;
        double radioCirculo = 0;
        System.out.println("Ingrese el radio del círculo:");
        while (i)
        {
            try
            {
                radioCirculo = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        double alturaCirculo = 0;
        return new Circulo(radioCirculo, alturaCirculo);
    }
}
