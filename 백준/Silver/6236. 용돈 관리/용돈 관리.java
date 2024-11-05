import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = binarySearch();
        System.out.println(answer);
    }

    private static int binarySearch() {
        int answer = Integer.MAX_VALUE;
        int max = Arrays.stream(arr).max().getAsInt();
        int left = max, right = 1000000000;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int amount = mid;
            for (int i = 0; i < N; ++i) {
                if (arr[i] > amount) {
                    amount = mid;
                    ++count;
                }
                amount -= arr[i];

                if (count > M)
                    break;
            }
            if (count <= M) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer == Integer.MAX_VALUE ? max : answer;
    }
}
