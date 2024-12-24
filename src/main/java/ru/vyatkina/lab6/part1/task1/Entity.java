package ru.vyatkina.lab6.part1.task1;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class Entity {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "{");
        Map<String, String> fieldMap = new HashMap<>();

        Class<?> clazz = this.getClass();

        // Обрабатываем все суперклассы
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true); // Делаем поле доступным для чтения
                try {
                    // Получаем имя поля и его значение
                    String key = field.getName();
                    String value = String.valueOf(field.get(this));
                    fieldMap.put(key, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            clazz = clazz.getSuperclass(); // Переходим к суперклассу
        }

        // Формируем строку в формате "ключ=значение"
        for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
        }

        // Удаляем последнюю запятую и пробел, если они есть
        if (!sb.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        return sb.append("}").toString();
    }
}