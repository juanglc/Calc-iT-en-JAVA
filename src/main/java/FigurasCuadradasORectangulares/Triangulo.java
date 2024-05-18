package FigurasCuadradasORectangulares;

import java.util.InputMismatchException;
import java.util.Scanner;
import archivo.Archivo;

public class Triangulo extends FigurasCuadradasOTriangulares
{
    static Scanner sc = new Scanner(System.in);

    public Triangulo(double base, double altura)
    {
        super(base, altura);
        this.base = base;
        this.altura = altura;
    }

    public double area()
    {
        area = (base * altura) / 2;
        String resultado = "El área del triángulo es: " + area;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area;
    }

    public static Triangulo solicitarDatosTriangulo()
    {
        boolean i = true;
        double baseTriangulo = 0;
        double alturaTriangulo = 0;
        System.out.println("Ingrese la base del triángulo:");
        while (i)
        {
            try
            {
                baseTriangulo = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        i = true;
        System.out.println("Ingrese la altura del triángulo:");
        while (i)
        {
            try
            {
                alturaTriangulo = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        return new Triangulo(baseTriangulo, alturaTriangulo);
    }
}
