package inflearn.section_3;

import java.util.*;

public class TwoPointersAlgorithm {
  private static int[] solution(int[] arr1, int[] arr2) {
    int[] answer = new int[arr1.length + arr2.length];
    int idx = 0, idx1 = 0, idx2 = 0;

    while (idx < answer.length) {
      if (idx1 == arr1.length || idx2 == arr2.length) break ;
      if (arr1[idx1] < arr2[idx2]) {
        answer[idx++] = arr1[idx1];
        ++idx1;
      } else {
        answer[idx++] = arr2[idx2];
        ++idx2;
      }
    }

    for (int i = idx1; i < arr1.length; ++i)
      answer[idx++] = arr1[i];
    for (int i = idx2; i < arr2.length; ++i)
      answer[idx++] = arr2[i];

    return answer;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    int[] arr2 = new int[m];
    for (int i = 0; i < m; ++i) {
      arr2[i] = sc.nextInt();
    }

    int[] answer = solution(arr, arr2);
    for (int x : answer)
      System.out.print(x + " ");
  }
}
