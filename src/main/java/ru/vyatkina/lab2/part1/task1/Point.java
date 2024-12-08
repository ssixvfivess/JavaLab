package ru.vyatkina.lab2.part1.task1;

// Точка (Из лаб-2 - задание 1.1)
public class Point {
    protected final long x;
    protected final long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{%d;%d}".formatted(this.x, this.y);
    }
}