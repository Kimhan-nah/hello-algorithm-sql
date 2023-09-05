package inflearn.section_6;

import java.io.*;
import java.util.*;

public class LRU {
  private static int[] solution(int[] task, int size) {
    int[] cache = new int[size];
    for (int x : task) {
      int pos = -1;
      for (int i = 0; i < size; ++i) {    // hit pos
        if (x == cache[i]) pos = i;
      }
      if (pos == -1) {    // miss
        for (int i = size - 1; i >= 1; --i)
          cache[i] = cache[i - 1];
      }
      else {              // hit
        for (int i = pos; i >= 1; --i)
          cache[i] = cache[i - 1];
      }
      cache[0] = x;
    }
    return cache;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int s = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[] task = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      task[i] = Integer.parseInt(st.nextToken());
    }
    for (int x : solution(task, s)) System.out.print(x + " ");
//    Arrays.toString(solution(task, s));
  }
}
