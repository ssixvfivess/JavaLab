import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://docs.google.com/document/d/1jZ8z_uvypOGy2DRBP0OOIIhQHrsLdtB2Eqk0GZI0l5Q/edit?tab=t.0#heading=h.30j0zll

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("0. Выход");
            System.out.println("1. Создать имена");
            System.out.println("2. Создать дома");
            System.out.println("3. Создать сотрудников и отделы");
            System.out.println("4. Вывести список сотрудников отдела");
            System.out.println("5. Создать имена (расширенная)");
            System.out.println("6. Работа с дробями");

            int choice = getIntInput("Введите число от 0 до 6: ", 0, 6);

            switch (choice) {
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                case 1:
                    createNames();
                    break;
                case 2:
                    createHouses();
                    break;
                case 3:
                    createEmployeesAndDepartments();
                    break;
                case 4:
                    printDepartmentEmployees();
                    break;
                case 5:
                    createExtendedNames();
                    break;
                case 6:
                    workWithFractions();
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

        String firstName2 = getStringInput("Введите ФАМИЛИЮ для второго имени: ");
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
    }

    private static void createHouses() {
        System.out.println("Создание домов:");
        int floors1 = getIntInput("Введите количество этажей для первого дома: ", 1, Integer.MAX_VALUE);
        House house1 = new House(floors1);

        int floors2 = getIntInput("Введите количество этажей для второго дома: ", 1, Integer.MAX_VALUE);
        House house2 = new House(floors2);

        int floors3 = getIntInput("Введите количество этажей для третьего дома: ", 1, Integer.MAX_VALUE);
        House house3 = new House(floors3);

        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);
    }

    private static void createEmployeesAndDepartments() {
        System.out.println("Создание сотрудников и отделов:");
        String emp1Name = getStringInput("Введите имя первого сотрудника: ");
        Employee emp1 = new Employee(emp1Name);

        String emp2Name = getStringInput("Введите имя второго сотрудника: ");
        Employee emp2 = new Employee(emp2Name);

        String emp3Name = getStringInput("Введите имя третьего сотрудника: ");
        Employee emp3 = new Employee(emp3Name);

        String emp4Name = getStringInput("Введите имя начальника отдела: ");
        Employee emp4 = new Employee(emp4Name);

        String departmentName = getStringInput("Введите название отдела: ");
        Department department = new Department(departmentName, emp4);

        emp1.setDepartment(department);
        emp2.setDepartment(department);
        emp3.setDepartment(department);
        emp4.setDepartment(department);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println(emp4);
    }

    private static void printDepartmentEmployees() {
        System.out.println("Вывод списка сотрудников отдела:");
        String emp1Name = getStringInput("Введите имя первого сотрудника: ");
        Employee emp1 = new Employee(emp1Name);

        String emp2Name = getStringInput("Введите имя второго сотрудника: ");
        Employee emp2 = new Employee(emp2Name);

        String emp3Name = getStringInput("Введите имя третьего сотрудника: ");
        Employee emp3 = new Employee(emp3Name);

        String departmentName = getStringInput("Введите название отдела: ");
        Department department = new Department(departmentName, emp2);

        emp1.setDepartment(department);
        emp3.setDepartment(department);

        System.out.println("Сотрудники отдела " + departmentName + ":");
        for (Employee emp : department.getEmployees()) {
            System.out.println(emp);
        }
    }

    private static void createExtendedNames() {
        System.out.println("Создание имен (расширенная):");
        String firstName1 = getStringInput("Введите личное имя для первого имени: ");
        String lastName1 = getStringInput("Введите фамилию для первого имени: ");
        String middleName1 = getStringInput("Введите отчество для первого имени: ");
        Name name1 = new Name(firstName1, lastName1, middleName1);

        String firstName2 = getStringInput("Введите личное имя для второго имени: ");
        String lastName2 = getStringInput("Введите фамилию для второго имени: ");
        String middleName2 = getStringInput("Введите отчество для второго имени: ");
        Name name2 = new Name(firstName2, lastName2, middleName2);

        String firstName3 = getStringInput("Введите личное имя для третьего имени: ");
        String lastName3 = getStringInput("Введите фамилию для третьего имени: ");
        String middleName3 = getStringInput("Введите отчество для третьего имени: ");
        Name name3 = new Name(firstName3, lastName3, middleName3);

        String firstName4 = getStringInput("Введите личное имя для четвертого имени: ");
        String lastName4 = getStringInput("Введите фамилию для четвертого имени: ");
        String middleName4 = getStringInput("Введите отчество для четвертого имени: ");
        Name name4 = new Name(firstName4, lastName4, middleName4);

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
    }

    private static void workWithFractions() {
        System.out.println("Работа с дробями:");
        int numerator1 = getIntInput("Введите числитель для первой дроби: ", 1, Integer.MAX_VALUE);
        int denominator1 = getIntInput("Введите знаменатель для первой дроби: ", 1, Integer.MAX_VALUE);
        Fraction f1 = new Fraction(numerator1, denominator1);

        int numerator2 = getIntInput("Введите числитель для второй дроби: ", 1, Integer.MAX_VALUE);
        int denominator2 = getIntInput("Введите знаменатель для второй дроби: ", 1, Integer.MAX_VALUE);
        Fraction f2 = new Fraction(numerator2, denominator2);

        int numerator3 = getIntInput("Введите числитель для третьей дроби: ", 1, Integer.MAX_VALUE);
        int denominator3 = getIntInput("Введите знаменатель для третьей дроби: ", 1, Integer.MAX_VALUE);
        Fraction f3 = new Fraction(numerator3, denominator3);

        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));

        Fraction result = f1.add(f2).divide(f3).subtract(5);
        System.out.println("f1.sum(f2).div(f3).minus(5) = " + result);
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
        return scanner.nextLine();
    }
}

// Задача 1: Имена
class Name {
    private String firstName;
    private String lastName;
    private String middleName;

    public Name(String firstName, String lastName, String middleName) {
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

// Задача 2: Дом
class House {
    private int floors;

    public House(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        String suffix = "этажей";
        if (floors == 1) suffix = "этаж";
        else if (floors >= 2 && floors <= 4) suffix = "этажа";
        return "у дома " + floors + " " + suffix;
    }
}

// Задача 3 и 4: Сотрудники и отделы
class Employee {
    private String name;
    private Department department;

    public Employee(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
        department.addEmployee(this);
    }

    @Override
    public String toString() {
        if (department != null && department.getHead() == this) {
            return name + " начальник отдела " + department.getName();
        } else if (department != null) {
            return name + " работает в отделе " + department.getName() + ", начальник которого " + department.getHead().name;
        } else {
            return name + " не прикреплен к отделу";
        }
    }
}

class Department {
    private String name;
    private Employee head;
    private List<Employee> employees = new ArrayList<>();

    public Department(String name, Employee head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Employee getHead() {
        return head;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

// Задача 6: Дроби
class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(int number) {
        return subtract(new Fraction(number, 1));
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}