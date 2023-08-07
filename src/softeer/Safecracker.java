package softeer;

import java.nio.Buffer;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Safecracker {

  public static void main(String args[]) throws IOException
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(reader.readLine());

    StringBuilder builder = new StringBuilder();
//    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int w = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n][2];
    for (int i = 0; i < n; ++i) {
//      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      st = new StringTokenizer(reader.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
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
    System.out.println(builder.toString());
//    writer.append()
  }
}
