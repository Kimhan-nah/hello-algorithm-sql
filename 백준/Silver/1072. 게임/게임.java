import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int X, Y, Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = (int)(Y * 100L / X);

        int answer = solution();
        System.out.println(answer);
    }

    private static int solution() {
        int left = 0, right = X;
        int answer = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int z = (int)((Y + mid) * 100L / (X + mid));
            if (z == Z) {
                left = mid + 1;
            } else if (z > Z) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
