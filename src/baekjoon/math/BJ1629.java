package baekjoon.math;

import java.io.*;
import java.util.*;

// Fast Exponentiation Algorithm (빠른 거듭제곱 알고리즘)
public class BJ1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long answer = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                answer = (answer * a) % c;
            }
            a = (a * a) % c;
            b >>= 1;
        }
        System.out.println(answer);
    }
}
