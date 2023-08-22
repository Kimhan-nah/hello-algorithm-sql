package inflearn.section_1;

import java.util.*;
import java.lang.StringBuilder;

public class ReversedWord {
  private static ArrayList<String> solution(String[] words) {
    ArrayList<String> answer = new ArrayList<>();

    for (String word : words) {
      String tmp = new StringBuilder(word).reverse().toString();
      answer.add(tmp);
    }
    return  answer;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] words = new String[n];
    for (int i = 0; i < n; ++i) {
      words[i] = sc.next();
    }
    for (String word : solution(words)) {
      System.out.println(word);
    }
  }
}
