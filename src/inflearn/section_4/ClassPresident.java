package inflearn.section_4;

import java.util.*;

public class ClassPresident {
  private static char solution(String str) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char ch : str.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0)+ 1);
    }
    char answer = ' ';
    int max = Integer.MIN_VALUE;
    for (char key : map.keySet()) {
      if (max < map.get(key)) {
        max = map.get(key);
        answer = key;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String str = sc.next();
    char ch = solution(str);
    System.out.println(ch);
  }
}
