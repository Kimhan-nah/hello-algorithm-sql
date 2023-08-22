package inflearn.section_1;

import java.util.*;

public class ReversedWord {
  private static void solution(String[] words) {
    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      for (int i = word.length() - 1; i >= 0; --i) {
        sb.append(word.charAt(i));
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] words = new String[n];
    for (int i = 0; i < n; ++i) {
      words[i] = sc.next();
    }
    solution(words);
  }
}
