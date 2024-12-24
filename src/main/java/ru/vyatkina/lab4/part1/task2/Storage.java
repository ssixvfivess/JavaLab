package ru.vyatkina.lab4.part1.task2;

public class Storage<T> {
    private final T value;

    public Storage(T value) { //к
        this.value = value;
    }

    public T getValue(T alt) { //возвращает значение
        if (isEmpty()) {
            return alt;
        }
        return value;
    }

    public boolean isEmpty() { //проверка на пустоту
        return value == null;
    }
}
