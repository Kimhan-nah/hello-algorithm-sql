import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] trees;

    private static int solution() {
        int low = 0;
        int high = trees[N - 1];

        while (low <= high) {
            int mid = (high + low) / 2;
            long length = 0;
            for (int i = 0; i < N; ++i) {
                length += (trees[i] < mid ? 0 : trees[i] - mid);
            }
            if (length >= M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int answer = solution();
        System.out.println(answer);
    }
}
