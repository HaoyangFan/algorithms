package com.haoyangfan.algorithms.sorting;

/**
 * Selection sort is an in-place, companion based sorting algorithm.
 * It sorts list by iteratively swapping the smallest elements (“select” the smallest of remaining list)
 * to the front, one at a time. It has O(n^2) time complexity (companions) for all best,
 * average and worst case, which makes it inefficient for large dataset.
 *
 * <p>Time complexity:
 * worst: O(n^2)
 * average: O(n^2)
 * best: O(n^2)
 *
 * <p>Space: O(1), it is in-place sorting algorithm.
 *
 * <p>Selection sort is an unstable algorithm.
 *
 * <p>Property:
 * 1. number of swap is minimum
 * 2. no auxiliary space needed, in-place sorting
 * 3. not stable (https://stackoverflow.com/questions/48913820/why-selection-sort-is-unstable)
 *
 * @param <T> the generic type that must be comparable
 * @author HaoyangFan
 * @version 1.0
 * @since 12-26-2018
 */
public class SelectionSort<T extends Comparable<? super T>> {
  /**
   * Hide the constructor.
   */
  private SelectionSort() {
  }

  /**
   * Sort the input array in ascending order according to the natural order of
   * element's type using selection sort.
   * After each pass, the ith smallest element will be put at ith position.
   *
   * @param unsorted the array to be sorted
   * @param <T>      element type of the array, must be comparable
   */
  public static <T extends Comparable<? super T>> void sort(T[] unsorted) {
    if (unsorted == null || unsorted.length <= 1) {
      return;
    }
    // start from the 1st position in the unsorted array:
    // for each pass, the 1st smallest element in the array will be "selected"
    // and be inserted at this position
    // now start with the second position in the unsorted array and repeat this process
    for (int i = 0; i < unsorted.length; i++) {
      int currMin = i; // initialize current minimum to be element at starting pos
      for (int j = i + 1; j < unsorted.length; j++) {
        // in case a new minimum has been founded, updated index
        if (unsorted[j].compareTo(unsorted[currMin]) < 0) {
          currMin = j;
        }
      }
      swap(unsorted, i, currMin); // swap the ith smallest element to the front
    }
  }

  private static <T extends Comparable<? super T>> void swap(T[] elems, int i, int j) {
    T temp = elems[i];
    elems[i] = elems[j];
    elems[j] = temp;
  }
}
