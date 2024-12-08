package ru.vyatkina.lab4.part3.task1;


public class MaxInArrayApplyable implements Applyable<int[], Integer> {
    // Ищет максимум в массиве чисел
    @Override
    public Integer apply(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
