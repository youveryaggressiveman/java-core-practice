package dev.andrej.javacore.week01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class SecondLargestTest {

    @Test
    void returnsSecondLargestOfDistinctValues() {
        assertThat(SecondLargest.find(new int[] {3, 9, 1, 7})).isEqualTo(7);
    }

    @Test
    void worksWhenMaximumIsFirst() {
        assertThat(SecondLargest.find(new int[] {10, 2, 8})).isEqualTo(8);
    }

    @Test
    void worksWhenMaximumIsLast() {
        assertThat(SecondLargest.find(new int[] {2, 8, 10})).isEqualTo(8);
    }

    @Test
    void ignoresDuplicatesOfMaximum() {
        assertThat(SecondLargest.find(new int[] {5, 5, 3})).isEqualTo(3);
    }

    @Test
    void worksWithNegativeNumbers() {
        assertThat(SecondLargest.find(new int[] {-1, -5, -3})).isEqualTo(-3);
    }

    @Test
    void worksWithExactlyTwoElements() {
        assertThat(SecondLargest.find(new int[] {1, 2})).isEqualTo(1);
    }

    @Test
    void worksWithExtremeValues() {
        assertThat(SecondLargest.find(new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE})).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void throwsWhenAllElementsAreEqual() {
        assertThatThrownBy(() -> SecondLargest.find(new int[] {4, 4, 4}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwsWhenFewerThanTwoElements() {
        assertThatThrownBy(() -> SecondLargest.find(new int[] {1}))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> SecondLargest.find(new int[0]))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwsOnNull() {
        // Конвенция JDK и Effective Java (п. 49): null-аргумент -> NullPointerException, см. Objects.requireNonNull
        assertThatThrownBy(() -> SecondLargest.find(null))
            .isInstanceOf(NullPointerException.class);
    }
}
