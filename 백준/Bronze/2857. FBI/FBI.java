import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean flag = false;

		for (int i = 1; i <= 5; ++i) {
			String name = br.readLine();
			if (name.contains("FBI")) {
				sb.append(i).append(" ");
				flag = true;
			}
		}
		if (!flag) {
			sb.append("HE GOT AWAY!");
		}
		System.out.println(sb);
	}

}
