public class Park {
    public class Attraction {
        private String name;
        private String workingHours;
        private int price;

        public Attraction(String name, String workingHours, int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void info() {
            System.out.println("Атракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " рублей");
        }
    }

    public static void main(String[] arg) {
        Park park = new Park();
        Attraction attraction1 = park.new Attraction("Карусель", "9:00 - 21:00", 400);
        Attraction attraction2 = park.new Attraction("Американские горки", "10:00 - 22:00", 500);
        attraction1.info();
        attraction2.info();
    }
}


