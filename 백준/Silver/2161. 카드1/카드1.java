import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	private static void solution(int n) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; ++i) {
			queue.offer(i);
		}

		boolean flag = false;

		while (!queue.isEmpty()) {
			int num = queue.poll();
			if (flag) {
				queue.offer(num);
			} else {
				sb.append(num).append(" ");
			}
			flag = !flag;
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		solution(n);
	}
}
