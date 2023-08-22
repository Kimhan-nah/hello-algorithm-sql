package inflearn.section_1;

import java.util.*;

public class CaseConversion {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    String str = sc.nextLine();

    for (char x : str.toCharArray()) {
      if (Character.isUpperCase(x))  {
        sb.append(Character.toLowerCase(x));
      } else {
        sb.append(Character.toUpperCase(x));
      }
    }
    System.out.println(sb);
  }
}
