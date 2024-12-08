package ru.vyatkina.lab4.part3.task4.transport;

import java.util.HashMap;
import java.util.Map;

public class UniqueStringsTransportWay implements TransportWay<String> {
    private Map<String, Integer> stringToIndexMap = new HashMap<>();

    @Override
    public Integer transport(String element) {
        // Если строка уже была добавлена в карту, кидаем исключение, чтобы в результате не было дубликатов
        if (stringToIndexMap.containsKey(element)) {
            throw new IllegalStateException();
        } else {
            // Если строка новая, добавляем её в карту и возвращаем новый индекс
            int newIndex = stringToIndexMap.size();
            stringToIndexMap.put(element, newIndex);
            return newIndex;
        }
    }
}
