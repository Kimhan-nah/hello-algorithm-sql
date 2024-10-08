import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < N; ++i) {
                set.add(Integer.parseInt(br.readLine()));
            }
            int count = 0;
            for (int j = 0; j < M; ++j) {
                if (set.contains(Integer.parseInt(br.readLine()))) {
                    ++count;
                }
            }
            System.out.println(count);
        }
    }
}
