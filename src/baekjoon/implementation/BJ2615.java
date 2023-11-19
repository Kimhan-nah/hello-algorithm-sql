package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class BJ2615 {
    static int[][] arr = new int[19][19];
    static boolean[][][] isVisited = new boolean[19][19][4];
    static final int BLACK = 1;
    static final int WHITE = 2;
    // 오른쪽, 아래, 오른쪽아래, 왼쪽아래
    static int[] dx = {1, 0, 1, -1};
    static int[] dy = {0, 1, 1, 1};

    private static boolean checkWinner(int type, int row, int col) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < 4; ++i) {
            count = 1;
            if (isVisited[row][col][i]) continue;     // 이미 진행 방향으로 검사했는데 정답 아니었음
            for (int j = 1; ; ++j) {
                int currentRow = row + dy[i] * j;
                int currentCol = col + dx[i] * j;
                if (currentRow < 0 || currentRow >= 19 || currentCol < 0 || currentCol >= 19) break;
                if (arr[currentRow][currentCol] != type) break;
                ++count;
                isVisited[currentRow][currentCol][i] = true;
            }
            if (count == 5) {
                sb.append(type).append("\n");
                if (i == 3) {       // 왼쪽아래 방향일 경우
                    sb.append(row + 5).append(" ").append(col - 3).append("\n");
                } else {
                    sb.append(row + 1).append(" ").append(col + 1).append("\n");
                }
                System.out.println(sb);
                return true;
            }
        }
        return false;
    }

    private static void solution() {
        for (int i = 0; i < 19; ++i) {
            for (int j = 0; j < 19; ++j) {
                if (arr[i][j] == BLACK) {
                    if (checkWinner(BLACK, i, j)) return ;
                } else if (arr[i][j] == WHITE) {
                    if (checkWinner(WHITE, i, j)) return ;
                }
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 19; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
    }
}
