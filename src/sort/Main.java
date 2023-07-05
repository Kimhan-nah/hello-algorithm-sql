package sort;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    int[] arr = new int[]{5, 4, 3, 2, 1};
    System.out.println("=== Before ===");
    System.out.println(Arrays.toString(arr));

    QuickSort.sort(arr, 0, 4);

    System.out.println("=== After ===");
    System.out.println(Arrays.toString(arr));
  }

}
