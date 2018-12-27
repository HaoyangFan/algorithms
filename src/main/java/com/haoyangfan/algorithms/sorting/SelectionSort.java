package com.haoyangfan.algorithms.sorting;

/**
 * Property:
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
   * After each pass, the ith largest element will be put at (unsorted.length - i) position.
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
