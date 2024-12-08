package ru.vyatkina.lab3.part3.task5;

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