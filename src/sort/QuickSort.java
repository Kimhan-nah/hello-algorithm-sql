package sort;

import java.util.Arrays;

public class QuickSort {
  private static void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  private static int partition(int[] arr, int left, int right) {
    int mid = left + (right - left) / 2;
    int pivot = arr[mid];

    while (left < right) {
      while (arr[left] < pivot)
        ++left;
      while (arr[right] > pivot)
        --right;

      swap(arr, left, right);
    }

    return right;
  }
  public static void sort(int[] arr, int left, int right) {
    if (left < right) {
      int index = partition(arr, left, right);
      System.out.println("index : " + index);
      System.out.println(Arrays.toString(arr));
      sort(arr, left, index - 1);
      sort(arr, index + 1, right);
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[]{5,1,3,2,4,6, -1, -2, 0, 9, 10};
//    int[] arr = new int[]{5, 4, 3, 2, 1, 3, 4, 5, 6, 7, 8, 1, 10, 11, 12, 10, 0, 1, -1, 20, 23, -2, 0, -2};

    System.out.println("=== Before ===");
    System.out.println(Arrays.toString(arr));

    QuickSort.sort(arr, 0, arr.length - 1);

    System.out.println("=== After ===");
    System.out.println(Arrays.toString(arr));
  }
}