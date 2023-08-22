package inflearn.section_1;

import java.util.*;

public class LongestWord {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String[] tokens = str.split("\\s");
    String answer = "";
    for (String token : tokens) {
      if (answer.length() < token.length()) answer = token;
    }
    System.out.println(answer);
  }
}
