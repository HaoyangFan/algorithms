package com.haoyangfan.algorithms.sorting;

/**
 * Bubble sort is a popular and easy-to-understand, but inefficient, sorting algorithm.
 * It works by repeatedly swapping adjacent elements that are out of order.
 *
 * <p>Property: nth pass will find the nth largest element and put it into its final place.
 *
 * <p>Time complexity:
 * worst: O(n^2)
 * average: O(n^2)
 * best: O(n)
 *
 * <p>Space: O(1), it is in-place sorting algorithm.
 *
 * <p>Bubble sort is a stable algorithm.
 *
 * <p>Reference:
 * https://en.wikipedia.org/wiki/Bubble_sort
 * CLRS p.40
 *
 * @param <T> generic type that must be comparable
 * @author HaoyangFan
 * @version 1.0
 * @since 12-26-2018
 */
public final class BubbleSort<T extends Comparable<? super T>> {
  /**
   * Hide the constructor.
   */
  private BubbleSort() {
  }

  /**
   * Sort the input array in ascending order according to the natural order of
   * element's type using bubble sort.
   * After each pass, the ith largest element will be put at (unsorted.length - i) position.
   *
   * @param unsorted the array to be sorted
   * @param <T>      element type of the array, must be comparable
   */
  public static <T extends Comparable<? super T>> void sort(final T[] unsorted) {
    if (unsorted == null || unsorted.length <= 1) {
      return; // base case
    }
    for (int i = 1; i < unsorted.length; i++) {
      boolean sorted = true;
      for (int j = 0; j < unsorted.length - i; j++) {
        // if current element is larger than the next element
        if (unsorted[j].compareTo(unsorted[j + 1]) > 0) {
          swap(unsorted, j, j + 1);
          sorted = false;
        }
      }
      // in case the array is already sorted, exit
      if (sorted) {
        break;
      }
    }
  }

  private static <T extends Comparable<? super T>> void swap(T[] nums, int i, int j) {
    T temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
