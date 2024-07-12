import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static int n;
	private static Map<Integer, String> input;
	private static Map<Integer, String> output;

	private static int findOutputKey(String value) {
		return output.entrySet().stream()
			.filter(entry -> entry.getValue().equals(value))
			.map(Map.Entry::getKey)
			.findFirst()
			.get();
	}

	private static int solution() {
		int inputIndex = 0;
		int prevIndex = findOutputKey(input.get(inputIndex));
		int count = 0;

		while (inputIndex < n) {
			String inputValue = input.get(inputIndex++);
			int outputIndex = findOutputKey(inputValue);
			if (prevIndex > outputIndex) {
				++count;
				continue;
			}
			prevIndex = outputIndex;
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		input = new HashMap<>();
		output = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			input.put(i, br.readLine());
		}
		for (int i = 0; i < n; ++i) {
			output.put(i, br.readLine());
		}
		int answer = solution();
		System.out.println(answer);
	}
}
