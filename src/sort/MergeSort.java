package sort;

import java.util.*;

public class MergeSort {
  private static void merge(int[] arr, int left, int mid, int right) {
    int[] tmp = new int[right - left + 1];
    int i = left;
    int j = mid + 1;
    int idx = 0;

    while (i <= mid && j <= right)
      tmp[idx++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    for (; i <= mid; ++i)
      tmp[idx++] = arr[i];
    for (; j <= right; ++j)
      tmp[idx++] = arr[j];
    idx = 0;
    for(int k = left; k <= right; ++k)
      arr[k] = tmp[idx++];
  }
  private static void sort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      sort(arr, left, mid);
      sort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
  }
  public static void main(String[] args) {
    int[] arr = new int[]{5, 4, 3, 2, 1, 3, 4, 5, 6, 7, 8, 1, 10, 11, 12, 10, 0, 1, -1, 20, 23, -2, 0, -2};

    System.out.println("=== Before ===");
    System.out.println(Arrays.toString(arr));

    MergeSort.sort(arr, 0, arr.length - 1);

    System.out.println("=== After ===");
    System.out.println(Arrays.toString(arr));
  }

}
