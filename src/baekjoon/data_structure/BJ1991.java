package baekjoon.data_structure;

import java.io.*;
import java.util.*;

class Node {
	char ch;
	Node left, right;

	public Node(char ch) {
		this.ch = ch;
		left = right = null;
	}
}

class Tree {
	Node root;

	public void preorder(Node root) {
		if (root == null) return;
		System.out.print(root.ch);
		preorder(root.left);
		preorder(root.right);
	}

	public void inorder(Node root) {
		if (root == null) return;
		inorder(root.left);
		System.out.print(root.ch);
		inorder(root.right);
	}

	public void postorder(Node root) {
		if (root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.ch);
	}
}

public class BJ1991 {
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		Map<Character, Node> nodes = new HashMap<>();
		tree.root = new Node('A');
		nodes.put('A', tree.root);

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			Node parentNode = nodes.getOrDefault(parent, new Node(parent));
			Node leftNode = (left == '.') ? null : nodes.getOrDefault(left, new Node(left));
			Node rightNode = (right == '.') ? null : nodes.getOrDefault(right, new Node(right));

			parentNode.left = leftNode;
			parentNode.right = rightNode;

			nodes.put(parent, parentNode);
			nodes.put(left, leftNode);
			nodes.put(right, rightNode);
		}

		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
	}
}
