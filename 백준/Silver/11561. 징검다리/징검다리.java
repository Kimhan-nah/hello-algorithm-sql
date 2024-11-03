import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; ++i) {
            long N = Long.parseLong(br.readLine());
            long answer = binarySearch(N);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    private static long binarySearch(long N) {
        long left = 1, right = (long) Math.sqrt((2*N + 1));
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = mid * (mid + 1) / 2;
            if (sum > N) {
                right = mid - 1;
            } else {
                result = Math.max(result, mid);
                left = mid + 1;
            }
        }

        return result;
    }
}
