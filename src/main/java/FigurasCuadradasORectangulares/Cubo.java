package FigurasCuadradasORectangulares;

import java.util.InputMismatchException;
import java.util.Scanner;

import archivo.Archivo;

public class Cubo extends FigurasCuadradasOTriangulares
{
    static Scanner sc = new Scanner(System.in);

    public Cubo(double base, double altura)
    {
        super(base, altura);
        this.base = base;
        this.altura = altura;
    }

    public double areaBase()
    {
        area_base = Math.pow(base, 2);
        String resultado = "El área del cubo es: " + area_base;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area_base;
    }

    public double areaTotal()
    {
        area = 6 * area_base;
        String resultado = "El área total del cubo es: " + area;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area;
    }

    public double volumen()
    {
        volumen = Math.pow(base, 3);
        String resultado = "El volumen del cubo es: " + volumen;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return volumen;
    }

    public void todo()
    {
        areaBase();
        areaTotal();
        volumen();
    }

    public static Cubo solicitarDatosCubo()
    {
        boolean i = true;
        double baseCubo = 0;
        System.out.println("Ingrese el lado de la base del cubo:");
        while (i)
        {
            try
            {
                baseCubo = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        return new Cubo(baseCubo, 0);
    }
}
