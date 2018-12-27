package com.haoyangfan.algorithms.sorting;

/**
 * Bubble sort is s an efficient O(nlogn), general-purpose, comparison-based sorting algorithm.
 * Most of its implements use O(n) auxiliary space and are stable.
 *
 * <p>Divide current problem (sort current array) into subproblems (sort subarrays) and
 * recursively solve for the subproblems, and eventually merge the results back so in
 * the end the input array will be sorted.
 *
 * <p>Time complexity:
 * worst: O(nlogn)
 * average: O(nlogn)
 * best: O(nlogn)
 *
 * <p>Space: O(n)
 *
 * <p>Bubble sort is a stable algorithm.
 *
 * <p>Reference:
 * https://en.wikipedia.org/wiki/Merge_sort
 *
 * @param <T> generic type that must be comparable
 * @author HaoyangFan
 * @version 1.0
 * @since 12-26-2018
 */
@SuppressWarnings("unchecked")
public final class MergeSort<T extends Comparable<? super T>> {
  /**
   * Hide the constructor.
   */
  private MergeSort() {
  }

  /**
   * Sort the input array in ascending order according to the natural order of
   * element's type using merge sort.
   *
   * @param unsorted array to be sorted
   * @param <T>      generic type that must be comparable
   */
  public static <T extends Comparable<? super T>> void sort(T[] unsorted) {
    if (unsorted == null || unsorted.length <= 1) {
      return;
    }
    T[] aux = (T[]) new Comparable[unsorted.length];
    sort(unsorted, 0, unsorted.length - 1, aux);
  }

  private static <T extends Comparable<? super T>> void sort(T[] unsorted, int start, int end, T[] aux) {
    if (start >= end) {
      return;
    }
    int mid = start + (end - start) / 2;
    // DIVIDE
    sort(unsorted, start, mid, aux);
    sort(unsorted, mid + 1, end, aux);

    // MERGE
    if (unsorted[mid].compareTo(unsorted[mid + 1]) > 0) {
      merge(unsorted, start, mid, end, aux);
    }
  }

  private static <T extends Comparable<? super T>> void merge(T[] unsorted, int start, int mid, int end, T[] aux) {
    int l = start;
    int r = mid + 1;
    int idx = start;
    while (l <= mid && r <= end) {
      if (unsorted[l].compareTo(unsorted[r]) <= 0) {
        aux[idx++] = unsorted[l++];
      } else {
        aux[idx++] = unsorted[r++];
      }
    }
    while (l <= mid) {
      aux[idx++] = unsorted[l++];
    }
    while (r <= end) {
      aux[idx++] = unsorted[r++];
    }
    System.arraycopy(aux, start, unsorted, start, end - start + 1);
  }

  private static <T extends Comparable<? super T>> void swap(T[] nums, int i, int j) {
    T temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
