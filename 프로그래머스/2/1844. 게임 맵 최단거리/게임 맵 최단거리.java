import java.util.*;

class Solution {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int n, m;	// n은 row 길이, m은 col 길이
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        int distance = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++distance;
            for (int i = 0; i < size; ++i) {
                Point p = queue.poll();
                if (p.row == n - 1 && p.col == m - 1) return distance;
                for (int j = 0; j < 4; ++j) {
                    int nextRow = p.row + dy[j];
                    int nextCol = p.col + dx[j];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m
                        || maps[nextRow][nextCol] == 0) continue;
                    queue.offer(new Point(nextRow, nextCol));
                    maps[nextRow][nextCol] = 0;
                }
            }
        }
        return -1;
    }
    
    private class Point {
        int row, col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}