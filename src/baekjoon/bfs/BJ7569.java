package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class BJ7569 {
    private static int M, N, H;
    private static int[][][] arr;
    private static int[] dz = {1, -1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dx = {0, 0, 0, 0, 1, -1};

    private static int solution() {
        Queue<Point> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < M; ++k) {
                    if (arr[i][j][k] == 1) {
                        queue.offer(new Point(i, j, k));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Point point = queue.poll();
                for (int j = 0; j < 6; ++j) {
                    int z = point.z + dz[j];
                    int y = point.y + dy[j];
                    int x = point.x + dx[j];
                    if (z < 0 || y < 0 || x < 0 || z == H || y == N || x == M || arr[z][y][x] != 0) continue;
                    arr[z][y][x] = 1;
                    queue.offer(new Point(z, y, x));
                }
            }
            ++count;
        }

        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < M; ++k) {
                    if (arr[i][j][k] == 0) return -1;
                }
            }
        }

        return count - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        int total = 0;

        for (int height = 0; height < H; ++height) {
            for (int row = 0; row < N; ++row) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < M; ++col) {
                    arr[height][row][col] = Integer.parseInt(st.nextToken());
                    if (arr[height][row][col] != -1) ++total;
                }
            }
        }
        int answer = solution();
        System.out.println(answer);
    }

    static class Point {
        int x, y, z;

        public Point(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }

    }
}
