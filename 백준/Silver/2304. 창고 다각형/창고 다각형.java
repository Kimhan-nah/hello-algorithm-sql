import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = solution();
        System.out.println(answer);
    }

    private static int solution() {
        int area = 0;
        Arrays.sort(arr, Comparator.comparingInt(row -> row[0]));
        int maxIndex = findMaxIndex(0, n);

        int leftIndex = 0;
        for (int i = 0; i < maxIndex; ++i) {
            if (arr[leftIndex][1] < arr[i][1]) {
                area += ((arr[i][0] - arr[leftIndex][0]) * arr[leftIndex][1]);
                leftIndex = i;
            }
        }
        area += ((arr[maxIndex][0] - arr[leftIndex][0]) * arr[leftIndex][1]);

        int rightIndex = n - 1;
        for (int i = n - 1; i > maxIndex; --i) {
            if (arr[rightIndex][1] < arr[i][1]) {
                area += ((arr[rightIndex][0] - arr[i][0]) * arr[rightIndex][1]);
                rightIndex = i;
            }
        }
        area += ((arr[rightIndex][0] - arr[maxIndex][0]) * arr[rightIndex][1]);
        area += arr[maxIndex][1];

        return area;
    }

    private static int findMaxIndex(int start, int end) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = start;
        for (int i = start; i < end; ++i) {
            if (maxValue <= arr[i][1]) {
                maxValue = arr[i][1];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
