import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		if (a + b + c >= 100) {
			System.out.println("OK");
		} else {
			int min = Math.min(a, Math.min(b, c));
			if (min == a) {
				System.out.println("Soongsil");
			} else if (min == b) {
				System.out.println("Korea");
			} else {
				System.out.println("Hanyang");
			}
		}

	}

}
