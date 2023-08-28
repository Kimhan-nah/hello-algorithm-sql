package inflearn.section_9;

import java.util.*;
import java.io.*;

public class Athlete {
  /**
   *  지원자 A가 키와 몸무게가 모두 큰 지원자가 존재하면 탈락
   */
  private static void solution(int[][] arr) {
    int count = 0;

    for (int i = 0; i < arr.length; ++i) {
      for (int j = 0; j < arr.length; ++j) {
        if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
          ++count;
          break ;
        }
      }
    }
    System.out.println(arr.length - count);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }
    solution(arr);

  }
}
