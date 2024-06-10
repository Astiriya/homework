package Shape;

public class Triangle implements Shape {
    private String name = "Треугольник";
    private double a;
    private double b;
    private double c;
    private String fillColor;
    private String borderColor;

    // Конструктор
    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getPerimeter() {
        return calculatePerimeter(a, b, c);
    }

    public double calculateArea() {
        double p = (calculatePerimeter(a, b, c)) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public String getName() {
        return name;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}
