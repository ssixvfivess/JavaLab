package ru.vyatkina.lab06.part4.task1;

import ru.vyatkina.lab6.part2.task3.ToString;
import ru.vyatkina.lab6.part2.task3.ToStringValue;
import ru.vyatkina.lab6.part3.task1.EntityV2;
import ru.vyatkina.lab6.part3.task1.BV2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntityV2Test {

    @Test
    void testToStringWithAnnotations() {
        BV2 b = new BV2();

        // Ожидаемая строка: s=Hello, x=42, text=B
        String expected = "BV2{s=Hello, x=42, text=B}";

        // Проверяем, что метод toString() возвращает ожидаемую строку
        assertEquals(expected, b.toString());
    }

    @Test
    void testToStringWithNoFields() {
        // Создаем класс C, который не имеет полей с аннотацией YES
        @ToString(ToStringValue.NO)
        class CV2 extends EntityV2 {
            @ToString(ToStringValue.NO)
            String hiddenField = "Hidden";
        }

        CV2 c = new CV2();

        // Ожидаемая строка: пустая строка, так как все поля помечены как NO
        String expected = "CV2{}";

        // Проверяем, что метод toString() возвращает пустую строку
        assertEquals(expected, c.toString());
    }

    @Test
    void testToStringWithMixedFields() {
        // Создаем класс D с разными аннотациями
        class DV2 extends EntityV2 {
            @ToString(ToStringValue.YES)
            String visibleField = "Visible";

            @ToString(ToStringValue.NO)
            String hiddenField = "Hidden";

            int defaultField = 100; // По умолчанию YES
        }

        DV2 d = new DV2();

        // Ожидаемая строка: visibleField=Visible, defaultField=100
        String expected = "DV2{visibleField=Visible, defaultField=100}";

        // Проверяем, что метод toString() возвращает ожидаемую строку
        assertEquals(expected, d.toString());
    }
}

