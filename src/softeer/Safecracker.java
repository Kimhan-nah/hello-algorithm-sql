package softeer;

import java.nio.Buffer;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Safecracker {

  public static void main(String args[]) throws IOException
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder builder = new StringBuilder();

    int w = Integer.parseInt(reader.readLine());
    int n = Integer.parseInt(reader.readLine());

    int[][] arr = new int[n][2];
    for (int i = 0; i < n; ++i) {
      arr[i][0] = Integer.parseInt(reader.readLine());
      arr[i][1] = Integer.parseInt(reader.readLine());
    }

    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[1] - o1[1];
      }
    });
    // System.out.println(Arrays.deepToString(arr));

    int answer = 0;
    for (int i = 0; i < arr.length; ++i) {
      if (arr[i][0] < w) {
        answer += arr[i][0] * arr[i][1];
        w -= arr[i][0];
      } else {
        answer += w * arr[i][1];
        break ;
      }
    }
    builder.append(answer);
  }
}
