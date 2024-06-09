package Animals;

public class Cat extends Animals {
    private static final int RUN_MAX = 200;
    private static int catCount;
    private boolean fed;

    public Cat(String name) {
        super(name);
        this.fed = false;
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= RUN_MAX) {
            super.run(distance);
        } else {
            System.out.println(name + " не может столько бежать.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не хочет лезть в воду.");
    }

    public void eat(Dish dish, int quantity) {
        if (dish.getFood() >= quantity) {
            dish.minusFood(quantity);
            this.fed = true;
        }
    }

    public boolean getFed() {
        return fed;
    }
}
