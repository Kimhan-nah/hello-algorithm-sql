import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("#"))
                break;
            char[] arr = str.toCharArray();
            int answer = 0;
            for (int i = 0; i < arr.length; ++i) {
                int exponent = arr.length - i - 1;
                switch (arr[i]) {
                    case '-':
                        break;
                    case '\\':
                        answer += (int)(Math.pow(8, exponent) * 1);
                        break;
                    case '(':
                        answer += (int)(Math.pow(8, exponent) * 2);
                        break;
                    case '@':
                        answer += (int)(Math.pow(8, exponent) * 3);
                        break;
                    case '?':
                        answer += (int)(Math.pow(8, exponent) * 4);
                        break;
                    case '>':
                        answer += (int)(Math.pow(8, exponent) * 5);
                        break;
                    case '&':
                        answer += (int)(Math.pow(8, exponent) * 6);
                        break;
                    case '%':
                        answer += (int)(Math.pow(8, exponent) * 7);
                        break;
                    case '/':
                        answer += (int)(Math.pow(8, exponent) * -1);
                        break;
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

}
