public class First {
    public static void main(String[] args) {
         printThreeWords();
         checkSumSign();
         printColor();
         compareNumbers();
         System.out.println(integer( 10, 10));
         negativeOrPositive (0);
         System.out.println(negativeTrue(0));
         doubleLine("Привет", 5);
         System.out.println(leapYear(300));
         box();
        mas();
        initial(3,5);

        // упражнение 13
        int[][] square = new
                int[6][6] ;
        for (int s = 0; s < 6; s++) {
            square[s][s] = 1;}

        for (int s = 0; s < 6; s++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(square[s][j] + " ");}
                System.out.println();
            }

// упражнение 11
        int[] hundred = new int[100];
        for (int i = 0; i < hundred.length; i++) {
            hundred[i] = i + 1;}
        for (int a : hundred) {
            System.out.print(a + " ");}

    }

    //упражнение 1
    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");}

    //упражнение 2
    static void checkSumSign() {
        int a, b;
        a = 3;
        b = -3;
        if ((a + b) < 0) {
            System.out.println("Сумма отрицательная");
        } else {
            System.out.println("Сумма положительная");}
    }

    //упражнение 3
    static void printColor() {
        int value = 102;
        if (value <= 0) {
            System.out.println("Красный");}
        else if (value > 0 && value <= 100) {
            System.out.println("Желтый");}
        else if (value > 100) {
            System.out.println("Зеленый");}
    }

    //упражнение 4
    static void compareNumbers(){
        int a, b;
        a = 1;
        b = 3;
        if (a >= b) {
            System.out.println("a >= b");}
        else {
            System.out.println("a < b");}
    }
    //упражнение 5
    static boolean integer (int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;}

    // упражнение 6
    static void negativeOrPositive(int a){
       if (a>=0) {
           System.out.println("Положительное");}
       else {
           System.out.println("Отрицательное");}
    }
    //упражнение 7
    static boolean negativeTrue (int a){
        return a < 0;} //по аналогии с предыдущим заданием 0 = положительное число

    //упражнение 8
    public static void doubleLine(String a, int b) {
        for (int i=0;i<b;i++){
            System.out.println(a);}}

    //упражнение 9
    static boolean leapYear(int year){
        return  (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);}

    // упражнение 10
    static void box(){
int[] pul = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < pul.length; i++){
        if (pul[i] >= 1){
            pul[i] *= 0;}
            else {pul[i] +=1;}
        }
    for ( int x : pul){
        System.out.print(x);}
    }

    // упражнение 12
    static void mas(){
        System.out.println();
        int[] a = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < a.length; i++) {
            if (a[i]<6) {
                a[i]*=2;}
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");}
    }

    // упражнение 14
   public static int[] initial(int len, int initialValue){
int[] v = new int [len];
        for (int i = 0; i < v.length; i++) {
            v[i] = initialValue;}
            for (int value : v) {
                System.out.println(value);
        }
       return v;
    }
}
