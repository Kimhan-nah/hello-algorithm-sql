package baekjoon.brute_force;

import java.util.*;
import java.io.*;

public class BJ1969 {

  private static int solution(String[] arr, int n, int m) {
    int answer = 0;
    char[] str = new char[m];

    for (int i = 0; i < m; ++i) {
      HashMap<Character, Integer> check = new HashMap<>();

      for (int j = 0; j < n; ++j) {
        char ch = arr[j].charAt(i);
        check.put(ch, check.getOrDefault(ch, 0) + 1);
      }
      // max 찾기
      char maxKey = 'a';
      int maxValue = Integer.MIN_VALUE;
      for (Map.Entry<Character, Integer> tmp : check.entrySet()) {
        if (maxValue < tmp.getValue()) {
          maxValue = tmp.getValue();
          maxKey = tmp.getKey();
        } else if (maxValue == tmp.getValue()) {
          if (maxKey > tmp.getKey()) {
            maxKey = tmp.getKey();
          }
        }
      }
      str[i] = maxKey;
      answer += (n - maxValue);
    }
    System.out.println(str);

    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    String[] arr = new String[n];

    for (int i = 0; i < n; ++i) {
      arr[i] = br.readLine();
    }
    int answer = solution(arr, n, m);
    System.out.println(answer);
  }
}
