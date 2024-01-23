package baekjoon.dynamic_programming;

import java.io.*;
import java.util.*;

public class BJ12865 {
    private static int[][] arr;
    private static int N, K;
    private static int answer = Integer.MIN_VALUE;

    private static void solution(int index, int weight, int value) {
        if (index == N) {
            answer = Math.max(answer, value);
            return ;
        }
        if (weight + arr[index][0] <= K) {
            solution(index + 1, weight + arr[index][0], value + arr[index][1]);
        }
        solution(index + 1, weight, value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][2];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            arr[i][0] = W;
            arr[i][1] = V;
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o2[1] == o1[1]) return o2[0] - o1[0];
            return o2[1] - o1[1];
        });
        solution(0, 0, 0);
        System.out.println(answer);
    }
}
