package FigurasCirculares;

public class FigurasCirculares
{
    protected double radio;
    protected double area;
    protected double altura;
    protected double area_base;
    protected double area_lateral;
    protected double volumen;
    protected final double PI = Math.PI;

    public FigurasCirculares(double radio, double altura)
    {
        this.radio = radio;
        this.altura = altura;
    }
}