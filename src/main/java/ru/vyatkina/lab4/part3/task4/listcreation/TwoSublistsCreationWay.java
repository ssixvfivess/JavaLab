package ru.vyatkina.lab4.part3.task4.listcreation;

import java.util.ArrayList;
import java.util.List;

public class TwoSublistsCreationWay implements ListCreationWay<Double> {
    @Override
    public List<List<Double>> createList(List<Double> list) {
        return List.of(new ArrayList<>(), new ArrayList<>());
    }
}
