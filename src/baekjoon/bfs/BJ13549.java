package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ13549 {
	private static int N, K;

	private static void solution() {
		Queue<Status> queue = new LinkedList<>();
		Set<Integer> trace = new HashSet<>();
		queue.offer(new Status(0, N));
		trace.add(N);

		while (!queue.isEmpty()) {
			Status poll = queue.poll();
			if (poll.location == K) {
				System.out.println(poll.elapsedTime);
				return;
			}

			int[] nextLocations = {poll.location * 2, poll.location - 1, poll.location + 1};
			for (int i = 0; i < 3; ++i) {
				int nextLocation = nextLocations[i];
				if (nextLocation < 0 || nextLocation > 100000 || trace.contains(nextLocation)) {
					continue;
				}
				int nextTime = i != 0 ? poll.elapsedTime + 1 : poll.elapsedTime;
				queue.offer(new Status(nextTime, nextLocation));
				trace.add(nextLocation);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		solution();
	}

	static class Status {
		int elapsedTime;
		int location;

		public Status(int elapsedTime, int location) {
			this.elapsedTime = elapsedTime;
			this.location = location;
		}

	}
}
