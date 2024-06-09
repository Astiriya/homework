package Animals;

public class Dish {
    private int food;

    public Dish(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void minusFood(int quantity) {
        if (quantity <= food) {
            food = food - quantity;
        }
    }

    public void addFood(int quantity) {
        food = food + quantity;
        System.out.println("Добавлено " + quantity + " единиц еды в миску.");
    }

}

