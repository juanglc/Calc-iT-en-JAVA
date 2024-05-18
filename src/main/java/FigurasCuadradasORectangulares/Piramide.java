package FigurasCuadradasORectangulares;

import java.util.InputMismatchException;
import java.util.Scanner;
import archivo.Archivo;

public class Piramide extends FigurasCuadradasOTriangulares
{
    static Scanner sc = new Scanner(System.in);
    private int n_caras;


    double perimetro;
    double apotemaBase;
    double apotemaPiramide;

    public Piramide(double base, double altura, int n_caras)
    {
        super(base, altura);
        this.base = base;
        this.altura = altura;
        this.n_caras = n_caras;
        perimetro = base * n_caras;
        apotemaBase = base / 2.0;
        apotemaPiramide = Math.sqrt(Math.pow(altura, 2.0) + Math.pow(apotemaBase, 2.0));
    }

    public double areaBase()
    {
        area_base = (perimetro * apotemaBase) / 2.0;
        String resultado = "El área de la base de la pirámide es: " + area_base;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area_base;
    }

    public double areaLateral()
    {
        area_lateral = (perimetro * apotemaPiramide) / 2.0;
        String resultado = "El área lateral de la pirámide es: " + area_lateral;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area_lateral;
    }

    public double areaTotal()
    {
        area = area_base + area_lateral;
        String resultado = "El área total de la pirámide es: " + area;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area;
    }

    public double volumen()
    {
        volumen = (area_base* altura / 3.0);
        String resultado = "El volumen de la pirámide es: " + volumen;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return volumen;
    }

    public void todo()
    {
        areaBase();
        areaLateral();
        areaTotal();
        volumen();
    }

    public static Piramide solicitarDatosPiramide()
    {
        boolean i = true;
        double basePiramide = 0;
        double alturaPiramide = 0;
        int carasPiramide = 0;

        System.out.println("Ingrese la base de la pirámide:");
        while (i)
        {
            try
            {
                basePiramide = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        i = true;
        System.out.println("Ingrese la altura de la pirámide:");
        while (i)
        {
            try
            {
                alturaPiramide = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        i = true;
        System.out.println("Ingrese el número de caras de la pirámide:");
        while (i)
        {
            try
            {
                carasPiramide = sc.nextInt();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número entero");
                sc.next();
            }
        }
        return new Piramide(basePiramide, alturaPiramide, carasPiramide);
    }
}
