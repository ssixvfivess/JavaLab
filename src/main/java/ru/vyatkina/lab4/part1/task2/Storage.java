package ru.vyatkina.lab4.part1.task2;

public class Storage<T> {
    private final T value;

    public Storage(T value) {
        this.value = value;
    }

    public T getValue(T alt) {
        if (isEmpty()) {
            return alt;
        }
        return value;
    }

    public boolean isEmpty() {
        return value == null;
    }
}
