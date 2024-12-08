package ru.vyatkina.lab4.part3.task1;

public class StringToLengthApplyable implements Applyable<String, Integer>{
    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
