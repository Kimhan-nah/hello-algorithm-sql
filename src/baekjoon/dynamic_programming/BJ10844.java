package baekjoon.dynamic_programming;

import java.io.*;
import java.util.Arrays;

public class BJ10844 {
    private static long[][] dp;
    private static final long mod = 1000000000;

    private static void solution(int n) {
        for (int i = 2; i <= n; ++i) {
            dp[i][0] = dp[i - 1][1] % mod;
            dp[i][9] = dp[i - 1][8] % mod;
            for (int j = 1; j < 9; ++j) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];
        for (int i = 1; i < 10; ++i) {
            dp[1][i] = 1;
        }
        solution(n);
        System.out.println(Arrays.stream(dp[n]).sum() % mod);
    }
}
