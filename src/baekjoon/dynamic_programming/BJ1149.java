package baekjoon.dynamic_programming;

import java.util.*;
import java.io.*;

public class BJ1149 {
    private static final int R = 0, G = 1, B = 2;
    private static int[][] dp;
    private static int n;

    private static void solution(int index) {
        if (index > n) return ;
        dp[index][R] += Math.min(dp[index - 1][G], dp[index - 1][B]);
        dp[index][G] += Math.min(dp[index - 1][R], dp[index - 1][B]);
        dp[index][B] += Math.min(dp[index - 1][R], dp[index - 1][G]);
        solution(index + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3];

        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][R] = Integer.parseInt(st.nextToken());
            dp[i][G] = Integer.parseInt(st.nextToken());
            dp[i][B] = Integer.parseInt(st.nextToken());
        }
        solution(2);
        System.out.println(Arrays.stream(dp[n]).min().getAsInt());
    }
}
