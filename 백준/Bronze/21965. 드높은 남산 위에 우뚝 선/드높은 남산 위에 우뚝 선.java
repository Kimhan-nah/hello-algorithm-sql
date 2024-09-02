import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int prev = 0;
        boolean increase = true;
        for (int i = 0; i < n; ++i) {
            int num = Integer.parseInt(st.nextToken());

            if (!increase && prev <= num) {
                System.out.println("NO");
                return;
            }

            if (increase && prev >= num) {
                increase = false;
            }
            prev = num;
        }
        System.out.println("YES");

    }
}
