import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		long answer = fact(num);
		System.out.println(answer);
	}

	public static long fact(int n) {
		if (n <= 1)
			return 1;
		else
			return fact(n - 1) * n;
	}

}
