package ru.vyatkina.lab4.part3.task3;

import java.util.List;

public class DoubleReducer implements Reducer<Double, Double> {
    @Override
    public Double reduce(List<Double> list) {
        double sum = 0;
        for (Double d : list) {
            sum += d;
        }
        return sum;
    }
}
