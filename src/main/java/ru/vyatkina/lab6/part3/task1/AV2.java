package ru.vyatkina.lab6.part3.task1;

import ru.vyatkina.lab6.part2.task3.ToString;
import ru.vyatkina.lab6.part2.task3.ToStringValue;

@ToString(ToStringValue.NO)
public class AV2 extends EntityV2 {
    @ToString(ToStringValue.YES)
    String s = "Hello";

    int x = 42; // По умолчанию YES, так как не помечено

    @ToString(ToStringValue.NO)
    String hidden = "Скрытый текст";
}
