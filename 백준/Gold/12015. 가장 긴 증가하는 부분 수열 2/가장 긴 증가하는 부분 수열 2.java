import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int length = 1;
    private static int[] arr;
    private static int[] LIS = new int[1000000];

    private static int binarySearch(int value, int left, int right) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;  // 중간값 설정

            if (LIS[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static void solution() {
        LIS[0] = arr[0];

        for (int i = 1; i < N; ++i) {
            if (arr[i] > LIS[length - 1]) {
                LIS[length++] = arr[i];
            } else {
                int index = binarySearch(arr[i], 0, length - 1);
                LIS[index] = arr[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(length);
    }
}
