import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cluster = Integer.parseInt(br.readLine());

		long answer = 0;
		for (int i = 0; i < n; ++i) {
			if (arr[i] % cluster > 0) {
				answer += cluster;
				arr[i] -= arr[i] % cluster;
			}
			answer += arr[i];
		}
		System.out.println(answer);
	}
}
