package baekjoon.implementation;

import java.util.*;
import java.io.*;

public class BJ2108 {
  private static void solution(int[] arr, int n) {
    HashMap<Integer, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    Arrays.sort(arr);
    long average = Math.round((double)Arrays.stream(arr).sum() / n);
    int mid = arr[n / 2];
    for (int i = 0; i < n; ++i) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
    entries.sort((o1, o2) -> {
      if (o1.getValue().equals(o2.getValue())) {
        return o1.getKey() - o2.getKey();
      }
      return o2.getValue() - o1.getValue();
    });
    int most = entries.get(0).getKey();
    if (entries.size() > 1 && entries.get(0).getValue().equals(entries.get(1).getValue())) {
      most = entries.get(1).getKey();
    }
    int range = arr[n -1] - arr[0];

    sb.append(average).append("\n");
    sb.append(mid).append("\n");
    sb.append(most).append("\n");
    sb.append(range).append("\n");
    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    solution(arr, n);
  }
}
