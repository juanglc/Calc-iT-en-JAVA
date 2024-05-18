package com.calcit;

import Correo.Correo;
import FigurasCirculares.Cilindro;
import FigurasCirculares.Circulo;
import FigurasCirculares.Cono;
import FigurasCirculares.Esfera;
import FigurasCuadradasORectangulares.*;
import archivo.Archivo;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Correo.Correo.enviarCorreo;
import static archivo.Archivo.cerrarArchivo;
import static archivo.Archivo.crearArchivo;

public class Main
{
    static Scanner sc = new Scanner(System.in);

    public static void bienvenida()
    {
        System.out.println("¡Bienvenid@ a Calc iT: el programa de cálculo de áreas y volúmenes de figuras geométricas!");
    }

    public static int preguntarArchivo()
    {
        boolean i = true;
        System.out.println("El programa creará un archivo de texto con los resultados obtenidos para que sean enviados a su correo electrónico. ¿Desea crear un archivo de texto con los resultados? (Ingrese 1 para decir Sí, y 2 para decir No)");
        int opcion = 0;
        while (i)
        {
            try
            {
                opcion = sc.nextInt();
                sc.nextLine();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número entero");
                sc.next();
                continue;
            }
            if (opcion == 1)
            {
                i = false;
            }
            else if (opcion == 2)
            {
                i = false;
            }
            else
            {
                System.out.println("Opción inválida");
            }
        }
        return opcion;
    }

    public static void escoger_otra()
    {
        boolean i = true;
        System.out.println("¿Desea calcular otra figura? (Ingrese 1 para decir Sí, y 2 para decir No)");
        while (i)
        {
            int opcion = 0;
            try
            {
                opcion = sc.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número entero");
                sc.next();
                continue;
            }
            if (opcion == 1)
            {
                escogerFigura();
                i = false;
            }
            else if (opcion == 2)
            {
                System.out.println("¡Gracias por usar el programa!");
                Archivo.cerrarArchivo();
                i = false;
            }
            else
            {
                System.out.println("Opción inválida");
            }
        }
    }

