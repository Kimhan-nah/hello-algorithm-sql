package inflearn.section_6;

import java.util.*;

public class DecisionAlgorithm {
  private static int count(int[] arr, int capacity) {
    int cnt = 1, sum = 0;
    for (int x : arr) {
      if (sum + x > capacity) {
        ++cnt;
        sum = x;
      } else {
        sum += x;
      }
    }
    return cnt;
  }

  private static int solution(int[] arr, int m) {
    int answer = 0;
    int lt = Arrays.stream(arr).max().getAsInt();
    int rt = Arrays.stream(arr).sum();

    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (count(arr, mid) <= m) {
        answer = mid;
        rt = mid - 1;
      } else {
        lt = mid + 1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; ++i) {
      arr[i] = sc.nextInt();
    }
    int answer = solution(arr, m);
    System.out.println(answer);
  }
}
