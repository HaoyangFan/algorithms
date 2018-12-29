package com.haoyangfan.algorithms.sorting;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class SortingTest {
  private static final Random randGen = new Random(System.currentTimeMillis());
  private static final int SIZE = 1000;
  private static Integer[] unsorted;
  private static Integer[] sorted;
  private static Integer[] reverse;

  private static boolean isSorted(Integer[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i - 1] > array[i]) {
        return false;
      }
    }
    return true;
  }

  @BeforeClass
  public static void setup() {
    unsorted = new Integer[SIZE];
    int i = 0;
    while (i < unsorted.length) {
      int j = randGen.nextInt(unsorted.length * 10);
      unsorted[i++] = j;
    }
    sorted = new Integer[SIZE];
    i = 0;
    while (i < sorted.length) {
      sorted[i] = i++;
    }
    reverse = new Integer[SIZE];
    i = 0;
    while (i < reverse.length) {
      reverse[i] = reverse.length - 1 - i++;
    }
  }

  @Test
  public void testBubbleSorts() {
    // Bubble sort
    Integer[] temp;
    temp = unsorted.clone();
    BubbleSort.sort(temp);
    assertTrue("Bubble sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
    temp = sorted.clone();
    BubbleSort.sort(temp);
    assertTrue("Bubble sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
    temp = reverse.clone();
    BubbleSort.sort(temp);
    assertTrue("Bubble sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
  }

  @Test
  public void testSelectionSorts() {
    // Selection sort
    Integer[] temp;
    temp = unsorted.clone();
    SelectionSort.sort(temp);
    assertTrue("Selection sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
    temp = sorted.clone();
    SelectionSort.sort(temp);
    assertTrue("Selection sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
    temp = reverse.clone();
    SelectionSort.sort(temp);
    assertTrue("Selection sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
  }

  @Test
  public void testInsertionSorts() {
    // Selection sort
    Integer[] temp;
    temp = unsorted.clone();
    InsertionSort.sort(temp);
    assertTrue("Insertion sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
    temp = sorted.clone();
    InsertionSort.sort(temp);
    assertTrue("Insertion sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
    temp = reverse.clone();
    InsertionSort.sort(temp);
    assertTrue("Insertion sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
  }

  @Test
  public void testShellSorts() {
    // Shell sort
    Integer[] temp;
    temp = unsorted.clone();
    ShellSort.sort(temp);
    assertTrue("Shell sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
    temp = sorted.clone();
    ShellSort.sort(temp);
    assertTrue("Shell sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
    temp = reverse.clone();
    ShellSort.sort(temp);
    assertTrue("Shell sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
  }

  @Test
  public void testMergeSorts() {
    // Merge sort
    Integer[] temp;
    temp = unsorted.clone();
    MergeSort.sort(temp);
    assertTrue("Merge sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
    temp = sorted.clone();
    MergeSort.sort(temp);
    assertTrue("Merge sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
    temp = reverse.clone();
    MergeSort.sort(temp);
    assertTrue("Merge sort unsorted error. result=" + Arrays.toString(temp), isSorted(temp));
  }

  @AfterClass
  public static void teardown() {
    unsorted = null;
    sorted = null;
    reverse = null;
  }
}
