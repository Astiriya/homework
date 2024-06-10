package Shape;

public class Rectangle implements Shape {
    private String name = "Прямоугольник";
    private int a;
    private int b;
    private String fillColor;
    private String borderColor;


    public Rectangle(int a, int b, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getPerimeter() {
        return calculatePerimeter(a, b);
    }

    public double calculateArea() {
        return a * b;
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
