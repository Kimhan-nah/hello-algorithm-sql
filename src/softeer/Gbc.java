package softeer;
import java. util.*;
import java.io.*;

public class Gbc {
  private static void solution(int[][] pivot, int[][] test) {
    int max = 0;
    int i = 0, j = 0;
    int tmp = 0;

    while (i < pivot.length && j < test.length) {
      tmp = pivot[i][1] < test[j][1] ? test[j][1] - pivot[i][1] : 0;
      if (pivot[i][0] < test[j][0]) {
        test[j][0] -= pivot[i][0];
        ++i;
      } else if (pivot[i][0] == test[j][0]) {
        ++i;
        ++j;
      } else {
        pivot[i][0] -= test[j][0];
        ++j;
      }
      max = max < tmp ? tmp : max;
    }
    System.out.println(max);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] pivot = new int[n][2];
    int[][] test = new int[m][2];
    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      pivot[i][0] = Integer.parseInt(st.nextToken());
      pivot[i][1] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      test[i][0] = Integer.parseInt(st.nextToken());
      test[i][1] = Integer.parseInt(st.nextToken());
    }

    solution(pivot, test);

  }
}
