package Shape;

interface Shape {
    default double calculatePerimeter(int a, int b) {
        return 2 * (a + b);
    }

    default double calculatePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    default double calculatePerimeter(double r, double pi) {
        return 2 * pi * r;
    }

    double getPerimeter();

    double calculateArea();

    String getFillColor();

    String getBorderColor();

    String getName();
}


