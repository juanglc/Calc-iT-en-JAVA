package FigurasCirculares;

import java.util.InputMismatchException;
import java.util.Scanner;
import archivo.Archivo;

import static com.calcit.Main.preguntarArchivo;

public class Cilindro extends FigurasCirculares
{
    static Scanner sc = new Scanner(System.in);

    public Cilindro(double radio, double altura)
    {
        super(radio, altura);
        this.radio = radio;
        this.altura = altura;
    }

    public double areaBase()
    {
        area_base = PI * Math.pow(radio, 2);
        String resultado = "El área de la base del cilindro de radio " + radio + " es: " + area_base;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area_base;
    }

    public double areaLateral()
    {
        area_lateral = 2 * PI * radio * altura;
        String resultado = "El área lateral del cilindro es: " + area_lateral;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area_lateral;
    }

    public double areaTotal()
    {
        area = (2*area_base) + area_lateral;
        String resultado = "El área total del cilindro es: " + area;
        System.out.println(resultado);
        Archivo.escribirEnArchivo(resultado);
        return area;
    }

    public double volumen()
    {
        volumen = PI * Math.pow(radio, 2) * altura;
        String resultado = "El volumen del cilindro es: " + volumen;
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

    public static Cilindro solicitarDatosCilindro()
    {
        double radioCilindro = 0;
        double alturaCilindro = 0;
        boolean i = true;
        System.out.println("Ingrese el radio del cilindro:");
        while (i)
        {
            try
            {
                radioCilindro = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        i = true;
        System.out.println("Ingrese la altura del cilindro:");
        while (i)
        {
            try
            {
                alturaCilindro = sc.nextDouble();
                i = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número");
                sc.next();
            }
        }
        return new Cilindro(radioCilindro, alturaCilindro);
    }
}
