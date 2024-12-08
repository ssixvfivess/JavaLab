package ru.vyatkina.lab4.part3.task2;

public class MinLengthFilter implements Filter<String> {
    private final int minLength;

    public MinLengthFilter(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean test(String s) {
        return s.length() < minLength;
    }
}
