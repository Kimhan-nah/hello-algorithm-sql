import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int M, N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int answer = binarySearch();
        System.out.println(answer);
    }

    private static int binarySearch() {
        int answer = 0;
        int left = 1, right = arr[N - 1];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;

            for (int i = N - 1; i >= 0; --i) {
                count += (arr[i] / mid);
                if (count >= M)
                    break;
            }
            if (count < M) {
                right = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
        }

        return answer;
    }
}
