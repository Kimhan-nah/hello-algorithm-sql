import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] checked;
    static int res = -1;
    static List<Integer>[] relation;
    private static int n;

    private static void dfs(int start, int end, int cnt) {
        if (start == end) {
            res = cnt;
            return;
        }

        checked[start] = true;
        for (int i = 0; i < relation[start].size(); i++) {
            int next = relation[start].get(i);
            if (!checked[next]) {
                dfs(next, end, cnt + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        relation = new ArrayList[n + 1];
        checked = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            relation[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int info = Integer.parseInt(br.readLine());
        for (int i = 0; i < info; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relation[x].add(y);
            relation[y].add(x);
        }
        dfs(a, b, 0);
        System.out.println(res);
    }
}
