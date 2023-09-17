package baekjoon.greedy;

import java.util.*;

public class BJ1789 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long count = 0;
    long sum = 0;

    if (n == 1 || n == 2) {
      System.out.println(1);
      return ;
    }
    for (int i = 1; i < n; ++i) {
      sum += i;
      ++count;
      if (sum >= n) break;
    }
    count = sum == n ? count : count - 1;
    System.out.println(count);
  }
}
