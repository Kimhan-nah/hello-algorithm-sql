package baekjoon.greedy;

import java.util.*;

public class BJ16953 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    int answer = 0;
    int current = b;
    while (current > a) {
      if (current % 2 == 0){
        current /= 2;
      } else if (current % 10 == 1) {
        current = current / 10;
      } else {
        answer = -1;
        break ;
      }
      ++answer;
    }
    answer = current == a ? answer + 1 : -1;
    System.out.println(answer);
  }
}
