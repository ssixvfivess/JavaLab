package ru.vyatkina.lab4.part3.task4.listcreation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringLengthCreationWay implements ListCreationWay<String> {
    @Override
    public List<List<String>> createList(List<String> list) {
        Set<Integer> lengths = new HashSet<>();

        for (String element : list) {
            lengths.add(element.length());
        }

        int maxLength = lengths.stream().max(Integer::compareTo).get();

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i <= maxLength; i++) {
            if (lengths.contains(i)) {
                result.add(new ArrayList<>());
            } else {
                result.add(null);
            }
        }

        return result;
    }
}
