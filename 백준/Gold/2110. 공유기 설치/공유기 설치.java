import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, C;
    private static int[] arr;

    private static int solution() {
        int answer = Integer.MIN_VALUE;
        int left = 1, right = arr[N - 1] - arr[0];

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int prev = arr[0];

            for (int i = 1; i < N; ++i) {
                if (arr[i] - prev >= mid) {
                    ++count;
                    prev = arr[i];
                }
            }
            if (count < C) {
                right = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int answer = solution();
        System.out.println(answer);
    }
}
