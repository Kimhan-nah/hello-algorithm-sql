import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 1; j < 5; ++j) {
                if (!list.contains(list.get(i) + j))
                    ++count;
            }
            answer = Math.min(answer, count);
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
