import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	private static void solution(char[] arr) {
		for (int i = arr.length - 2; i >= 0; --i) {
			// pivot보다 같거나 큰 숫자 중에 가장 작은 값을 찾고, swap -> pivot 이후의 값들은 오름차순으로 정렬한다.
			char pivot = arr[i];
			char next = Character.MAX_VALUE;
			int nextIndex = -1;

			for (int j = i + 1; j < arr.length; ++j) {
				if (pivot < arr[j] && next > arr[j]) {
					next = arr[j];
					nextIndex = j;
				}
			}
			if (next != Character.MAX_VALUE) {
				// swap
				char tmp = arr[nextIndex];
				arr[nextIndex] = pivot;
				arr[i] = tmp;

				// sort (i + 1부터 정렬)
				Arrays.sort(arr, i + 1, arr.length);
				sb.append(String.valueOf(arr)).append("\n");
				return;
			}
		}
		sb.append(String.valueOf(arr)).append("\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; ++i) {
			char[] arr = br.readLine().toCharArray();
			solution(arr);
		}
		System.out.print(sb);
	}
}
