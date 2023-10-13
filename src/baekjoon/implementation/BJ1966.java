package baekjoon.implementation;

import java.util.*;
import java.io.*;

public class BJ1966 {
  static class Task {
    int priority;
    boolean isTarget;

    public Task(int priority, boolean isTarget) {
      this.priority = priority;
      this.isTarget = isTarget;
    }
  }
  private static int solution(Integer[] arr, int target) {
    int answer = 0;
    Queue<Task> queue = new LinkedList<>();

    for (int i = 0; i < arr.length; ++i) {
      if (i == target)
        queue.add(new Task(arr[i], true));
      else
        queue.add(new Task(arr[i], false));
    }
    Arrays.sort(arr, Collections.reverseOrder());

    while (!queue.isEmpty()) {
      Task pop = queue.poll();
      if (pop.priority < arr[answer]) {
        queue.offer(pop);
      }
      else {      // pop.priority == arr[answer]
        if (pop.isTarget) break ;
        ++answer;
      }
    }

    return answer + 1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int target = Integer.parseInt(st.nextToken());
      Integer[] arr = new Integer[N];
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        arr[j] = Integer.parseInt(st.nextToken());
      }
      int answer = solution(arr, target);
      sb.append(answer).append("\n");
    }
    System.out.println(sb);
  }
}
