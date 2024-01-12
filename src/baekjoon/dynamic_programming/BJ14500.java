package baekjoon.dynamic_programming;

import java.util.*;
import java.io.*;

public class BJ14500 {
    private static int n, m;
    private static int[][] map;
    private static int answer = Integer.MIN_VALUE;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static boolean[][] visited;

    private static void dfs(int row, int col, int count, int sum) {
        if (row < 0 || col < 0 || row >= n ||col >= m || visited[row][col]) return ;
        if (count == 4) {
            answer = Math.max(answer, sum);
            return ;
        }
        for (int k = 0; k < 4; ++k) {
            visited[row][col] = true;
            dfs(row + dy[k], col + dx[k], count + 1, sum + map[row][col]);
            visited[row][col] = false;
        }
    }

    private static void combi(int d, int row, int col, int count, int sum) {
        if (count == 3) {
            answer = Math.max(answer, sum);
            return ;
        }
        if (d >= 4 || row < 0 || col < 0 || row >= n ||col >= m || visited[row][col]) return ;
        combi(d + 1, row, col, count, sum);
        int nx = col + dx[d];
        int ny = row + dy[d];
        if (ny < 0 || nx < 0 || ny >= n ||nx >= m || visited[row][col]) return ;
        combi(d + 1, row, col, count + 1, sum + map[ny][nx]);
    }

    private static void solution() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dfs(i, j, 0, 0);
                combi(0, i, j, 0, map[i][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(answer);
    }
}
