package ru.vyatkina.lab4.part3.task3;

import java.util.List;

public interface Reducer<T, P> {
    P reduce(List<T> list);
}
