package inflearn.section_10;

import java.util.*;
import java.io.*;

public class Main {
    private static int[] dp = new int[36];
    private static int solution(int n) {
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = solution(n);
        System.out.println(answer);
    }
}
