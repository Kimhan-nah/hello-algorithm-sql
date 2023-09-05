package inflearn.section_6;

import java.util.*;
import java.io.*;

public class DuplciateVerification {
  private static char solution(int[] arr) {
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 1; ++i) {
      if (arr[i] == arr[i + 1]) return 'D';
    }
    return 'U';
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    System.out.println(solution(arr));
  }
}
