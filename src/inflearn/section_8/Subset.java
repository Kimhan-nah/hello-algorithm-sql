package inflearn.section_8;

import java.util.Scanner;

public class Subset {
  static int[] check;
  static int breakPoint = 0;

  private static void DFS(int[] arr, int idx) {
    if (breakPoint == 1) return ;
    if (idx == arr.length) {
      int a = 0, b= 0;
      for (int i = 0; i < arr.length; ++i) {
        if (check[i] == 1) a += arr[i];
        else b += arr[i];
      }
      if (a == b) breakPoint = 1;
      return ;
    }
    check[idx] = 1;
    DFS(arr, idx + 1);
    check[idx] = 0;
    DFS(arr, idx + 1);
  }

  private static void solution(int[] arr) {
    check = new int[arr.length];
    DFS(arr, 0);
    if (breakPoint == 1) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i)
      arr[i] = scanner.nextInt();
    solution(arr);
//    int[] arr = {1,3,5,6,7,10};
//    solution(arr);
  }

}
