package inflearn.section_6;

import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
  private int x, y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Point o) {
    if (this.x == o.x) return this.y - o.y;
    return this.x - o.x;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}

public class CoordinateAlignment {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Point> arr = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      arr.add(new Point(x, y));
    }
    Collections.sort(arr);
    for (Point o : arr) {
      System.out.println(o.getX() + " " + o.getY());
    }
  }
}
