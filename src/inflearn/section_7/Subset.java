package inflearn.section_7;

public class Subset {
  static int n;
  static int[] ch;

  public void DFS(int L) {
    if (L > n) return ;

    // O
    ch[L] = 1;
    DFS(L + 1);
    for(int i = 0; i < ch.length; ++i) {
      if (ch[i] == 1) {
        System.out.print(i + " ");
      }
    }
    System.out.println();

    // X
    ch[L] = 0;
    DFS(L + 1);
  }

  public static void main(String[] args) {
    Subset T = new Subset();
    n = 3;
    ch = new int[n + 1];
    T.DFS(1);
  }

}
