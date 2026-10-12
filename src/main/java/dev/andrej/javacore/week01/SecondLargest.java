package dev.andrej.javacore.week01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Задача 1. Второй по величине элемент массива среди различных значений.
 *
 * <p>Требования: один проход, O(n) по времени, O(1) по памяти, без коллекций.
 * Контракт описан тестами в {@code SecondLargestTest}.
 */
public final class SecondLargest {

    private SecondLargest() {
        // утилитный класс: экземпляры не нужны
    }

    /**
     * @param nums массив, минимум два различных значения
     * @return второе по величине значение
     * @throws NullPointerException     если {@code nums == null}
     * @throws IllegalArgumentException если различных значений меньше двух
     */
    public static int find(int[] nums) {
        if(nums == null)
            throw new NullPointerException("nums is null");

        if(nums.length <= 1){
            throw new IllegalArgumentException("nums length is less than 1");
        }

        ArrayList<Integer> mas = new ArrayList<>();

        var max = Arrays.stream(nums).max().getAsInt();
        var value = Integer.MIN_VALUE;
        for(Integer num : nums) {
            if (num < max &&  num > value) {
                value = num;
            }

            if(!mas.contains(num)){
                mas.add(num);
            }
        }

        if(mas.size() < 2) {
            throw new IllegalArgumentException("different size is lower than 2");
        }

        return value;
    }
}
