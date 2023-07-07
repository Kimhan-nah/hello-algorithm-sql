package sort;

import java.io.*;
import java.util.*;

public class BJ2751 {
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

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(reader.readLine());
    }
    sort(arr, 0, arr.length - 1);
    for(int tmp : arr) {
      writer.write(tmp + "\n");
    }
    writer.close();
  }

}
