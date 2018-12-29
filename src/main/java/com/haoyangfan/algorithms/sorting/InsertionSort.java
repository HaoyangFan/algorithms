package com.haoyangfan.algorithms.sorting;

/**
 * Insertion Sort is an in-place, comparison-based sorting algorithm that builds the final sorted list
 * one item at a time. During each pass, the first k-1elements in the list are sorted and insertion sort
 * will scan through these elements to find the proper position to insert the kth element.
 * Similar to Selection Sort, it has O(n^2) time complexity (comparisons) for the worst and average case,
 * but O(n) time complexity for the best case.
 *
 * <p>Time complexity:
 * worst: O(n^2)
 * average: O(n^2)
 * best: O(n)
 *
 * <p>Space: O(1), it is in-place sorting algorithm.
 *
 * <p>insertion sort is a stable algorithm.
 *
 * <p>Property:
 * 1. efficient for small size array
 * 2. no auxiliary space needed, in-place sorting
 *
 * @param <T> the generic type that must be comparable
 */
public final class InsertionSort<T extends Comparable<? super T>> {
  /**
   * Hide the constructor.
   */
  private InsertionSort() {
  }

  /**
   * Sort the input array in ascending order according to the natural order of
   * element's type using insertion sort.
   * After each pass, the first i elements are sorted in ascending order.
   *
   * <p>The implementation idea is from CLRS Ch2.1, which shift all elements > current
   * value rightward and insert current value at proper position. This solution
   * is slightly faster than the swap-based solution below because I/O is less.
   *
   * @param unsorted the array to be sorted
   * @param <T>      element type of the array, must be comparable
   */
  public static <T extends Comparable<? super T>> void sort(T[] unsorted) {
    if (unsorted == null || unsorted.length <= 1) {
      return;
    }
    // from CLRS, the loop invariant:
    // "At the start of each iteration of the for loop, the subarray A[0 : i-1]
    // consists of the elements originally in A[0 : i-1] but in sorted order.
    for (int i = 1; i < unsorted.length; i++) {
      T v = unsorted[i];  // element which we need to find proper index to insert it
      int j = i - 1;
      while (j >= 0 && unsorted[j].compareTo(v) > 0) {
        unsorted[j + 1] = unsorted[j];
        j--;
      }
      // insert value at the proper position
      unsorted[j + 1] = v;
    }
  }

  /**
   * Sort the input array in ascending order according to the natural order of
   * element's type using insertion sort.
   * After each pass, the first i elements are sorted in ascending order.
   *
   * <p>The implementation idea is from Algorithms Part I.
   *
   * @param unsorted the array to be sorted
   * @param <T>      element type of the array, must be comparable
   */
  public static <T extends Comparable<? super T>> void sort2(T[] unsorted) {
    if (unsorted == null || unsorted.length <= 1) {
      return;
    }
    // invariant: after each pass, the elements <= i are sorted in ascending order
    for (int i = 0; i < unsorted.length; i++) {
      // find the proper position to insert the i+1 the element
      for (int j = i; j > 0; j--) {
        if (unsorted[j - 1].compareTo(unsorted[j]) > 0) {
          swap(unsorted, j - 1, j);
        } else {
          break;
        }
      }
    }
  }

  private static <T extends Comparable<? super T>> void swap(T[] elems, int i, int j) {
    T temp = elems[i];
    elems[i] = elems[j];
    elems[j] = temp;
  }
}
