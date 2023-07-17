package inflearn.section_7;

public class Recursive2 {
  static private void DFS(int num) {
    if (num < 2) {
      System.out.print(num);
      return ;
    }
    DFS(num / 2);
    System.out.print(num % 2);
  }

  public static void main(String[] args) {
    DFS(11);
    System.out.println( );
    DFS(10);
    System.out.println( );
    DFS(2);
  }
}
