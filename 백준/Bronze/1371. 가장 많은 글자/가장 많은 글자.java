import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[26];
        int max = 0;

        while (true) {
            String str = br.readLine();
            if (str == null)
                break;
            for (char ch : str.toCharArray()) {
                if (ch == ' ')
                    continue;
                ++count[ch - 'a'];
                max = Math.max(max, count[ch - 'a']);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; ++i) {
            if (count[i] == max) {
                sb.append((char)('a' + i));
            }
        }
        System.out.println(sb);
    }

}
