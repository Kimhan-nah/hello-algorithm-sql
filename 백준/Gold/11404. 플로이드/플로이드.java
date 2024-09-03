import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] arr;

    private static void dfs(int start, int row, int cost) {
        for (int i = 1; i <= n; ++i) {
            if (start == i || arr[row][i] == Integer.MAX_VALUE)
                continue;
            int nextCost = cost + arr[row][i];
            if (nextCost >= arr[start][i])
                continue;
            arr[start][i] = nextCost;
            dfs(start, i, nextCost);
        }
    }

    private static void solution() {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == j || arr[i][j] == Integer.MAX_VALUE)
                    continue;
                dfs(i, j, arr[i][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        for (int i = 0; i <= n; ++i) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[start][end] = Math.min(arr[start][end], cost);
        }
        solution();

        // print
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                System.out.print((arr[i][j] == Integer.MAX_VALUE ? 0 : arr[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
