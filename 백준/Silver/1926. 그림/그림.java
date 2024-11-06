import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] arr;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
    }

    private static void solution() {
        int count = 0, maxArea = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (arr[i][j] == 1) {
                    ++count;
                    int area = dfs(i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        System.out.println(count + "\n" + maxArea);
    }

    private static int dfs(int row, int col) {
        int area = 1;
        arr[row][col] = 2;

        for (int i = 0; i < 4; ++i) {
            int nextRow = row + dy[i];
            int nextCol = col + dx[i];
            if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m || arr[nextRow][nextCol] != 1)
                continue;
            area += dfs(nextRow, nextCol);
        }
        return area;
    }
}
