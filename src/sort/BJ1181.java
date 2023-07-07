package sort;

import java.util.*;

public class BJ1181 {
  private static void merge(String[] arr, int left, int mid, int right) {
    String[] tmp = new String[right - left + 1];
    int i = left;
    int j = mid + 1;
    int idx = 0;

    while (i <= mid && j <= right) {
      if (arr[i].length() < arr[j].length())
        tmp[idx++] = arr[i++];
      else if (arr[i].length() == arr[j].length())
        tmp[idx++] = arr[i].compareTo(arr[j]) < 0 ? arr[i++] : arr[j++];
      else
        tmp[idx++] = arr[j++];
    }
    for (; i <= mid; ++i)
      tmp[idx++] = arr[i];
    for (; j <= right; ++j)
      tmp[idx++] = arr[j];
    idx = 0;
    for(int k = left; k <= right; ++k)
      arr[k] = tmp[idx++];
  }
  private static void sort(String[] arr, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      sort(arr, left, mid);
      sort(arr, mid + 1, right);
      merge(arr, left, mid, right);
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
