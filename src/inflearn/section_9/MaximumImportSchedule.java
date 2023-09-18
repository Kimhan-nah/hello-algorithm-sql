package inflearn.section_9;

import java.util.*;

public class MaximumImportSchedule {
  private static int solution(int[][] arr, int n) {
    int answer = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    Arrays.sort(arr, ((o1, o2) -> {
      return o2[1] - o1[1];   // 내림차순
    }));

//    System.out.println(Arrays.deepToString(arr));
    int day = arr[0][1];
    for (int i = 0; i < n; ++i) {
      if (arr[i][1] == day) {
        queue.offer(arr[i][0]);
      } else {
        for (int j = 0; j < day - arr[i][1]; ++j) {
          if (queue.isEmpty()) break ;
          answer += queue.poll();
        }
        day = arr[i][1];
        queue.offer(arr[i][0]);
      }
    }
    answer += queue.poll();

    return answer;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][2];

    for (int i = 0; i < n; ++i) {
      int m = sc.nextInt();
      int d = sc.nextInt();
      arr[i][0] = m;
      arr[i][1] = d;
    }
    int answer = solution(arr, n);
    System.out.println(answer);
  }
}
