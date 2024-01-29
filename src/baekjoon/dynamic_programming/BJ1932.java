package baekjoon.dynamic_programming;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1932 {
    private static int[][] arr;
    private static int n;

    private static int solution() {
        for (int i = 2; i <= n; ++i) {
            arr[i][1] += arr[i - 1][1];
            arr[i][i] += arr[i - 1][i - 1];
            for (int j = 2; j < i; ++j) {
                arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
            }
        }
        return Arrays.stream(arr[n]).max().getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = solution();
        System.out.println(answer);
    }
}
