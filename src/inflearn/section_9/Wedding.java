package inflearn.section_9;

import java.util.*;

class Time implements Comparable<Time> {
  int time;
  char state;

  public Time(int time, char state) {
    this.time = time;
    this.state = state;
  }

  @Override
  public int compareTo(Time o) {
    if (time == o.time) {
      return state - o.state;
    }
    return time - o.time;
  }
}

public class Wedding {
  private static int solution(ArrayList<Time> arr, int n) {
    Collections.sort(arr);
    int answer = Integer.MIN_VALUE;
    int count = 0;

    for (Time t : arr ) {
      if (t.state == 's') {
        ++count;
        answer = Math.max(answer, count);
      } else if (t.state == 'e') {
        --count;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Time> arr = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      arr.add(new Time(start, 's'));
      arr.add(new Time(end, 'e'));
    }
    int answer = solution(arr, n);
    System.out.println(answer);
  }
}
