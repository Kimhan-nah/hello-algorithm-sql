import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] board;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(board[i], -1);
            for (int j = 0; j < M; ++j) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    board[i][j] = 1;
            }
        }

        // parsing 외부 0으로
        updateInnerToOuter(0, 0);

        int answer = solution();
        System.out.println(answer);
    }

    private static void updateInnerToOuter(int row, int col) {
        board[row][col] = 0;

        for (int i = 0; i < 4; ++i) {
            int nextRow = row + dy[i];
            int nextCol = col + dx[i];
            if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M || board[nextRow][nextCol] != -1)
                continue;
            updateInnerToOuter(nextRow, nextCol);
        }
    }

    private static int solution() {
        int time = 0;

        while (!isFinished()) {
            Queue<Point> tmp = new LinkedList<>();
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (board[i][j] == 1 && checkMelt(i, j))
                        tmp.offer(new Point(i, j));
                }
            }
            // melt
            for (Point p : tmp) {
                updateInnerToOuter(p.row, p.col);
            }
            ++time;
        }
        return time;
    }

    private static boolean isFinished() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    private static boolean checkMelt(int row, int col) {
        int count = 0;

        for (int i = 0; i < 4; ++i) {
            int nextRow = row + dy[i];
            int nextCol = col + dx[i];
            if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M || board[nextRow][nextCol] != 0)
                continue;
            ++count;
        }

        return count >= 2;
    }

    private static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
