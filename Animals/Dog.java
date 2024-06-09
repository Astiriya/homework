package Animals;

public class Dog extends Animals {
    private static final int RUN_MAX = 500;
    private static final int SWIM_MAX = 10;
    private static int dogCount;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
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
        if (distance >= SWIM_MAX) {
            System.out.println(name + " не может столько проплыть.");
        } else {
            super.swim(distance);
        }

    }
}
