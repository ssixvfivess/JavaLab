import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// отчет: https://docs.google.com/document/d/19L1Ff0gXfrCqvnmnbus2gL4BRvWnmoIc2zFKqg4ffT8/edit?usp=sharing

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("0. Выход");
            System.out.println("1. Работа с дробями 1");
            System.out.println("2. Работа с дробями 2");
            System.out.println("3. Работа с дробями 3");
            System.out.println("4. Работа с дробями 4");
            System.out.println("5. Создать имена (расширенная)");
            System.out.println("6. Создать секрет");
            System.out.println("7. Решение готовых уравнений");

            int choice = getIntInput("Введите число от 0 до 8: ", 0, 8);

            switch (choice) {
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                case 1:
                    workWithFractions1();
                    break;
                case 2:
                    workWithFractions2();
                    break;
                case 3:
                    workWithFractions3();
                    break;
                case 4:
                    workWithFractions4();
                    break;
                case 5:
                    createNames();
                    break;
                case 6:
                    createSecret();
                    break;
                case 7:
                    performAdditions();
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void createNames() {
        System.out.println("Создание имен:");
        String firstName1 = getStringInput("Введите ИМЯ для первого имени: ");
        String lastName1 = getStringInput("Введите ФАМИЛИЮ для первого имени: ");
        String middleName1 = getStringInput("Введите ОТЧЕСТВО для первого имени: ");
        Name name1 = new Name(firstName1, lastName1, middleName1);

        String firstName2 = getStringInput("Введите ИМЯ для второго имени: ");
        String lastName2 = getStringInput("Введите ФАМИЛИЮ для второго имени: ");
        String middleName2 = getStringInput("Введите ОТЧЕСТВО для второго имени: ");
        Name name2 = new Name(firstName2, lastName2, middleName2);

        String firstName3 = getStringInput("Введите ИМЯ для третьего имени: ");
        String lastName3 = getStringInput("Введите ФАМИЛИЮ для третьего имени: ");
        String middleName3 = getStringInput("Введите ОТЧЕСТВО для третьего имени: ");
        Name name3 = new Name(firstName3, lastName3, middleName3);

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
    } //имена

    private static void createSecret() {
        System.out.println("Создание нового секрета:");
        String keeperName = getStringInput("Введите имя хранителя: ");
        String secretText = getStringInput("Введите текст секрета: ");
        Secret secret = new Secret(keeperName, secretText);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("0. Выход");
            System.out.println("1. Передать секрет другому человеку");
            System.out.println("2. Узнать порядок хранителя");
            System.out.println("3. Узнать количество людей, узнавших секрет после текущего хранителя");
            System.out.println("4. Узнать имя N-го человека, узнавшего секрет");
            System.out.println("5. Узнать разницу в количестве символов текста секрета с N-ым человеком");

            int choice = getIntInput("Введите число от 0 до 5: ", 0, 5);

            switch (choice) {
                case 0:
                    System.out.println("Выход из создания секрета.");
                    return;
                case 1:
                    String newKeeperName = getStringInput("Введите имя нового хранителя: ");
                    secret = secret.tellSecretTo(newKeeperName);
                    break;
                case 2:
                    System.out.println("Порядок хранителя: " + secret.getKeeperOrder());
                    break;
                case 3:
                    System.out.println("Количество людей, узнавших секрет после текущего хранителя: " + secret.getNumberOfPeopleKnowAfter());
                    break;
                case 4:
                    int n = getIntInput("Введите N (положительное для следующего, отрицательное для предыдущего): ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    try {
                        System.out.println("Имя N-го человека, узнавшего секрет: " + secret.getKeeperName(n));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    int m = getIntInput("Введите N (положительное для следующего, отрицательное для предыдущего): ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    try {
                        System.out.println("Разница в количестве символов текста секрета с N-ым человеком: " + secret.getTextDifferenceWith(m));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }


    private static void workWithFractions1() {
        System.out.println("Работа с дробями:");
        int numerator1 = getIntInput("Введите числитель для первой дроби: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int denominator1 = getIntInput("Введите знаменатель для первой дроби: ", 1, Integer.MAX_VALUE);
        Fraction1 f1 = new Fraction1(numerator1, denominator1);

        int numerator2 = getIntInput("Введите числитель для второй дроби: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int denominator2 = getIntInput("Введите знаменатель для второй дроби: ", 1, Integer.MAX_VALUE);
        Fraction1 f2 = new Fraction1(numerator2, denominator2);

        int numerator3 = getIntInput("Введите числитель для третьей дроби: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int denominator3 = getIntInput("Введите знаменатель для третьей дроби: ", 1, Integer.MAX_VALUE);
        Fraction1 f3 = new Fraction1(numerator3, denominator3);

        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));

        Fraction1 result = f1.add(f2).divide(f3).subtract(5);
        System.out.println("f1.add(f2).divide(f3).subtract(5) = " + result);
    }

    private static void workWithFractions2() {
        System.out.println("Работа с дробями:");
        int numerator1 = getIntInput("Введите числитель для первой дроби: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int denominator1 = getIntInput("Введите знаменатель для первой дроби: ", 1, Integer.MAX_VALUE);
        Fraction2 f1 = new Fraction2(numerator1, denominator1);

        int numerator2 = getIntInput("Введите числитель для второй дроби: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int denominator2 = getIntInput("Введите знаменатель для второй дроби: ", 1, Integer.MAX_VALUE);
        Fraction2 f2 = new Fraction2(numerator2, denominator2);

        int numerator3 = getIntInput("Введите числитель для третьей дроби: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int denominator3 = getIntInput("Введите знаменатель для третьей дроби: ", 1, Integer.MAX_VALUE);
        Fraction2 f3 = new Fraction2(numerator3, denominator3);

        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));

        Fraction2 result = f1.add(f2).divide(f3).subtract(5);
        System.out.println("f1.add(f2).divide(f3).subtract(5) = " + result);
    }

    private static void workWithFractions3() {
        System.out.println("Работа с дробями:");
        int numerator1 = getIntInput("Введите числитель для первой дроби: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int denominator1 = getIntInput("Введите знаменатель для первой дроби: ", 1, Integer.MAX_VALUE);
        Fraction3 f1 = new Fraction3(numerator1, denominator1);

        int numerator2 = getIntInput("Введите числитель для второй дроби: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int denominator2 = getIntInput("Введите знаменатель для второй дроби: ", 1, Integer.MAX_VALUE);
        Fraction3 f2 = new Fraction3(numerator2, denominator2);

        int numerator3 = getIntInput("Введите числитель для третьей дроби: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int denominator3 = getIntInput("Введите знаменатель для третьей дроби: ", 1, Integer.MAX_VALUE);
        Fraction3 f3 = new Fraction3(numerator3, denominator3);

        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));

        Fraction3 result = f1.add(f2).divide(f3).subtract(5);
        System.out.println("f1.add(f2).divide(f3).subtract(5) = " + result);
        System.out.println("intValue: " + result.intValue());
        System.out.println("longValue: " + result.longValue());
        System.out.println("floatValue: " + result.floatValue());
        System.out.println("doubleValue: " + result.doubleValue());
    }

    private static void workWithFractions4() {
        System.out.println("Работа с дробями:");
        int numerator1 = getIntInput("Введите числитель для первой дроби: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int denominator1 = getIntInput("Введите знаменатель для первой дроби: ", 1, Integer.MAX_VALUE);
        Fraction4 f1 = new Fraction4(numerator1, denominator1);

        int numerator2 = getIntInput("Введите числитель для второй дроби: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int denominator2 = getIntInput("Введите знаменатель для второй дроби: ", 1, Integer.MAX_VALUE);
        Fraction4 f2 = new Fraction4(numerator2, denominator2);

        int numerator3 = getIntInput("Введите числитель для третьей дроби: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int denominator3 = getIntInput("Введите знаменатель для третьей дроби: ", 1, Integer.MAX_VALUE);
        Fraction4 f3 = new Fraction4(numerator3, denominator3);

        System.out.println("f1.equals(f2): " + f1.equals(f2)); // true
        System.out.println("f1.equals(f3): " + f1.equals(f3)); // false

        System.out.println("f1.hashCode(): " + f1.hashCode());
        System.out.println("f2.hashCode(): " + f2.hashCode());
        System.out.println("f3.hashCode(): " + f3.hashCode());
    }


    private static void performAdditions() {
        System.out.println("Сложение числовых значений:");
        Number[] values1 = {2, new Fraction3(3, 5), 2.3};
        System.out.println("2 + 3/5 + 2.3 = " + sum(values1));

        Number[] values2 = {3.6, new Fraction3(49, 12), 3, new Fraction3(3, 2)};
        System.out.println("3.6 + 49/12 + 3 + 3/2 = " + sum(values2));

        Number[] values3 = {new Fraction3(1, 3), 1};
        System.out.println("1/3 + 1 = " + sum(values3));

    }

    private static double sum(Number[] values) {
        double sum = 0;
        for (Number value : values) {
            sum += value.doubleValue();
        }
        return sum;
    }

    private static int getIntInput(String prompt, int min, int max) {
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

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}

class Fraction1 {
    private final int numerator;
    private final int denominator;

    public Fraction1(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        // Убеждаемся, что знаменатель положительный, а знак дроби отражается в числителе
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Fraction1 add(Fraction1 other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction1(newNumerator, newDenominator);
    }

    public Fraction1 subtract(Fraction1 other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction1(newNumerator, newDenominator);
    }

    public Fraction1 multiply(Fraction1 other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction1(newNumerator, newDenominator);
    }

    public Fraction1 divide(Fraction1 other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction1(newNumerator, newDenominator);
    }

    public Fraction1 subtract(int number) {
        return new Fraction1(this.numerator - number * this.denominator, this.denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

final class Fraction2 {
    private final int numerator;
    private final int denominator;

    public Fraction2(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        // Убеждаемся, что знаменатель положительный, а знак дроби отражается в числителе
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Fraction2 add(Fraction2 other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction2(newNumerator, newDenominator);
    }

    public Fraction2 subtract(Fraction2 other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction2(newNumerator, newDenominator);
    }

    public Fraction2 multiply(Fraction2 other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction2(newNumerator, newDenominator);
    }

    public Fraction2 divide(Fraction2 other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction2(newNumerator, newDenominator);
    }

    public Fraction2 subtract(int number) {
        return new Fraction2(this.numerator - number * this.denominator, this.denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
/*Финальный класс (final): Класс Fraction3 объявлен как final, что означает (не может иметь подклассов). Это предотвращает создание подклассов, которые могли бы изменять состояние дроби.

Неизменяемое состояние: Поля numerator и denominator объявлены как final, что означает, что они не могут быть изменены после инициализации.

Методы возвращают новые экземпляры: Все методы, которые изменяют дробь (например, add, subtract, multiply, divide), возвращают новые экземпляры Fraction3, а не изменяют текущий экземпляр.*/

final class Fraction3 extends Number implements Serializable {
    private final int numerator;
    private final int denominator;

    public Fraction3(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        // Убеждаемся, что знаменатель положительный, а знак дроби отражается в числителе
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Fraction3 add(Fraction3 other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction3(newNumerator, newDenominator);
    }

    public Fraction3 subtract(Fraction3 other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction3(newNumerator, newDenominator);
    }

    public Fraction3 multiply(Fraction3 other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction3(newNumerator, newDenominator);
    }

    public Fraction3 divide(Fraction3 other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction3(newNumerator, newDenominator);
    }

    public Fraction3 subtract(int number) {
        return subtract(new Fraction3(number, 1));
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }
}

final class Fraction4 extends Number implements Serializable {
    private final int numerator;
    private final int denominator;

    public Fraction4(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        // Убеждаемся, что знаменатель положительный, а знак дроби отражается в числителе
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction4 fraction = (Fraction4) obj;
        return numerator * fraction.denominator == fraction.numerator * denominator;
    }

    @Override
    public int hashCode() {
        return 31 * this.numerator + this.denominator;
    }
}

//1.7
class Name {
    private final String firstName;
    private final String lastName;
    private final String middleName;

    public Name(String firstName, String lastName, String middleName) {
        if (firstName == null || firstName.isEmpty()) {
            if (lastName == null || lastName.isEmpty()) {
                if (middleName == null || middleName.isEmpty()) {
                    throw new IllegalArgumentException("Хотя бы один параметр должен быть не null и не пустой строкой.");
                }
            }
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (lastName != null) sb.append(lastName).append(" ");
        if (firstName != null) sb.append(firstName).append(" ");
        if (middleName != null) sb.append(middleName);
        return sb.toString().trim();
    }
}

//2.2
class Secret {
    private static final Random random = new Random();
    private final String text;
    private final String keeperName;
    private final List<String> keepers;

    public Secret(String keeperName, String text) {
        this.text = text;
        this.keeperName = keeperName;
        this.keepers = new ArrayList<>();
        this.keepers.add(keeperName);
        System.out.println(keeperName + " сказал что " + text);
    }

    private Secret(String keeperName, String text, List<String> keepers) {
        this.text = text;
        this.keeperName = keeperName;
        this.keepers = new ArrayList<>(keepers);
        this.keepers.add(keeperName);
        System.out.println(keeperName + " сказал что " + text);
    }

    public Secret tellSecretTo(String newKeeperName) {
        if (keepers.contains(newKeeperName)) {
            throw new IllegalArgumentException("Секрет уже был передан этому человеку.");
        }
        String newText = addRandomCharacters(text);
        return new Secret(newKeeperName, newText, this.keepers);
    }

    private String addRandomCharacters(String originalText) {
        int length = originalText.length();
        int n = length / 10;
        int x = random.nextInt(n + 1);
        StringBuilder sb = new StringBuilder(originalText);
        for (int i = 0; i < x; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            int randomPosition = random.nextInt(sb.length());
            sb.insert(randomPosition, randomChar);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return keeperName + ": это секрет!";
    }

    public int getKeeperOrder() {
        return keepers.indexOf(keeperName) + 1;
    }

    public int getNumberOfPeopleKnowAfter() {
        return keepers.size() - getKeeperOrder();
    }

    public String getKeeperName(int n) {
        int index = keepers.indexOf(keeperName) + n;
        if (index < 0 || index >= keepers.size()) {
            throw new IndexOutOfBoundsException("Нет такого хранителя.");
        }
        return keepers.get(index);
    }

    public int getTextDifferenceWith(int n) {
        int index = keepers.indexOf(keeperName) + n;
        if (index < 0 || index >= keepers.size()) {
            throw new IndexOutOfBoundsException("Нет такого хранителя.");
        }
        Secret otherSecret = new Secret(keepers.get(index), text, keepers);
        return Math.abs(this.text.length() - otherSecret.text.length());
    }
}