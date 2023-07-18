package inflearn.section_7;

import java.util.Scanner;

public class PrimeNumber {
  private static int solution(int n) {
    int answer = 0;
    int[] ch = new int[n + 1];

    for (int i = 2; i <= n; ++i) {
      if (ch[i] == 0)
        ++answer;
      for (int j = 2; i * j < ch.length; ++j)
        ch[i * j] = 1;
    }
    return answer;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(solution(n));

  }

}
