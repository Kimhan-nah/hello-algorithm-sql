import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int max = Integer.MIN_VALUE;
    private static int[] prefixSum;

    private static int binarySearch(int target) {
        int left = 0, right = N - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] == target) {
                return mid;
            }
            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private static int solution() {
        int size = Math.max(prefixSum[N - 1] / M, max);

        while (true) {
            int target = size;
            int index = 0;

            for (int i = 0; i < M; ++i) {
                index = binarySearch(target);
                target = prefixSum[index] + size;
            }
            if (index == N - 1) {
                break;
            }
            ++size;
        }
        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prefixSum = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; ++i) {
            int input = Integer.parseInt(st.nextToken());
            max = Math.max(max, input);
            prefixSum[i] = i != 0 ? prefixSum[i - 1] + input : input;
        }
        int answer = solution();
        System.out.println(answer);
    }
}
