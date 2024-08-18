import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] arr;

    private static int binarySearch() {
        int answer = Integer.MIN_VALUE;
        int left = 1, right = arr[N - 1];
        // int left = arr[0], right = arr[N - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < N; ++i) {
                sum += Math.min(arr[i], mid);
            }

            if (sum > M) {
                right = mid - 1;
            } else if (sum < M) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int answer = binarySearch();
        System.out.println(answer);
    }
}
