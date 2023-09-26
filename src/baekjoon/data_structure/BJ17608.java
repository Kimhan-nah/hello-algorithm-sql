package baekjoon.data_structure;

import java.util.*;
import java.io.*;
public class BJ17608 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int max = arr[n - 1];
    int answer = 1;
    for (int i = n - 2; i >= 0; --i) {
      if (max < arr[i]) {
        max = arr[i];
        ++answer;
      }
    }
    System.out.println(answer);
  }
}
