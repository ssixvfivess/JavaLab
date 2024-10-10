import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.printf("Выберите действие от 0 до 20: ");
            while (!scan.hasNextInt()) {
                System.out.print("Ошибка! Введите целое число: ");
                scan.next(); // Очистка ввода
            }
            int d = scan.nextInt();
            if (d < 0 || d > 20) {
                System.out.println("Введено неверное значение!");
                continue;
            }

            switch (d) {
                case 0:
                    System.out.println("Выход из программы.");
                    scan.close();
                    return;
                case 1:
                    // Задача 1: Дробная часть
                    try {
                        System.out.print("Введите число: ");
                        double num1 = scan.nextDouble();
                        double result = fraction(num1);
                        DecimalFormat myFormat = new DecimalFormat("#.###");
                        System.out.println("Дробная часть числа: " + myFormat.format(result));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 2:
                    // Задача 3: Цифры в число
                    try {
                        System.out.print("Введите символ цифры от 0 до 9: ");
                        String input = scan.next();

                        if (input.length() != 1) {
                            throw new InputMismatchException("Введено более одного символа.");
                        }

                        char charInput = input.charAt(0);
                        if (charInput < '0' || charInput > '9') {
                            throw new InputMismatchException("Введен некорректный символ.");
                        }

                        System.out.println("Результат: " + main.charToNum(charInput));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 3:
                    // Задача 5: Проверка на двузначность
                    try {
                        System.out.print("Введите число для проверки на двузначность: ");
                        int intInput = scan.nextInt();
                        System.out.println("Результат: " + main.is2Digits(intInput));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 4:
                    // Задача 7: Проверка на вхождение в диапазон
                    try {
                        System.out.print("Введите левую границу диапазона: ");
                        int a = scan.nextInt();
                        System.out.print("Введите правую границу диапазона: ");
                        int b = scan.nextInt();
                        System.out.print("Введите число для проверки на вхождение в диапазон: ");
                        int num = scan.nextInt();
                        System.out.println("Результат: " + main.isInRange(a, b, num));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 5:
                    // Задача 9: Проверка на равенство трех чисел
                    try {
                        System.out.print("Введите первое число для сравнения: ");
                        int first = scan.nextInt();
                        System.out.print("Введите второе число для сравнения: ");
                        int second = scan.nextInt();
                        System.out.print("Введите третье число для сравнения: ");
                        int third = scan.nextInt();
                        System.out.println("Результат: " + main.isEqual(first, second, third));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 6:
                    // Задача 1: Вычисление модуля числа
                    try {
                        System.out.print("Введите число для вычисления модуля: ");
                        int absInput = scan.nextInt();
                        System.out.println("Модуль: " + main.abs(absInput));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 7:
                    // Задача 3: Тридцать пять
                    try {
                        System.out.print("Введите число для проверки на делимость на 3 или 5: ");
                        int is35Input = scan.nextInt();
                        System.out.println("Результат: " + main.is35(is35Input));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 8:
                    // Задача 5: Максимум из трех чисел
                    try {
                        System.out.print("Введите x: ");
                        int max1Input = scan.nextInt();
                        System.out.print("Введите y: ");
                        int max2Input = scan.nextInt();
                        System.out.print("Введите z: ");
                        int max3Input = scan.nextInt();
                        System.out.println("Максимальное из 3-х чисел: " + main.max3(max1Input, max2Input, max3Input));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 9:
                    // Задача 7: Двойная сумма
                    try {
                        System.out.print("Введите x: ");
                        int sum1Input = scan.nextInt();
                        System.out.print("Введите y: ");
                        int sum2Input = scan.nextInt();
                        System.out.println("Сумма x и y: " + main.sum2(sum1Input, sum2Input));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 10:
                    // Задача 9: День Недели
                    try {
                        System.out.print("Введите номер дня недели: ");
                        int x = scan.nextInt();
                        System.out.println(main.day(x));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 11:
                    // Задача 1: Числа подряд
                    try {
                        System.out.print("Введите число x: ");
                        int listNumsInput = scan.nextInt();
                        System.out.println("Результат строки: " + main.listNums(listNumsInput));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 12:
                    // Задача 3: Четные числа
                    try {
                        System.out.print("Введите число x: ");
                        int chetInput = scan.nextInt();
                        System.out.println("Четные числа от 0 до x: " + main.chet(chetInput));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 13:
                    // Задача 5: Длина числа
                    try {
                        System.out.print("Введите число x: ");
                        long numLenInput = scan.nextLong();
                        System.out.println("Длина вашего числа: " + main.numLen(numLenInput));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 14:
                    // Задача 7: Квадрат
                    try {
                        System.out.print("Введите число x: ");
                        int squareInput = scan.nextInt();
                        System.out.println("Квадрат размером x на x :");
                        main.square(squareInput);
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 15:
                    // Задача 9: Правый треугольник
                    try {
                        System.out.print("Введите число x: ");
                        int rightTriangleInput = scan.nextInt();
                        System.out.println("Правый треугольник x на x:");
                        main.rightTriangle(rightTriangleInput);
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 16:
                    // Задача 1: Поиск первого вхождения
                    try {
                        System.out.print("Введите размер массива: ");
                        int size = scan.nextInt();
                        int[] arr = new int[size];
                        System.out.println("Введите элементы массива:");
                        for (int i = 0; i < size; i++) {
                            arr[i] = scan.nextInt();
                        }
                        System.out.print("Введите число x для проверки вхождения: ");
                        int findFirstInput = scan.nextInt();
                        System.out.println("Число x в индексе " + main.findFirst(arr, findFirstInput));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 17:
                    // Задача 3: Поиск максимального по модулю
                    try {
                        System.out.print("Введите размер массива: ");
                        int size = scan.nextInt();
                        int[] arr = new int[size];
                        System.out.println("Введите элементы массива:");
                        for (int i = 0; i < size; i++) {
                            arr[i] = scan.nextInt();
                        }
                        System.out.println("Максимальный элемент массива по модулю: " + main.maxAbs(arr));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 18:
                    // Задача 5: Добавление массива в массив
                    try {
                        System.out.print("Введите размер первого массива: ");
                        int size = scan.nextInt();
                        int[] arr1 = new int[size];
                        System.out.println("Введите элементы первого массива:");
                        for (int i = 0; i < size; i++) {
                            arr1[i] = scan.nextInt();
                        }
                        System.out.print("Введите размер второго массива: ");
                        size = scan.nextInt();
                        int[] ins = new int[size];
                        System.out.println("Введите элементы второго массива:");
                        for (int i = 0; i < size; i++) {
                            ins[i] = scan.nextInt();
                        }
                        System.out.print("Введите в каком индексе первого массива разместить второй массив : ");
                        int pos = scan.nextInt();
                        System.out.println("Обновленный массив: " + Arrays.toString(main.add(arr1, ins, pos)));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 19:
                    // Задача 7: Возвратный реверс
                    try {
                        System.out.print("Введите размер массива: ");
                        int size = scan.nextInt();
                        int[] arr = new int[size];
                        System.out.println("Введите элементы массива:");
                        for (int i = 0; i < size; i++) {
                            arr[i] = scan.nextInt();
                        }
                        System.out.println("Элементы массива реверсом: " + Arrays.toString(main.reverseBack(arr)));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                case 20:
                    // Задача 9: Все вхождения
                    try {
                        System.out.print("Введите размер массива: ");
                        int size = scan.nextInt();
                        int[] arr = new int[size];
                        System.out.println("Введите элементы массива:");
                        for (int i = 0; i < size; i++) {
                            arr[i] = scan.nextInt();
                        }
                        System.out.print("Введите число x чтобы проверить сколько раз оно входит в массив: ");
                        int findAllInput = scan.nextInt();
                        System.out.println("число x находится в этих индексах: " + Arrays.toString(main.findAll(arr, findAllInput)));
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка: введено некорректное число.");
                        System.out.println("Ошибка: " + e.getMessage());
                        scan.nextLine();
                    }
                    break;
                default:
                    System.out.println("Неверный выбор действия.");
                    break;
            }
        }
    }


    //1 МОДУЛЬ
    // Задача 1: Дробная часть
    public static double fraction(double x) {
        return x % 1;
    }

    // Задача 3: Букву в число
    public int charToNum(char x) {
        return x - '0';
    }

    // Задача 5: Двузначное
    public boolean is2Digits(int x) {
        return (x >= 10 && x <= 99)||(x <= -10 && x >= -99);
    }

    // Задача 7: Диапазон
    public boolean isInRange(int a, int b, int num) {
        return num >= Math.min(a, b) && num <= Math.max(a, b);
    }

    // Задача 9: Равенство
    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }




    //2 МОДУЛЬ
    // Задача 1: Модуль Числа
    public int abs(int x) {
        return x >= 0 ? x : -x;
    }

    // Задача 3: Тридцать пять
    public boolean is35(int x) {
        boolean del3 = x % 3 == 0;
        boolean del5 = x % 5 == 0;
        return (del3 || del5) && !(del3 && del5);
    }

    // Задача 5: Тройной максимум
    public int max3(int x, int y, int z) {
        if (x > y && x > z) {
            return x;
        }
        if (y > x && y > z) {
            return y;
        }
        return z;
    }

    // Задача 7: Двойная сумма
    public int sum2(int x, int y) {
        int s = x + y;
        if (s >= 10 && s <= 19) {
            return 20;
        } else {
            return s;
        }
    }

    // Задача 9: День Недели
    public String day(int x) {
        switch (x) {
            case 0:
                return "Дни недели начинаются с 1";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "В неделе 7 дней :)";
        }
    }



    // 3 МОДУЛЬ
    // Задача 1: Числа подряд
    public String listNums(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= x; i++) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(i);
        }
        return result.toString();
    }

    // Задача 3: Четные числа
    public String chet(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= x; i += 2) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(i);
        }
        return result.toString();
    }

    // Задача 5: Длина числа
    public int numLen(long x) {
        return String.valueOf(Math.abs(x)).length();
    }

    // Задача 7: Квадрат
    public void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    // Задача 9: Правый треугольник
    public void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < x - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }



    //4 МОДУЛЬ
    // Задача 1: Поиск первого значения
    public int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // Задача 3: Поиск максимального
    public int maxAbs(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (Math.abs(num) > Math.abs(max)) {
                max = num;
            }
        }
        return max;
    }

    // Задача 5: Добавление массива в массив
    public int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];
        System.arraycopy(arr, 0, result, 0, pos);
        System.arraycopy(ins, 0, result, pos, ins.length);
        System.arraycopy(arr, pos, result, pos + ins.length, arr.length - pos);
        return result;
    }

    // Задача 7: Возвратный реверс
    public int[] reverseBack(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    // Задача 9: Все вхождения
    public int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int num : arr) {
            if (num == x) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[index++] = i;
            }
        }
        return result;
    }
}