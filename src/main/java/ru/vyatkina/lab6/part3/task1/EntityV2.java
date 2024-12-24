package ru.vyatkina.lab6.part3.task1;

import ru.vyatkina.lab6.part2.task3.ToString;
import ru.vyatkina.lab6.part2.task3.ToStringValue;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class EntityV2 {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "{");
        Map<String, String> fieldMap = new HashMap<>();

        // Получаем класс текущего объекта
        Class<?> clazz = this.getClass();

        // Проверяем аннотацию на уровне класса
        ToString classAnnotation = clazz.getAnnotation(ToString.class);
        boolean includeAllFields = true; // По умолчанию включаем все поля

        if (classAnnotation != null && classAnnotation.value() == ToStringValue.NO) {
            includeAllFields = false; // Если класс помечен как NO, отключаем включение всех полей
        }

        // Обрабатываем все суперклассы
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true); // Делаем поле доступным для чтения
                try {
                    // Проверяем аннотацию на уровне поля
                    ToString fieldAnnotation = field.getAnnotation(ToString.class);
                    boolean includeField = true; // По умолчанию включаем поле

                    if (!includeAllFields || fieldAnnotation != null && fieldAnnotation.value() == ToStringValue.NO) {
                        includeField = false; // Поле помечено как NO, исключаем его
                    }

                    if (includeField) {
                        // Получаем имя поля и его значение
                        String key = field.getName();
                        String value = String.valueOf(field.get(this));
                        fieldMap.put(key, value);
                    }
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
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 1);
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setLength(sb.length() - 1);
        }

        return sb.append("}").toString();
    }
}

