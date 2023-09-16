package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class BJ1541 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] numbers = br.readLine().split("-");
    int answer = 0;

    for (int i = 0; i < numbers.length; ++i) {
      int[] tmp = Arrays.stream(numbers[i].split("\\+")).mapToInt(Integer::parseInt).toArray();
      int sum = Arrays.stream(tmp).sum();
      if (i == 0) answer = sum;
      else answer -= sum;
    }
    System.out.println(answer);
  }
}
