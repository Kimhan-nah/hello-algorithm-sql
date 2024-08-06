import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] increaseDp;
    private static int[] decreaseDp;

    private static int solution() {
        int max = 1;

        // increase
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[i] > arr[j]) {
                    increaseDp[i] = Math.max(increaseDp[i], increaseDp[j] + 1);
                }
            }
        }

        // decrease
        for (int i = N - 1; i >= 0; --i) {
            for (int j = N - 1; j > i; --j) {
                if (arr[i] > arr[j]) {
                    decreaseDp[i] = Math.max(decreaseDp[i], decreaseDp[j] + 1);
                }
            }
        }

        // find max
        for (int i = 0; i < N; ++i) {
            max = Math.max(max, increaseDp[i] + decreaseDp[i] - 1);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        increaseDp = new int[N];
        decreaseDp = new int[N];

        Arrays.fill(increaseDp, 1);
        Arrays.fill(decreaseDp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = solution();
        System.out.println(answer);
    }
}
