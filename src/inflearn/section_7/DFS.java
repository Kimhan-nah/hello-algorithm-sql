package inflearn.section_7;

class Node {
  int data;
  Node left, right;
  public Node(int val) {
    data= val;
    left = right = null;
  }
}

public class DFS {
  Node root;

  public void DFS(Node root) {
    if (root == null)
      return ;
    DFS(root.left);
    System.out.print(root.data + " ");
    DFS(root.right);
  }

  public static void main(String[] args) {
    DFS tree = new DFS();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right= new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right= new Node(5);
    tree.root.right.left= new Node(6);
    tree.root.right.right= new Node(7);

    tree.DFS(tree.root);
  }
}
