import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static String str;
	private static int[][] prefixSum;
	private static StringBuilder sb = new StringBuilder();

	private static int solution(char alphabet, int start, int end) {

		if (prefixSum[alphabet - 'a'][end] != -1) {
			return start == 0 ? prefixSum[alphabet - 'a'][end] :
				prefixSum[alphabet - 'a'][end] - prefixSum[alphabet - 'a'][start - 1];
		}

		int count = 0;
		for (int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);
			if (ch == alphabet) {
				++count;
			}
			prefixSum[alphabet - 'a'][i] = count;
		}

		return start == 0 ? prefixSum[alphabet - 'a'][end] :
			prefixSum[alphabet - 'a'][end] - prefixSum[alphabet - 'a'][start - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		prefixSum = new int[26][str.length()];
		int q = Integer.parseInt(br.readLine());

		for (int[] row : prefixSum) {
			Arrays.fill(row, -1);
		}

		for (int i = 0; i < q; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char alphabet = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int answer = solution(alphabet, start, end);
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}
