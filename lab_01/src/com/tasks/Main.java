package com.tasks;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        System.out.print("Оберіть номер завдання (всі окрім 13): ");
        Scanner scanner = new Scanner(System.in);
        int task_number = scanner.nextInt();
        switch (task_number){
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            case 4:
                task4();
                break;
            case 5:
                task5();
                break;
            case 6:
                task6();
                break;
            case 7:
                task7();
                break;
            case 8:
                task8();
                break;
            case 9:
                task9();
                break;
            case 10:
                task10();
                break;
            case 11:
                task11();
                break;
            case 12:
                task12();
                break;
            case 14:
                task14();
                break;
        }


    }
    public static void task1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String input_text = scanner.nextLine();
        System.out.println("Hello " + input_text);
    }
    public static void task2(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введення даних: ");
        int inputSeconds = scanner.nextInt();

        int hours = inputSeconds / 3600;
        int minutes = (inputSeconds % 3600) / 60;
        int seconds = inputSeconds % 60;

        System.out.printf("Результат виконання: %02d:%02d:%02d%n", hours, minutes, seconds);
    }
    final static int password = 12345;

    public static void task3() {
        // Запит на введення пароля
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть пароль: ");
        int enteredPassword = scanner.nextInt();

        // Перевірка пароля
        if (enteredPassword == password) {
            System.out.println("Hello, Agent");
        } else {
            System.out.println("Access denied");
        }
    }
    public static void task4() {
        Scanner scanner = new Scanner(System.in);

        // Запит на введення кількості незнайомців
        System.out.print("Введіть кількість незнайомців: ");
        int numStrangers = scanner.nextInt();

        // Перевірка на від'ємне або нульове значення
        if (numStrangers <= 0) {
            System.out.println("Введено неправильне значення кількості незнайомців.");
            return;
        }

        // Зчитування та виведення імен незнайомців
        scanner.nextLine(); // Очищення буфера після nextInt()
        for (int i = 1; i <= numStrangers; i++) {
            System.out.print("Введіть ім'я незнайомця " + i + ": ");
            String name = scanner.nextLine();
            System.out.println("Hello, " + name);
        }
    }
    public static void task5() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введення даних: ");
        int a = scanner.nextInt(); // висота, на яку равлик піднімається за день
        int b = scanner.nextInt(); // висота, на яку равлик сповзає за ніч
        int h = scanner.nextInt(); // загальна висота дерева

        // Розрахунок кількості днів
        int days = (h - b - 1) / (a - b) + 1;
        if (h <= b) {
            System.out.println("Результат: Impossible");
        } else {
            System.out.println("Результат: " + days);
        }
    }
    public static void task6(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введення даних: ");
        int totalBill = scanner.nextInt(); // загальна сума рахунку
        int numFriends = scanner.nextInt(); // кількість друзів

        // Перевірка на від'ємну суму рахунку та нульову кількість друзів
        if (totalBill <= 0 || numFriends <= 0) {
            System.out.println("Результат: Некоректні вхідні дані");
        } else {
            // Розрахунок розміру частини оплати
            double eachPay = totalBill * 1.1 / numFriends;
            System.out.println("Результат: " + (int) Math.ceil(eachPay));
        }
    }
    public static void task7(){
        Scanner scanner = new Scanner(System.in);

        // Зчитування першого значення
        System.out.print("Введення даних: ");
        int number = scanner.nextInt();
        int max = number; // Початкове значення максимуму

        // Зчитування наступних значень та пошук максимального
        while (number != 0) {
            if (number > max) {
                max = number;
            }
            number = scanner.nextInt();

        }

        // Виведення результату
        System.out.println("Результат: " + max);
    }
    public static void task8(){
        Scanner scanner = new Scanner(System.in);

        // Зчитування першого значення
        System.out.print("Введення даних: ");
        int number = scanner.nextInt();
        int sum = number; // Початкова сума
        int count = 1; // Початкова кількість елементів

        // Зчитування наступних значень та обчислення суми та кількості
        while (number != 0) {
            sum += number;
            count++;
            number = scanner.nextInt();
        }

        // Обчислення середнього значення
        double average = (double) sum / (count - 1); // Віднімаємо 1, оскільки останнє число - 0

        // Виведення результату
        System.out.println("Результат: " + (int) Math.round(average));
    }
    public static void task9(){
        Scanner scanner = new Scanner(System.in);

        // Зчитування коефіцієнтів квадратного рівняння
        System.out.print("Введення даних: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        // Обчислення дискримінанту
        double discriminant = b * b - 4 * a * c;

        // Виведення результату в залежності від дискримінанту
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Результат: " + root1 + " " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Результат: " + root);
        } else {
            System.out.println("Результат: no roots");
        }
    }
    public static void task10(){
        int[] array = {2, 4, 6, 9, 2, 4, 5};
        int maxValue = max(array);
        System.out.println("Максимальне значення: " + maxValue);
    }

    public static int max(int[] array) {
        int maxValue = array[0]; // Початкове значення максимального елемента

        // Пошук максимального значення в масиві
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        return maxValue;
    }
    public static void task11() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sumOfEven = sum(array);
        System.out.println("Сума парних чисел: " + sumOfEven);
    }

    public static int sum(int[] array) {
        // Перевірка на порожній масив або масив, що дорівнює нулю
        if (array == null || array.length == 0) {
            return 0;
        }

        int sumOfEven = 0;

        // Підрахунок суми парних чисел
        for (int number : array) {
            if (number % 2 == 0) {
                sumOfEven += number;
            }
        }

        return sumOfEven;
    }
    public static void task12(){
        int[] inputArray = {1, -1, 0, 4, 6, 10, 15, 25};
        boolean[] resultArray = getSumCheckArray(inputArray);

        System.out.print("Результат: [");
        for (boolean value : resultArray) {
            System.out.print(value + ", ");
        }
        System.out.println("]");
    }
    public static boolean[] getSumCheckArray(int[] array) {
        boolean[] result = new boolean[array.length];
        result[0] = false;
        result[1] = false;

        for (int i = 2; i < array.length; i++) {
            if (array[i] == array[i - 1] + array[i - 2]) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
        public static void task14() {
            int[] array1 = {1, 3, 2, 7, 4};
            int[] array2 = {1, 3, 2, 7, 4};

            cycleSwap(array1, 1);
            printArray(array1);

            cycleSwap(array2, 3);
            printArray(array2);
        }

        public static void cycleSwap(int[] array, int shift) {
            if (array.length <= 1 || shift <= 0 || shift >= array.length) {
                return;
            }

            int[] temp = new int[shift];

            // Зберігаємо останні shift елементів
            System.arraycopy(array, array.length - shift, temp, 0, shift);

            // Зсуваємо елементи до shift позицій
            for (int i = array.length - shift - 1; i >= 0; i--) {
                array[i + shift] = array[i];
            }

            // Переміщуємо збережені елементи на початок
            System.arraycopy(temp, 0, array, 0, shift);
        }

        public static void printArray(int[] array) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
