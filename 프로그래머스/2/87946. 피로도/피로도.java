import java.util.*;

class Solution {
    private static int n;
    private static int max = Integer.MIN_VALUE;
    private static boolean[] visited;
    
    private void recursive(int current, int[][] dungeons, int count, int level) {
        if (level == n) {
            max = Math.max(max, count);
            return ;
        }
        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            if (current >= dungeons[i][0]) {
                visited[i] = true;
                recursive(current - dungeons[i][1], dungeons, count + 1, level + 1);
                visited[i] = false;
            }
            recursive(current, dungeons, count, level + 1);
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        recursive(k, dungeons, 0, 0);
        return max;
    }
}