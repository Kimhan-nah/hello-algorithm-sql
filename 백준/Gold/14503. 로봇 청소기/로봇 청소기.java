import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    private static boolean checkClean(int row, int col) {
        for (int i = 0; i < 4; ++i) {
            int nextRow = row + dy[i];
            int nextCol = col + dx[i];
            if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) {
                continue;
            }
            if (map[nextRow][nextCol] == 0) {
                return false;
            }
        }
        return true;
    }

    private static int solution(int startRow, int startCol, int startDir) {
        int row = startRow, col = startCol, dir = startDir;
        int count = 0;

        while (true) {
            if (map[row][col] == 0) {
                map[row][col] = 2;
                ++count;
            }

            if (checkClean(row, col)) { // 청소 필요 없는 경우
                int backDir = (dir + 2) % 4;
                int nextRow = row + dy[backDir];
                int nextCol = col + dx[backDir];

                // 불가능하면 멈추기
                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M || map[nextRow][nextCol] == 1) {
                    return count;
                }
                // 후진 가능하면, 후진
                row = nextRow;
                col = nextCol;
            } else {
                dir = (dir == 0 ? 3 : dir - 1);
                int nextRow = row + dy[dir];
                int nextCol = col + dx[dir];
                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M)
                    continue;
                if (map[nextRow][nextCol] == 0) {
                    row = nextRow;
                    col = nextCol;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = solution(startRow, startCol, direction);
        System.out.println(answer);
    }
}
