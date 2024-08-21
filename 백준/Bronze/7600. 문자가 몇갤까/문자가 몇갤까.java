import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine().toLowerCase();
            if (str.equals("#")) {
                break;
            }
            Set<Character> alphabets = new HashSet<>();
            for (char ch : str.toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    alphabets.add(ch);
                }
            }
            sb.append(alphabets.size()).append("\n");
        }
        System.out.print(sb);
    }
}
