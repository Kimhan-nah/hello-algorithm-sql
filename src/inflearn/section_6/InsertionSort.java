package inflearn.section_6;

import java.util.*;

public class InsertionSort {
  private static void solution(int[] arr) {
    for (int i = 1; i < arr.length; ++i) {
      int tmp = arr[i];
      int j;
      for (j = i - 1; j >= 0; --j) {
        if (arr[j] > tmp)  arr[j + 1] = arr[j];
        else break ;
      }
      arr[j + 1] = tmp;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = sc.nextInt();
    }
    solution(arr);
    System.out.println(Arrays.toString(arr));
  }
}
