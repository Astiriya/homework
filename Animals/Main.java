package Animals;

public class Main {
    public static void main(String[] args) {

        Dog dogInkar = new Dog("Инкар");
        Dog dogMarta = new Dog("Марта");

        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Гофер");
        cats[1] = new Cat("Диля");
        cats[2] = new Cat("Люська");
        cats[3] = new Cat("Гаражик");

        System.out.println("Всего животных: " + Animals.getAnimalCount());
        System.out.println("Из них");
        System.out.println("Кошек: " + Cat.getCatCount());
        System.out.println("Собак: " + Dog.getDogCount());

        Dish dish = new Dish(0);
        dish.addFood(30);

        for (Cat cat : cats) {
            cat.eat(dish, 10);
        }

        for (Cat cat : cats) {
            System.out.println(cat.name + " сытость: " + cat.getFed());
        }


        dogInkar.run(357);
        dogInkar.swim(5);
        dogMarta.run(600);
        cats[1].swim(100);
        cats[2].run(300);
        cats[0].run(153);
    }
}
