package baekjoon.implementation;

import java.util.*;
import java.io.*;

public class BJ10773 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < K; ++i) {
      int tmp = Integer.parseInt(br.readLine());
      if (tmp == 0) stack.pop();
      else stack.push(tmp);
    }
    int answer = 0;
    for (int i : stack) {
      answer += i;
    }
    System.out.println(answer);
  }
}
