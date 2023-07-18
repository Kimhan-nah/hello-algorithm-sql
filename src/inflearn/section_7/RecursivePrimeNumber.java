package inflearn.section_7;

import java.util.Scanner;

public class RecursivePrimeNumber {
  private static boolean isPrime(int n) {
    int[] ch = new int[n + 1];

    if (n < 2)
      return false;
    for (int i = 2; i < n / 2; ++i) {
      if (n % i == 0)
        return false;
    }
    return true;
  }
  private static void solution(int[] arr) {
    for (int num : arr) {
      StringBuffer str = new StringBuffer(Integer.toString(num));
      String reverseStr = str.reverse().toString();
      int reverseInt = Integer.parseInt(reverseStr);
      if (isPrime(reverseInt)) {
        System.out.print(reverseInt + " ");
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i)
      arr[i] = sc.nextInt();
    solution(arr);
  }

}
