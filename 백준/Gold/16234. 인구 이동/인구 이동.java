import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, L, M;
    private static int[][] map;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = solution();
        System.out.println(answer);
    }

    private static int solution() {
        int count = 0;

        while (true) {
            List<List<Point>> groups = new ArrayList<>();
            boolean[][] visited = new boolean[N][N];

            // 인접한 곳 확인 -> 국경선 열기
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (visited[i][j])
                        continue;
                    List<Point> list = open(visited, i, j);
                    groups.add(list);
                }
            }

            // 연합국 이동 (필요없으면 종료)
            if (groups.size() == N * N)
                break;
            for (List<Point> group : groups) {
                if (group.size() <= 1)
                    continue;
                int population = 0;
                for (Point p : group) {
                    population += map[p.row][p.col];
                }
                population /= group.size();
                move(group, population);

            }

            ++count;
        }
        return count;
    }

    private static List<Point> open(boolean[][] visited, int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> list = new ArrayList<>();

        queue.offer(new Point(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            list.addAll(queue);

            for (int i = 0; i < size; ++i) {
                Point p = queue.poll();
                // visited[p.row][p.col] = true;
                for (int j = 0; j < 4; ++j) {
                    int nextRow = p.row + dy[j];
                    int nextCol = p.col + dx[j];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N || visited[nextRow][nextCol])
                        continue;
                    int abs = Math.abs(map[p.row][p.col] - map[nextRow][nextCol]);
                    if (abs >= L && abs <= M) {
                        visited[nextRow][nextCol] = true;
                        queue.offer(new Point(nextRow, nextCol));
                    }
                }
            }
        }
        return list;
    }

    private static void move(List<Point> group, int population) {
        for (Point p : group) {
            map[p.row][p.col] = population;
        }
    }

    private static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
