package sort;

import java.util.*;

//public class BJ1181 {
public class Main {
  private static void swap(String[] arr, int a, int b) {
    String tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
  private static void sort(String[] arr, int left, int right) {    // bubble sort
    for(int i = 0; i < arr.length; ++i) {
      for(int j = 0; j < arr.length - i - 1; ++j) {
        if (arr[j].length() > arr[j + 1].length()) {
          swap(arr, j, j + 1);
        } else if (arr[j].length() == arr[j + 1].length() && arr[j].compareTo(arr[j + 1]) > 0) {
          swap(arr, j, j + 1);
        }
      }
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    Set<String> set = new HashSet<>();
    for (int i = 0; i < n; ++i) {
      set.add(scanner.next());
    }
    String[] arr = set.toArray(new String[0]);
    sort(arr, 0, arr.length - 1);

    for (String str: arr) {
      System.out.println(str);
    }
  }
}
