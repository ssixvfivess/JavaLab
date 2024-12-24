/*package ru.vyatkina.lab4.part2.task3;

import ru.vyatkina.lab2.part1.task1.Point;

// Точка в пространстве (Из лаб-3 - задание 3.5)
public class Point3D extends Point {
    private final long z;

    public Point3D(long x, long y, long z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "{%d;%d;%d}".formatted(this.x, this.y, this.z);
    }
}

public class Task3 implements Point3D { // от какого интерфеса наследуется то
    @Override
    public void run() {
        Box<Point> box = new Box<>();
        test(box);
        printValue(box);
    }

    private void test(Box<? super Point3D> box) {
        box.put(new Point3D(1,2, 3));
    }

    private void printValue(Box<? super Point3D> box) {
        System.out.println("Значение: " + box.get());
    }
}
*/