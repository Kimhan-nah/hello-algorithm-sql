package inflearn.section_9;

import java.util.*;

class TimeTable implements Comparable<TimeTable> {
  int start;
  int end;

  public TimeTable(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public int compareTo(TimeTable o) {
    if (end == o.end) {
      return start - o.start;
    }
    return end - o.end;
  }
}

public class MeetingRoom {
  private static int solution(ArrayList<TimeTable> arr, int n) {
    Collections.sort(arr);
    int count = 1;
    int end = arr.get(0).end;

    for (int i = 1; i < n; ++i) {
      if (end <= arr.get(i).start) {
        end = arr.get(i).end;
        ++count;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<TimeTable> arr = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      arr.add(new TimeTable(sc.nextInt(), sc.nextInt()));
    }
    System.out.println(solution(arr, n));
  }
}
