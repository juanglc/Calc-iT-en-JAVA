package FigurasCuadradasORectangulares;

import java.util.InputMismatchException;
import java.util.Scanner;
import archivo.Archivo;

public class Cuadrado extends FigurasCuadradasOTriangulares
{
    static Scanner sc = new Scanner(System.in);

    public Cuadrado(double base, double altura)
    {
        super(base, altura);
        this.base = base;
        this.altura = altura;
    }

    public double area()
    {
        area = Math.pow(base, 2);
        String resultado = "El área del cuadrado es: " + area;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area;
    }

    public static Cuadrado solicitarDatosCuadrado()
    {
        boolean i = true;
        double ladoCuadrado = 0;
        System.out.println("Ingrese el lado del cuadrado:");
        while (i)
        {
            try
            {
                ladoCuadrado = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        return new Cuadrado(ladoCuadrado, 0);
    }
}