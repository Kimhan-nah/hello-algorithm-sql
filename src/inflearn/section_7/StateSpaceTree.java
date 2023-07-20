package inflearn.section_7;

import java.util.LinkedList;
import java.util.Queue;

public class StateSpaceTree {
  int[] dis = {1, -1, 5};
  int[] check;
  int level = 0;
  Queue<Integer> queue = new LinkedList<>();

  public int BFS(int s, int e) {
    queue.offer(s);

    while (!queue.isEmpty()) {
      if (queue.contains(e))
        return level;
      int len = queue.size();
      for (int i = 0; i < len; ++i) {
        int tmp = queue.poll();
        for (int j = 0; j < dis.length; ++j ){
          queue.offer(tmp + dis[j]);
        }
      }
      ++level;
    }
    return level;
  }

  public static void main(String[] args) {
    StateSpaceTree T = new StateSpaceTree();
    System.out.println(T.BFS(5, 14));
  }

}
