package inflearn.section_1;

import java.util.*;

public class FindChar {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    char ch = sc.nextLine().toLowerCase().charAt(0);

    str = str.toLowerCase();
    int count = 0;
    for (int i = 0; i < str.length(); ++i) {
      if (str.charAt(i) == ch) ++count;
    }
    System.out.println(count);
  }
}
