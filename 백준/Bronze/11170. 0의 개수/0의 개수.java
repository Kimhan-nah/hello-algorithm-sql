import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int countZero(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch - '0' == 0) {
                ++count;
            }
        }
        return count;
    }

    private static int solution(int n, int m) {
        int count = 0;

        for (int i = n; i <= m; ++i) {
            count += countZero(Integer.toString(i));
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
