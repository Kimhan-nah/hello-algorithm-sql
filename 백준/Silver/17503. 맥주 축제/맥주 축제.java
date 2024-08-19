import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static Beer[] beers;

    private static int solution() {
        int answer = -1;
        int sum = 0;

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < K; ++i) {
            sum += beers[i].prefer;
            queue.offer(beers[i].prefer);

            if (queue.size() > N) {
                sum -= queue.poll();
            }

            if (queue.size() == N && sum >= M) {
                answer = beers[i].alchol;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        beers = new Beer[K];

        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine());
            beers[i] = new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // sort
        Arrays.sort(beers);

        int answer = solution();
        System.out.println(answer);
    }

    private static class Beer implements Comparable<Beer> {
        int prefer, alchol;

        public Beer(int prefer, int alchol) {
            this.prefer = prefer;
            this.alchol = alchol;
        }

        @Override
        public int compareTo(Beer o) {
            return this.alchol - o.alchol;
        }
    }
}
