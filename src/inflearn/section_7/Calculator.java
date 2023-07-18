package inflearn.section_7;

import java.util.Scanner;

public class Calculator {

  private static int solution(int[] arr) {
    int count = 0;
    int score = 0;

    for (int result : arr) {
      if (result == 1)
        score += ++count;
      else
        count = 0;
    }
    return score;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = scanner.nextInt();
    }
    int socre = solution(arr);
    System.out.println(socre);
  }
}
