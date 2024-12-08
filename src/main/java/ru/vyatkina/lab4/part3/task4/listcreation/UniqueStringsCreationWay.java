package ru.vyatkina.lab4.part3.task4.listcreation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueStringsCreationWay implements ListCreationWay<String> {
    @Override
    public List<List<String>> createList(List<String> list) {
        Set<String> set = new HashSet<>(list);

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < set.size(); i++) {
            result.add(new ArrayList<>());
        }

        return result;
    }
}
