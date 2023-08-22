package inflearn.section_1;

import java.util.*;

public class FindChar {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    char ch = sc.nextLine().charAt(0);

    str = str.toLowerCase();
    ch = Character.toLowerCase(ch);
    int count = 0;
    for (char x : str.toCharArray()) {
      if (ch == x) ++count;
    }
    System.out.println(count);
  }
}
