package sort;

public class QuickSort {
  private static void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[left];  // first element pivot
    int index = left;
    boolean flag = true;

    while (left < right) {
      if (flag == true) {  // right -> left
        if (arr[right] < pivot) {
          swap(arr, right, index);
          index = right;
          flag = false;
        } else {
          --right;
        }
      }
      else if (flag == false) {   // left -> right
        if (arr[left] > pivot) {
          swap(arr, left, index);
          index = left;
          flag = true;
        } else {
          ++left;
        }
      }
    }
    return index;
  }
  public static void sort(int[] arr, int left, int right) {
    if (left < right) {
      int index = partition(arr, left, right);
      sort(arr, left, index - 1);
      sort(arr, index + 1, right);
    }
  }
}
