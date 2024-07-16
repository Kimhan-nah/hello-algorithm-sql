import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, H, T;
	private static Queue<Integer> heights = new PriorityQueue<>(Comparator.reverseOrder());
	private static int MIN = 1;
	private static StringBuilder sb = new StringBuilder();

	private static void solution() {
		for (int count = 0; count < T; ++count) {
			int tallest = heights.peek();
			if (tallest == MIN && tallest == H) {
				sb.append("NO\n").append(MIN);
				return;
			}
			if (tallest < H) {
				sb.append("YES\n").append(count);
				return;
			}
			heights.offer(heights.poll() / 2);
		}
		int tallest = heights.peek();
		if (tallest < H) {
			sb.append("YES\n").append(T);
		} else {
			sb.append("NO\n").append(tallest);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; ++i) {
			heights.offer(Integer.parseInt(br.readLine()));
		}

		solution();
		System.out.println(sb);
	}
}
