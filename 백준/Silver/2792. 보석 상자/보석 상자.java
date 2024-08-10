import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] arr;

    private static int solution(int max) {
        int answer = max;
        int left = 1, right = max;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < M; ++i) {
                count += arr[i] / mid;
                count += arr[i] % mid > 0 ? 1 : 0;
            }
            if (count <= N) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        int answer = solution(max);
        System.out.println(answer);
    }
}
