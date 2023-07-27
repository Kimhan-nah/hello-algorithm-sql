package inflearn.section_7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StateSpaceTree {
  int[] dis = {1, -1, 5};
  int[] check;
  Queue<Integer> queue = new LinkedList<>();

  public int BFS(int s, int e) {
    check = new int[10001];
    int level = 0;

    check[s] = 1;
    queue.offer(s);

    while (!queue.isEmpty()) {
      int len = queue.size();
      for (int i = 0; i < len; ++i) {
        int tmp = queue.poll();
        for (int j = 0; j < dis.length; ++j ){
          int next = tmp + dis[j];
          if (next > 0 && next < 10000 && check[next] == 0) {
            check[next] = 1;
            queue.offer(next);
          }
        }
      }
      ++level;
      if (queue.contains(e))
        return level;
    }
    return level;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int s = scanner.nextInt();
    int e = scanner.nextInt();
    StateSpaceTree T = new StateSpaceTree();

    System.out.println(T.BFS(s, e));
  }

}
