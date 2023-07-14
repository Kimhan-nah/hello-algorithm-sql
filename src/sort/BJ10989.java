package sort;

import java.io.*;
import java.util.*;

public class BJ10989 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(reader.readLine());
    }
    Arrays.sort(arr);
    for(int tmp : arr) {
      writer.write(tmp + "\n");
    }
    writer.close();
  }
}
