package baekjoon.implementation;

import java.util.*;
import java.io.*;

public class BJ25206 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double totalCredit = 0;
    double totalGrade = 0;

    for (int i = 0; i < 20; ++i) {
      String str = br.readLine();
      String[] split = str.split(" ");
      double credit = Double.parseDouble(split[1]);
      String grade = split[2];
      switch (grade) {
        case "A+":
          totalGrade += credit * 4.5;
          break;
        case "A0":
          totalGrade += credit * 4.0;
          break;
        case "B+":
          totalGrade += credit * 3.5;
          break;
        case "B0":
          totalGrade += credit * 3.0;
          break;
        case "C+":
          totalGrade += credit * 2.5;
          break;
        case "C0":
          totalGrade += credit * 2.0;
          break;
        case "D+":
          totalGrade += credit * 1.5;
          break;
        case "D0":
          totalGrade += credit;
          break;
        case "F":
          totalGrade += credit * 0.0;
          break;
      }
      if (!grade.equals("P"))
        totalCredit += credit;
    }
    System.out.println(totalGrade / totalCredit);
  }

}
