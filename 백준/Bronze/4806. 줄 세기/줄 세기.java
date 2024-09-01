import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        while (true) {
            String str = br.readLine();
            if (str == null)
                break;
            ++count;
        }
        System.out.println(count);

    }
}
