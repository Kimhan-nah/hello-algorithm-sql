import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            List<String> words = new ArrayList<>();
            String[] text = new String[n];
            for (int i = 0; i < n; ++i) {
                String str = br.readLine();
                text[i] = str;
                words.add(str.toLowerCase());
            }
            Collections.sort(words);
            String target = words.get(0);
            for (int i = 0; i < n; ++i) {
                if (text[i].toLowerCase().equals(target)) {
                    sb.append(text[i]).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }

}
