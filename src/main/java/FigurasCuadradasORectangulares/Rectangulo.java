package FigurasCuadradasORectangulares;

import java.util.InputMismatchException;
import java.util.Scanner;
import archivo.Archivo;

public class Rectangulo extends FigurasCuadradasOTriangulares
{
    static Scanner sc = new Scanner(System.in);

    public Rectangulo(double base, double altura)
    {
        super(base, altura);
        this.base = base;
        this.altura = altura;
    }

    public double area()
    {
        area = base * altura;
        String resultado = "El área del rectángulo es: " + area;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area;
    }

    public static Rectangulo solicitarDatosRectangulo()
    {
        boolean i = true;
        double baseRectangulo = 0;
        double alturaRectangulo = 0;
        System.out.println("Ingrese la base del rectángulo:");
        while (i)
        {
            try
            {
                baseRectangulo = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        i = true;
        System.out.println("Ingrese la altura del rectángulo:");
        while (i)
        {
            try
            {
                alturaRectangulo = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        return new Rectangulo(baseRectangulo, alturaRectangulo);
    }
}
