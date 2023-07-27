package inflearn.section_7;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
  Node root;
  public void BFS(Node root) {
    Queue<Node> Q = new LinkedList<>();
    Q.offer(root);
    int L = 0;
    while (!Q.isEmpty()) {
      int len = Q.size();
      System.out.print(L + " ");
      for (int i = 0; i < len; ++i) {
        Node current = Q.poll();
        System.out.print(current.data + " ");
        if (current.left != null)
          Q.offer(current.left);
        if (current.right != null)
          Q.offer(current.right);
      }
      ++L;
      System.out.println();
    }

  }

  public static void main(String[] args) {
    BFS tree = new BFS();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right= new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right= new Node(5);
    tree.root.right.left= new Node(6);
    tree.root.right.right= new Node(7);

    tree.BFS(tree.root);

  }

}
