package inflearn.section_7;

public class PrimeNumber {
  private static int DFS(int num) {
    if (num < 2)
      return 0;
    for (int i = 2; i <= num / 2; ++i) {
      if (num % i == 0) {
        return DFS(num - 1);
      }
    }
    return 1 + DFS(num - 1);
  }

  public static void main(String[] args) {
    System.out.println(DFS(20));

  }

}
