package FigurasCirculares;

import java.util.InputMismatchException;
import java.util.Scanner;
import archivo.Archivo;

public class Cono extends FigurasCirculares
{

    static Scanner sc = new Scanner(System.in);

    public Cono(double radio, double altura)
    {
        super(radio, altura);
        this.radio = radio;
        this.altura = altura;
    }

    public double areaBase()
    {
        area_base = PI * Math.pow(radio, 2);
        String resultado = "El área de la base del cono es: " + area_base;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area_base;
    }

    public double areaLateral()
    {
        area_lateral = PI * radio * altura;
        String resultado = "El área lateral del cono es: " + area_lateral;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area_lateral;
    }

    public double areaTotal()
    {
        area = area_base + area_lateral;
        String resultado = "El área total del cono es: " + area;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area;
    }

    public double volumen()
    {
        volumen = (PI * Math.pow(radio, 2) * altura) / 3;
        String resultado = "El volumen del cono es: " + volumen;
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

    public static Cono solicitarDatosCono()
    {
        boolean i = true;
        double radioCono = 0;
        double alturaCono = 0;
        System.out.println("Ingrese el radio del cono:");
        while (i)
        {
            try
            {
                radioCono = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        i = true;
        System.out.println("Ingrese la altura del cono:");
        while (i)
        {
            try
            {
                alturaCono = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        return new Cono(radioCono, alturaCono);
    }
}