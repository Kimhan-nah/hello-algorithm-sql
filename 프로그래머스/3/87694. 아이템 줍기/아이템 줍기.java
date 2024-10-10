import java.util.*;

class Solution {
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    private static int dir = 0; // 0:상, 1:우, 2:하, 3:좌
    private static int[][] map = new int[102][102];
    
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int i = 1; i <= 101; ++i) {
            Arrays.fill(map[i], -1);
        }
        
        // parsing
        for (int i = 0; i < rectangle.length; ++i) {
            int lx = rectangle[i][0] * 2;
            int ly = rectangle[i][1] * 2;
            int rx = rectangle[i][2] * 2;
            int ry = rectangle[i][3] * 2;
            for (int y = ly; y <= ry; ++y) {
                for (int x = lx; x <= rx; ++x) {
                    if (y > ly && y < ry && x > lx && x < rx) 
                        map[y][x] = 0;
                    else if (map[y][x] != 0)
                        map[y][x] = 1;
                }
            }
        }
        
        // bfs
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(characterX * 2, characterY * 2));
        int count = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; ++i) {
                Point p = queue.poll();
                map[p.y][p.x] = 0;	// visited
                if (p.x == itemX * 2 && p.y == itemY * 2) {
                    return count / 2;
                }
                
                for (int j = 0; j < 4; ++j) {
                    int nextX = p.x + dx[j];
                    int nextY = p.y + dy[j];
                    if (nextX < 1 || nextY < 1 || nextX > 101
                        || nextY > 101 || map[nextY][nextX] != 1) continue;
                    queue.offer(new Point(nextX, nextY));
                }
            }
            ++count;
        }
        return count;
    }
    
    class Point {
        int x, y;
        
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}