public class Employee {
    public String fullName;
    public String position;
    public String email;
    public String number;
    public int salary;
    public int age;

    public Employee(String FullName, String Position, String email,
                    String number, int salary, int age) {
        this.fullName = FullName;
        this.position = Position;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + number);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println();
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Кузнецова Анна Ивановна", "Бухгалтер", "kuznetsova@astondevs.ru", "+79161234570", 48000, 32);
        employees[1] = new Employee("Сидоров Валерий Валерьянович", "Аналитик", "sidorov@astondevs.ru", "+79161234569", 80000, 28);
        employees[2] = new Employee("Морозов Алексей Викторович", "Проект-менеджер", "morozov@astondevs.ru", "+79161234573", 125080, 38);
        employees[3] = new Employee("Васильева Елена Николаевна", "Дизайнер", "vasilieva@astondevs.ru", "+79161234572", 65000, 26);
        employees[4] = new Employee("Крупский Алесь Алексеевич", "Программист", "krupsky@astondevs.ru", "+79161234571", 75000, 29);
        for (Employee print : employees) {
            print.info();
        }}
}

