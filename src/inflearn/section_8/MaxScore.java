package inflearn.section_8;

import java.util.*;
import java.io.*;

public class MaxScore {
  static int limit;
  static int[][] arr;
  private static int solution(int level, int score, int time) {
    if (level == arr.length) {
      if (limit < time)
        return -1;
      return score;
    }

    return Math.max(solution(level + 1,  score + arr[level][0],
        time + arr[level][1]), solution(level + 1, score, time));
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    limit = Integer.parseInt(st.nextToken());
    arr = new int[n][2];

    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());   // score
      arr[i][1] = Integer.parseInt(st.nextToken());   // time
    }
    int answer = solution(0, 0, 0);
    System.out.println(answer);
  }
}