    public static void escogerFigura()
    {
        boolean i = true, j = true;
        System.out.println("¿Qué figura desea calcular?");
        System.out.println("1. Círculo");
        System.out.println("2. Triángulo");
        System.out.println("3. Cuadrado");
        System.out.println("4. Rectángulo");
        System.out.println("5. Cono");
        System.out.println("6. Cilindro");
        System.out.println("7. Esfera");
        System.out.println("8. Pirámide");
        System.out.println("9. Cubo");
        while (i)
        {
            int opcion = 0;
            try
            {
                opcion = sc.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Por favor, ingrese un número entero");
                sc.next();
                continue;
            }
            switch (opcion) {
                case 1:
                    Circulo circulo = Circulo.solicitarDatosCirculo();
                    circulo.area();
                    i = false;
                    break;
                case 2:
                    System.out.println("¡Escogió el triángulo!");
                    Triangulo triangulo = Triangulo.solicitarDatosTriangulo();
                    triangulo.area();
                    i = false;
                    break;
                case 3:
                    System.out.println("¡Escogió el cuadrado!");
                    Cuadrado cuadrado = Cuadrado.solicitarDatosCuadrado();
                    cuadrado.area();
                    i = false;
                    break;
                case 4:
                    System.out.println("¡Escogió el rectángulo!");
                    Rectangulo rectangulo = Rectangulo.solicitarDatosRectangulo();
                    rectangulo.area();
                    i = false;
                    break;
                case 5:
                    System.out.println("¡Escogió el cono!");
                    System.out.println("¿Qué operación quiere realizar?\nIngrese los siguientes números para hallar:\n1) Área de la base\n2) Área lateral\n3) Área total\n4) Volumen\n5) Áreas y volumen\n");
                    while(j)
                    {
                        int opcion2 = 0;
                        try
                        {
                            opcion2 = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Por favor, ingrese un número entero");
                            sc.next();
                            continue;
                        }
                        switch (opcion2) {
                            case 1:
                                System.out.println("Escogiste hallar el área de la base del cono");
                                Cono cono = Cono.solicitarDatosCono();
                                cono.areaBase();
                                j = false;
                                break;
                            case 2:
                                System.out.println("Escogiste hallar el área lateral del cono");
                                Cono cono2 = Cono.solicitarDatosCono();
                                cono2.areaLateral();
                                j = false;
                                break;
                            case 3:
                                System.out.println("Escogiste hallar el área total del cono");
                                Cono cono3 = Cono.solicitarDatosCono();
                                cono3.areaTotal();
                                j = false;
                                break;
                            case 4:
                                System.out.println("Escogiste hallar el volumen del cono");
                                Cono cono4 = Cono.solicitarDatosCono();
                                cono4.volumen();
                                j = false;
                                break;
                            case 5:
                                System.out.println("Escogiste hallar todas las áreas y el volumen del cono");
                                Cono cono5 = Cono.solicitarDatosCono();
                                cono5.todo();
                                j = false;
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    }
                    i = false;
                    break;
                case 6:
                    System.out.println("¡Escogió el cilindro!");
                    System.out.println("¿Qué operación quiere realizar?\nIngrese los siguientes números para hallar:\n1) Área de la base\n2) Área lateral\n3) Área total\n4) Volumen\n5) Áreas y volumen\n");
                    while(j)
                    {
                        int opcion3 = 0;
                        try
                        {
                            opcion3 = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Por favor, ingrese un número entero");
                            sc.next();
                            continue;
                        }
                        switch (opcion3) {
                            case 1:
                                System.out.println("Escogiste hallar el área de la base del cilindro");
                                Cilindro cilindro = Cilindro.solicitarDatosCilindro();
                                cilindro.areaBase();
                                j = false;
                                break;
                            case 2:
                                System.out.println("Escogiste hallar el área lateral del cilindro");
                                Cilindro cilindro2 = Cilindro.solicitarDatosCilindro();
                                cilindro2.areaLateral();
                                j = false;
                                break;
                            case 3:
                                System.out.println("Escogiste hallar el área total del cilindro");
                                Cilindro cilindro3 = Cilindro.solicitarDatosCilindro();
                                cilindro3.areaTotal();
                                j = false;
                                break;
                            case 4:
                                System.out.println("Escogiste hallar el volumen del cilindro");
                                Cilindro cilindro4 = Cilindro.solicitarDatosCilindro();
                                cilindro4.volumen();
                                j = false;
                                break;
                            case 5:
                                System.out.println("Escogiste hallar todas las áreas y el volumen del cilindro");
                                Cilindro cilindro5 = Cilindro.solicitarDatosCilindro();
                                cilindro5.todo();
                                j = false;
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    }
                    i = false;
                    break;
                case 7:
                    System.out.println("¡Escogió la esfera!");
                    System.out.println("¿Qué operación quiere realizar?\nIngrese los siguientes números para hallar:\n1) Área\n2) Volumen\n3) Área y volumen\n");
                    while(j)
                    {
                        int opcion4 = 0;
                        try
                        {
                            opcion4 = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Por favor, ingrese un número entero");
                            sc.next();
                            continue;
                        }
                        switch (opcion4) {
                            case 1:
                                System.out.println("Escogiste hallar el área de la esfera");
                                Esfera esfera = Esfera.solicitarDatosEsfera();
                                esfera.area();
                                j = false;
                                break;
                            case 2:
                                System.out.println("Escogiste hallar el volumen de la esfera");
                                Esfera esfera2 = Esfera.solicitarDatosEsfera();
                                esfera2.volumen();
                                j = false;
                                break;
                            case 3:
                                System.out.println("Escogiste hallar todas las áreas y el volumen de la esfera");
                                Esfera esfera3 = Esfera.solicitarDatosEsfera();
                                esfera3.todo();
                                j = false;
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    }
                    i = false;
                    break;
                case 8:
                    System.out.println("¡Escogió la pirámide!");
                    System.out.println("¿Qué operación quiere realizar?\nIngrese los siguientes números para hallar:\n1) Área de la base\n2) Área lateral\n3) Área total\n4) Volumen\n5) Áreas y volumen\n");
                    while(j)
                    {
                        int opcion5 = 0;
                        try
                        {
                            opcion5 = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Por favor, ingrese un número entero");
                            sc.next();
                            continue;
                        }
                        switch (opcion5) {
                            case 1:
                                System.out.println("Escogiste hallar el área de la base de la pirámide");
                                Piramide piramide = Piramide.solicitarDatosPiramide();
                                piramide.areaBase();
                                j = false;
                                break;
                            case 2:
                                System.out.println("Escogiste hallar el área lateral de la pirámide");
                                Piramide piramide2 = Piramide.solicitarDatosPiramide();
                                piramide2.areaLateral();
                                j = false;
                                break;
                            case 3:
                                System.out.println("Escogiste hallar el área total de la pirámide");
                                Piramide piramide3 = Piramide.solicitarDatosPiramide();
                                piramide3.areaTotal();
                                j = false;
                                break;
                            case 4:
                                System.out.println("Escogiste hallar el volumen de la pirámide");
                                Piramide piramide4 = Piramide.solicitarDatosPiramide();
                                piramide4.volumen();
                                j = false;
                                break;
                            case 5:
                                System.out.println("Escogiste hallar todas las áreas y el volumen de la pirámide");
                                Piramide piramide5 = Piramide.solicitarDatosPiramide();
                                piramide5.todo();
                                j = false;
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    }
                    i = false;
                    break;
                case 9:
                    System.out.println("¡Escogió el cubo!");
                    System.out.println("¿Qué operación quiere realizar?\nIngrese los siguientes números para hallar:\n1) Área de la base\n2) Área total\n3) Volumen\n4) Áreas y volumen\n");
                    while(j)
                    {
                        int opcion6 = 0;
                        try
                        {
                            opcion6 = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Por favor, ingrese un número entero");
                            sc.next();
                            continue;
                        }
                        switch (opcion6) {
                            case 1:
                                System.out.println("Escogiste hallar el área de la base del cubo");
                                Cubo cubo = Cubo.solicitarDatosCubo();
                                cubo.areaBase();
                                j = false;
                                break;
                            case 2:
                                System.out.println("Escogiste hallar el área total del cubo");
                                Cubo cubo2 = Cubo.solicitarDatosCubo();
                                cubo2.areaTotal();
                                j = false;
                                break;
                            case 3:
                                System.out.println("Escogiste hallar el volumen del cubo");
                                Cubo cubo3 = Cubo.solicitarDatosCubo();
                                cubo3.volumen();
                                j = false;
                                break;
                            case 4:
                                System.out.println("Escogiste hallar todas las áreas y el volumen del cubo");
                                Cubo cubo4 = Cubo.solicitarDatosCubo();
                                cubo4.todo();
                                j = false;
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    }
                    i = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
        escoger_otra();
    }

    public static void main(String[] args)
    {
        bienvenida();
        int archivoOpcion = preguntarArchivo();
        File archivo = null;
        String correo = null;
        if (archivoOpcion == 1)
        {
            archivo = Archivo.crearArchivo();
            System.out.println("Ingrese su correo electrónico:");
            correo = sc.nextLine();
        }
        escogerFigura();
        Archivo.cerrarArchivo();
        if (archivoOpcion == 1)
        {
            try
            {
                Correo correoObj = new Correo();
                Correo.enviarCorreo(correo, archivo.getAbsolutePath());
            }
            catch (GeneralSecurityException | IOException | MessagingException e)
            {
                e.printStackTrace();
            }
        }
        archivo.delete();
    }
}