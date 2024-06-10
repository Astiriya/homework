package Shape;

public class Main {

    public static void printShapeInfo(Shape shape) {
        String perimeterFormatted = String.format("%.2f", shape.getPerimeter());
        String areaFormatted = String.format("%.2f", shape.calculateArea());

        System.out.println("Фигура: " + shape.getName());
        System.out.println("Периметр: " + perimeterFormatted);
        System.out.println("Площадь: " + areaFormatted);
        System.out.println("Цвет фона: " + shape.getFillColor());
        System.out.println("Цвет границы: " + shape.getBorderColor());
        System.out.println();
    }

    public static void main(String[] args) {
        Shape circle = new Circle(2, "Красный", "Черный");
        Shape rectangle = new Rectangle(3, 4, "Синий", "Голубой");
        Shape triangle = new Triangle(3, 4, 5, "Желтый", "Фиолетовый");


        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(triangle);
    }
}