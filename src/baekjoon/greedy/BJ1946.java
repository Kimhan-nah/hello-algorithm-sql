package baekjoon.greedy;

import java.util.*;
import java.io.*;

class Score implements Comparable<Score> {
  int score1, score2;

  public Score(int score1, int score2) {
    this.score1 = score1;
    this.score2 = score2;
  }

  @Override
  public int compareTo(Score o) {
    return score1 - o.score1;
  }
}

public class BJ1946 {
  private static int solution(ArrayList<Score> arr, int n) {
    int count = 1;
    Collections.sort(arr);

    int score = arr.get(0).score2;
    for (int i = 1; i < n; ++i) {
      if (score > arr.get(i).score2) {  // 탈락
        ++count;
        score = arr.get(i).score2;
      }
    }
    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());    // 테스트 케이스 갯수
    ArrayList<Integer> answers = new ArrayList<>();

    for (int i = 0; i < t; ++i) {
      int n = Integer.parseInt(br.readLine());    // 지원자 숫자
      ArrayList<Score> arr = new ArrayList<>();
      for (int j = 0; j < n; ++j) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int score1 = Integer.parseInt(st.nextToken());
        int score2 = Integer.parseInt(st.nextToken());
        arr.add(new Score(score1, score2));
      }
      answers.add(solution(arr, n));
    }
    for (int x : answers)
      System.out.println(x);
  }
}
