package com.haoyangfan.algorithms.sorting;

/**
 * Shell Sort is an in-place comparison-based sorting algorithm which can be considered as
 * generalization of Insertion Sort. It starts by sorting pairs of elements far apart
 * from each other, then progressively reducing the gap between elements to be compared.
 * Starting with far apart elements, it can move some out-of-place elements into position
 * faster than a simple nearest neighbor exchange. The time complexity of this algorithms
 * is still an open problem for now. For worst gap sequence, the worst-time complexity is O(n^2)
 * while a lot of well-know sequences have worst time complexity lower than it
 * (e.g. 3x+1 sequence has worst-time complexity of O(n^1.5)
 *
 * @param <T> the generic type that must be comparable
 * @author Haoyang Fan
 * @version 1.0
 * @since 12-29-2018
 */

public final class ShellSort<T extends Comparable<? super T>> {
  /**
   * Hide the constructor.
   */
  private ShellSort() {
  }

  /**
   * Sort the input array in ascending order according to the natural order of
   * element's type using shell sort.
   *
   * @param unsorted the array to be sorted
   * @param <T>      element type of the array, must be comparable
   */
  public static <T extends Comparable<? super T>> void sort(final T[] unsorted) {
    if (unsorted == null || unsorted.length <= 1) {
      return;
    }
    int n = unsorted.length;
    int h = 1;  // initial gap size be 1
    while (h < n / 3) {
      h = 3 * h + 1;
    }
    // starting from large gap size, partially sort the array for each possible gap size
    while (h >= 1) {
      // h-sort the array
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && unsorted[j].compareTo(unsorted[j - h]) < 0; j -= h) {
          swap(unsorted, j, j - h);
        }
      }
      // next time sort array using smaller gap size
      h /= 3;
    }
  }

  private static <T extends Comparable<? super T>> void swap(T[] nums, int i, int j) {
    T temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
