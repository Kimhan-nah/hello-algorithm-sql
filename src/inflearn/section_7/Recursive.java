package inflearn.section_7;

public class Recursive {
  private static void DFS(int n) {
    if (n == 0) return ;
    System.out.println(n);
    DFS(n - 1);
  }
  public static void main(String[] args) {
    DFS(3);
  }
}
