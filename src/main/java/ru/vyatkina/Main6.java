package ru.vyatkina;

import ru.vyatkina.lab6.part1.task1.B;
import ru.vyatkina.lab6.part3.task1.BV2;
import ru.vyatkina.lab6.part3.task1.EntityV2;

import java.util.Scanner;

public class Main6 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("0. Выход");
            System.out.println("1. К строке");
            System.out.println("8. К строке");

            int choice = getIntInput("Введите номер задания: ", 0, 8);

            switch (choice) {
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                case 1:
                    runTask1();
                    break;
                case 8:
                    runTask8();
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }


    //////////////// 1. К строке ////////////////
    private static void runTask1() {
        B b = new B();
        System.out.println(b);

    }

    //////////////// 8. К строке ////////////////
    private static void runTask8() {
        EntityV2 b = new BV2();
        System.out.println(b);
    }


    // Ниже - вспомогательные методы для чтения с консоли

    private static Integer getIntInput() {
        return getIntInput("Введите целое число: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static Integer getIntInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Введено неверное значение! Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }

}
