package ru.vyatkina.lab4.part3.task1;

public class AbsApplyable implements Applyable<Double, Double>{
    @Override
    public Double apply(Double aDouble) {
        return Math.abs(aDouble);
    }
}
