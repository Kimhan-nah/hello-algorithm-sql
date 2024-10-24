import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(answer);
    }

    private static void solution() {
        int left = 0, right = 0;
        int[] countFruit = new int[10];
        int kind = 0;

        for (; right < N; ++right) {
            ++countFruit[arr[right]];

            if (countFruit[arr[right]] == 1) {
                ++kind;
            }

            while (kind > 2) {
                --countFruit[arr[left]];
                if (countFruit[arr[left]] == 0)
                    --kind;
                ++left;
            }

            answer = Math.max(answer, right - left + 1);
        }
    }
}
