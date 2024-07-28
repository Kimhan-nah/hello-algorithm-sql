import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = {64, 32, 16, 8, 4, 2, 1};

		int count = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (n >= arr[i]) {
				++count;
				n -= arr[i];
			}
			if (n == 0)
				break;
		}
		System.out.println(count);
	}
}
