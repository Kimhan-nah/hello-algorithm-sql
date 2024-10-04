import java.util.*;

class Solution {
    private static int minDiff = Integer.MAX_VALUE;
    private static int[][] graph;
    
    private int dfs(boolean[] visited, int n, int vertex, int level) {
        int count = 0;
        visited[vertex] = true;
        
        for (int i = 1; i <= n; ++i) {
            if (visited[i] || graph[vertex][i] == 0) continue;
            count += dfs(visited, n, i, level + 1);
        }
        return count + 1;
    }
    
    public int solution(int n, int[][] wires) {
        graph = new int[n + 1][n + 1];
        for (int i = 0; i < n - 1; ++i) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        for (int i = 0; i < n - 1; ++i) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1][v2] = 0;
            graph[v2][v1] = 0;
            boolean[] visited = new boolean[n + 1];
            int count1 = dfs(visited, n, v1, 0);
            int count2 = dfs(visited, n, v2, 0);
            minDiff = Math.min(minDiff, Math.abs(count1 - count2));
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        return minDiff;
    }
}