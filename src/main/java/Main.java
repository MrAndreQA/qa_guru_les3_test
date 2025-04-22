public class Main {

    public static void main(String[] args) {

        // 0) применить несколько арифметических операций ( + , -, * , /) над двумя примитивами типа int

        int three = 3;
        int five = 5;
        double two = 2;
        System.out.println("Результат сложения чисел = " + (three + five));
        System.out.println("Результат вычитания чисел = " + (three - five));
        System.out.println("Результат умножения чисел = " + (three * five));
        System.out.println("Результат деления чисел = " + (three / five));
        System.out.println("Остаток от деления чисел = " + (three % five));
        System.out.println("****************************");


        // 1) применить несколько арифметических операций над int и double в одном выражении
        System.out.println("Результат сложения чисел int и double = " + (three + two));
        System.out.println("Результат вычитания чисел int и double = " + (three - two));
        System.out.println("Результат умножения чисел int и double = " + (three * two));
        System.out.println("Результат деления чисел int и double = " + (three / two));
        System.out.println("Остаток от деления чисел int и double = " + (three % two));
        System.out.println("****************************");


        //2) применить несколько логических операций ( < , >, >=, <= )
        if (three == 3 && five == 5) {
            System.out.println("3 больше 5: " + (three > five));
        }

        System.out.println("5 больше или равно 3: " + (five >= three));

        System.out.println("5 меньше или равно 3: " + (five <= three));

        System.out.println("5 равно 3 : " + (five == three));
        System.out.println("****************************");


      // 4) получить переполнение при арифметической операции
            // Максимальное значение для int (2_147_483_647)
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;

            // Переполнение при сложении
        int overflowAdd = maxInt + 1; // Станет Integer.MIN_VALUE (-2_147_483_648)
        System.out.println("maxInt + 1 = " + overflowAdd);
            // Переполнение при вычитании
        int overflowSub = minInt - 1; // Станет Integer.MAX_VALUE
        System.out.println("minInt - 1 = " + overflowSub);
    }
}