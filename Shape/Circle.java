package Shape;

public class Circle implements Shape {
    private final String name = "Круг";
    private double r;
    private final double pi = 3.14;
    private String fillColor;
    private String borderColor;

    public Circle(double r, String fillColor, String borderColor) {
        this.r = r;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getPerimeter() {
        return calculatePerimeter(r, pi);
    }

    public double calculateArea() {
        return pi * r * r;
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
