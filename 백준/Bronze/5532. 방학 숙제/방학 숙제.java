import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        double A = Double.parseDouble(br.readLine());
        double B = Double.parseDouble(br.readLine());
        double C = Double.parseDouble(br.readLine());
        double D = Double.parseDouble(br.readLine());

        int answer = L - (int)Math.max(Math.ceil(A / C), Math.ceil(B / D));
        System.out.println(answer);
    }
}
