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
      while (left < right && arr[left] <= pivot)
        ++left;
      while (left < right && (right == mid || arr[right] > pivot))
        --right;
      if (left < right)
        swap(arr, left, right);
    }

    // left == right
    int index = right;
    if (mid < right && arr[mid] < arr[right])
        index = right - 1;
    else if (mid > right && arr[mid] > arr[right])
        index = right + 1;
    swap(arr, mid, index);
    return index;
  }
  public static void sort(int[] arr, int left, int right) {
    if (left < right) {
      int index = partition(arr, left, right);
      sort(arr, left, index - 1);
      sort(arr, index + 1, right);
    }
  }

  public static void main(String[] args) {
//    int[] arr = new int[]{5,1,3,2,4,6, -1, -2, 0, 9, 10};
//    int[] arr = new int[]{8, 9, 5, 4, 3, 2, 1, 3, 4, 5, 6, 7,6};
//    int[] arr = new int[]{5, 4, 3, 2, 1, 3, 4, 5, 6, 7, 8, 1, 10, 11, 12, 10, 0, 1, -1, 20, 23, -2, 0, -2};
    int[] arr = new int[]{0,0,10,12,13,1,2,8,9,6,7,20,21,22,15,13,14,15,20};

    System.out.println("=== Before ===");
    System.out.println(Arrays.toString(arr));

    QuickSort.sort(arr, 0, arr.length - 1);

    System.out.println("=== After ===");
    System.out.println(Arrays.toString(arr));
  }
}