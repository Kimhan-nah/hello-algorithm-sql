import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, K, L;
    private static int[][] map;
    private static int[][] directions;
    private static int dir = 1; // right
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[row][col] = 2; // apple
        }
        L = Integer.parseInt(br.readLine());
        directions = new int[L][2];
        for (int i = 0; i < L; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            directions[i][0] = sec;
            directions[i][1] = dir.equals("L") ? 3 : 1;  // 'L'(왼쪽) -> 3, 'D'(오른쪽) -> 1
        }
        int answer = solution();
        System.out.println(answer);
    }

    private static int solution() {
        Queue<Point> queue = new LinkedList<>();
        int row = 1, col = 1, time = 0, idx = 0;
        map[row][col] = 1;
        queue.offer(new Point(row, col));

        while (true) {
            ++time;
            row += dy[dir];
            col += dx[dir];
            if (row < 1 || col < 1 || row > N || col > N || map[row][col] == 1)
                break;
            if (idx < directions.length && time == directions[idx][0]) {
                int nextDir = directions[idx][1]; // 3이면 왼쪽, 1이면 오른쪽
                // 오른쪽이면 +1, 왼쪽이면 -1
                dir = (dir + nextDir) % 4;
                ++idx;
            }

            if (map[row][col] == 0) {
                Point tail = queue.poll();  // 꼬리 자르기
                map[tail.row][tail.col] = 0;
            }
            map[row][col] = 1;
            queue.offer(new Point(row, col));
        }
        return time;
    }

    private static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
