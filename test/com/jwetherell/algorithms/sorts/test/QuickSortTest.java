package com.jwetherell.algorithms.sorts;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    void testSortEmptyArray() {
        Integer[] input = {};
        Integer[] sorted = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(new Integer[]{}, sorted, "Empty array should be unchanged.");
    }

    @Test
    void testSortLargeArray() {
        int size = 100000;
        Integer[] input = new Integer[size];
        Integer[] expected = new Integer[size];

        // fill input with reverse order, expected with sorted order
        for(int i = 0; i < size; i++) {
            input[i] = size - i;
            expected[i] = i + 1;
        }

        Integer[] sorted = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(expected, sorted, "Large arrayy should be sorted.");
    }

    @Test
    void testSortSortedArray() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] sorted = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, sorted, "Already sorted array should be unchanged.");
    }

    @Test
    void testSortSingleElement() {
        Integer[] input = {15};
        Integer[] sorted = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(new Integer[]{15}, sorted, "Single element array should be unchanged.");
    }

    @Test
    void testSortUnsorted() {
        Integer[] input = {72, 9, 32, 16, 50};
        Integer[] sorted = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(new Integer[]{9, 16, 32, 50, 72}, sorted, "Unsorted array should be sorted.");
    }

    @Test
    void testSortDuplicates() {
        Integer[] input = {5, 5, 10, 3, 1};
        Integer[] sorted = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(new Integer[]{1, 3, 5, 5, 10}, sorted, "Duplicates array should be sorted.");
    }
}