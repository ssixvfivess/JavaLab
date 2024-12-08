package ru.vyatkina.lab4.part3.task3;

import java.util.List;

public class StringReducer implements Reducer<String, String> {
    @Override
    public String reduce(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(" ");
        }
        return sb.toString().trim();
    }
}
