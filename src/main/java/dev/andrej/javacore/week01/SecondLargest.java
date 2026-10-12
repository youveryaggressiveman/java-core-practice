package dev.andrej.javacore.week01;

import java.util.Objects;

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
        Objects.requireNonNull(nums, "nums");

        if (nums.length <= 1) {
            throw new IllegalArgumentException("nums length is less than 2");
        }

        int max = nums[0];
        int second = 0;

        boolean secondFound = false;

        for (int num : nums) {
            if (num > max) {
                second = max;
                max = num;
                secondFound = true;
            } else if (num < max && (!secondFound || num > second)) {
                second = num;
                secondFound = true;
            }
        }

        if (!secondFound) {
            throw new IllegalArgumentException("no second largest");
        }

        return second;
    }
}
