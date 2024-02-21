package baekjoon.tree;

import java.io.*;

public class BJ5639 {
	static class Node {
		int key;
		Node left, right;
		Node(int key) {
			this.key = key;
			left = right = null;
		}

		void insert(int key) {
			if (key < this.key) {
				if (this.left == null)
					this.left = new Node(key);
				else
					this.left.insert(key);
			} else {
				if (this.right == null)
					this.right = new Node(key);
				else
					this.right.insert(key);
			}
		}

		void postorder() {
			if (this.left != null)
				this.left.postorder();
			if (this.right != null)
				this.right.postorder();
			System.out.println(key);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));

		while (true) {
			String str = br.readLine();
			if (str == null || str.isEmpty()) {
				break;
			}
			int key = Integer.parseInt(str);
			root.insert(key);
		}
		root.postorder();
	}
}

