package inflearn.section_8;

import java.util.Scanner;

public class Subset {
  static int total = 0;
  static boolean breakPoint = false;

  private static void DFS(int[] arr, int idx, int sum) {
    if (breakPoint || sum > total / 2) return ;
    if (idx == arr.length) {
      if (total - sum == sum) breakPoint = true;
      return ;
    }
    DFS(arr, idx + 1, sum + arr[idx]);
    DFS(arr, idx + 1, sum);
  }

  private static void solution(int[] arr) {
    DFS(arr, 0, 0);
    if (breakPoint) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = scanner.nextInt();
      total += arr[i];
    }
    solution(arr);
//    int[] arr = {1,3,5,6,7,10};
//    solution(arr);
  }

}
