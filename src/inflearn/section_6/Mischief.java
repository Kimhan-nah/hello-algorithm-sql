package inflearn.section_6;

import java.util.*;
import java.io.*;

public class Mischief {
  private static void solution(int[] arr) {
    int index1 = 0, index2 = arr.length - 1;

    for (int i = arr.length - 1; i > 0; --i) {
      if (arr[i - 1] > arr[i]) {
        index2 = i;
        break ;
      }
    }

    for (int i = 0; i < arr.length; ++i) {
      if (arr[i] > arr[index2]) {
        index1 = i;
        break ;
      }
    }

    System.out.println(++index1 + " " + ++index2);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    solution(arr);

  }
}
