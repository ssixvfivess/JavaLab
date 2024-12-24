package ru.vyatkina;

import ru.vyatkina.lab2.part1.task1.Point;
import ru.vyatkina.lab3.part3.task5.Point3D;
import ru.vyatkina.lab4.part1.task1.Box;
import ru.vyatkina.lab4.part1.task2.Storage;
import ru.vyatkina.lab4.part3.task1.AbsApplyable;
import ru.vyatkina.lab4.part3.task1.Applyable;
import ru.vyatkina.lab4.part3.task1.MaxInArrayApplyable;
import ru.vyatkina.lab4.part3.task1.StringToLengthApplyable;
import ru.vyatkina.lab4.part3.task2.AnyPositiveFilter;
import ru.vyatkina.lab4.part3.task2.Filter;
import ru.vyatkina.lab4.part3.task2.MinLengthFilter;
import ru.vyatkina.lab4.part3.task2.PositiveNumberFilter;
import ru.vyatkina.lab4.part3.task3.ArrayReducer;
import ru.vyatkina.lab4.part3.task3.DoubleReducer;
import ru.vyatkina.lab4.part3.task3.Reducer;
import ru.vyatkina.lab4.part3.task3.StringReducer;
import ru.vyatkina.lab4.part3.task4.listcreation.ListCreationWay;
import ru.vyatkina.lab4.part3.task4.listcreation.StringLengthCreationWay;
import ru.vyatkina.lab4.part3.task4.listcreation.TwoSublistsCreationWay;
import ru.vyatkina.lab4.part3.task4.listcreation.UniqueStringsCreationWay;
import ru.vyatkina.lab4.part3.task4.transport.PositiveAndNegativeTransportWay;
import ru.vyatkina.lab4.part3.task4.transport.StringLengthTransportWay;
import ru.vyatkina.lab4.part3.task4.transport.TransportWay;
import ru.vyatkina.lab4.part3.task4.transport.UniqueStringsTransportWay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("0. Выход");
            System.out.println("1. Обобщенная коробка");
            System.out.println("2. Без null");
            System.out.println("3. Начало отсчета");
            System.out.println("4. Функция");
            System.out.println("5. Фильтр");
            System.out.println("6. Сокращение");
            System.out.println("7. Коллекционирование");

            int choice = getIntInput("Введите число от 0 до 7: ", 0, 8);

            switch (choice) {
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                case 1:
                    runTask1();
                    break;
                case 2:
                    runTask2();
                    break;
                case 3:
                    runTask3();
                    break;
                case 4:
                    runTask4();
                    break;
                case 5:
                    runTask5();
                    break;
                case 6:
                    runTask6();
                    break;
                case 7:
                    runTask7();
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }


    //////////////// 1. Обобщенная коробка ////////////////
    private static void runTask1() {
        int value = getIntInput();
        Box<Integer> box = new Box<>(value);
        printValue(box);
    }

    static void printValue(Box<Integer> box) {
        Integer value = box.get();
        System.out.println("Значение из коробки: " + value);
    }


    //////////////// 2. Без null ////////////////
    public static void runTask2() {
        Storage<Integer> storage1 = new Storage<>(null);
        printValue(storage1, 0);

        Storage<Integer> storage2 = new Storage<>(99);
        printValue(storage2, -1);

        Storage<String> storage3 = new Storage<>(null);
        printValue(storage3, "default");

        Storage<String> storage4 = new Storage<>("hello");
        printValue(storage4, "hello world");
    }

    static <T> void printValue(Storage<T> storage, T alt) {
        System.out.println("Значение в хранилище: " + storage.getValue(alt));
    }


    //////////////// 3. Начало отсчета ////////////////
    public static void runTask3() {
        Box<Point> box = new Box<>();
        test(box);
        printValue2(box);
    }


    // Конструкция Box<? super Point3D>, чтобы можно было параметризовать и с помощью Point, и Point3D
    private static void test(Box<? super Point3D> box) {
        box.put(new Point3D(1,2, 3));
    }

    private static void printValue2(Box<? super Point3D> box) {
        System.out.println("Значение: " + box.get());
    }


    //////////////// 4. Функция ////////////////
    public static void runTask4() {
        List<String> data1 = List.of("qwerty", "asdfg", "zx");
        List<Double> data2 = List.of(1D, -3.7);
        List<int[]> data3 = List.of(new int[]{1, 2, 3, 4}, new int[]{-5, -2, -4}, new int[]{0, 1, 2});

        // 1
        System.out.println(runApply(data1, new StringToLengthApplyable()));
        // 2
        System.out.println(runApply(data2, new AbsApplyable()));
        // 3
        System.out.println(runApply(data3, new MaxInArrayApplyable()));
    }

    public static <T, P> List<P> runApply(List<T> list, Applyable<T, P> applyable) {
        List<P> result = new ArrayList<>();
        for (T t : list) {
            result.add(applyable.apply(t));
        }
        return result;
    }


    //////////////// 5. Фильтр ////////////////
    public static void runTask5() {
        List<String> data1 = List.of("qwerty", "asdfg", "zx");
        List<Double> data2 = List.of(1D, -3.7);
        List<int[]> data3 = List.of(new int[]{1, 2, 3, 4}, new int[]{-5, -2, -4}, new int[]{0, 1, 2});

        // 1
        List<String> result1 = runFilter(data1, new MinLengthFilter(3));
        System.out.println(result1);

        // 2
        List<Double> result2 = runFilter(data2, new PositiveNumberFilter());
        System.out.println(result2);

        // 3
        // Сначала находим результат, потом выводим в красивом формате
        List<int[]> list = runFilter(data3, new AnyPositiveFilter());
        StringBuilder sb = new StringBuilder("[");
        for (int[] ints : list) {
            sb.append(Arrays.toString(ints)).append(" ");
        }
        System.out.println(sb.toString().trim() + "]");
    }

    public static <T> List<T> runFilter(List<T> list, Filter<T> filter) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (!filter.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    //////////////// 6. Сокращение ////////////////
    public static void runTask6() {
        List<String> data1 = List.of("qwerty", "asdfg", "zx");
        List<Double> data2 = List.of(1D, -3.7);
        List<List<Integer>> data3 = List.of(List.of(1, 2, 3, 4), List.of(-5, -2, -4), List.of(0, 1, 2));


        // 1
        System.out.println(runReduce(data1, new StringReducer(), "default"));
        // 2
        System.out.println(runReduce(data2, new DoubleReducer(), 0d));
        // 3
        System.out.println(runReduce(data3, new ArrayReducer(), 0));
    }

    public static <T, P> P runReduce(List<T> list, Reducer<T, P> reducer, P alternative) {
        // метод не выбросит исключение (условие задания)
        if (list.isEmpty()) {
            return alternative;
        }

        P result = reducer.reduce(list);

        // метод гарантированно не вернет null (условие задания)
        if (result == null) {
            return alternative;
        } else {
            return result;
        }
    }


    //////////////// 5. Коллекционирование ////////////////
    public static void runTask7() {
        List<Double> doubleData = List.of(1d, 2d, -3d, 4d);
        List<String> stringData1 = List.of("qwerty", "asdfg", "zx", "qw");
        List<String> stringData2 = List.of("qwerty", "asdfg", "qwerty", "qw");

        // 1
        List<List<Double>> result1 = runSeparationToLists(doubleData, new TwoSublistsCreationWay(), new PositiveAndNegativeTransportWay());
        System.out.println(result1);

        // 2
        List<List<String>> result2 = runSeparationToLists(stringData1, new StringLengthCreationWay(), new StringLengthTransportWay());
        System.out.println(result2);

        // 3
        List<List<String>> result3 = runSeparationToLists(stringData2, new UniqueStringsCreationWay(), new UniqueStringsTransportWay());
        System.out.println(result3);
    }

    public static <T> List<List<T>> runSeparationToLists(List<T> list, ListCreationWay<T> creationWay, TransportWay<T> transportWay) {
        List<List<T>> createdList = creationWay.createList(list);

        for (T element : list) {
            try {
                createdList.get(transportWay.transport(element)).add(element);
            } catch (IllegalStateException ignored) {}
        }

        List<List<T>> result = new ArrayList<>();
        for (List<T> subList : createdList) {
            if (subList != null) {
                result.add(subList);
            }
        }

        return result;
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
