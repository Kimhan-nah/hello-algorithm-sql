package inflearn.section_9;

import java.util.*;
import java.io.*;

class Body implements Comparable<Body> {
  public int h, w;

  public Body(int h, int w) {
    this.h = h;
    this.w = w;
  }

  @Override
  public int compareTo(Body o) {
    return o.h - this.h;
  }
}

public class Athlete {
  /**
   *  지원자 A가 키와 몸무게가 모두 큰 지원자가 존재하면 탈락
   */
  private static int solution(ArrayList<Body> arr) {
    int count = 0;
    Collections.sort(arr);
    int max = Integer.MIN_VALUE;

    for (Body ob : arr) {
      if (ob.w > max) {
        max = ob.w;
        ++count;
      }
    }
    return count;
}

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Body> arr = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int h = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      arr.add(new Body(h, w));
    }
    int answer = solution(arr);
    System.out.println(answer);

  }
}
