package baekjoon.sort;

import java.io.*;
import java.util.*;

public class BJ10814 {
  static class Member implements Comparable<Member>{
    String name;
    int age;

    public Member(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public int compareTo(Member o) {
      return age - o.age;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Member[] arr = new Member[n];

    for (int i = 0; i < n; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      arr[i] = new Member(name, age);
    }
    Arrays.sort(arr);
    for (Member x : arr) {
      System.out.println(x.age + " " + x.name);
    }
  }
}
