import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static int N;
    private static Set<Character> set = new HashSet<>();
    private static String[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new String[N];

        for (int i = 0; i < N; ++i) {
            String input = br.readLine();
            String[] split = input.split(" ");
            answer[i] = wordKey(split);
            if (answer[i] == null) {
                answer[i] = alphabetKey(split);
            }
            if (answer[i] == null) {
                answer[i] = input;
            }
        }

        // print
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static String wordKey(String[] split) {
        for (int i = 0; i < split.length; ++i) {
            String word = split[i].toLowerCase();
            char ch = word.charAt(0);
            if (!set.contains(ch)) {
                set.add(ch);
                return makeShortCut(split, i, 0);
            }
        }
        return null;
    }

    private static String alphabetKey(String[] split) {
        for (int i = 0; i < split.length; ++i) {
            String word = split[i].toLowerCase();
            for (int j = 0; j < word.length(); ++j) {
                char ch = word.charAt(j);
                if (!set.contains(ch)) {
                    set.add(ch);
                    return makeShortCut(split, i, j);
                }
            }
        }
        return null;
    }

    private static String makeShortCut(String[] split, int index1, int index2) {
        // index1 : split의 index, index2: word의 index
        StringBuilder shorCut = new StringBuilder();
        for (int i = 0; i < split.length; ++i) {
            if (i == index1) {
                for (int j = 0; j < split[i].length(); ++j) {
                    if (j == index2)
                        shorCut.append("[").append(split[i].charAt(j)).append("]");
                    else
                        shorCut.append(split[i].charAt(j));
                }
            } else {
                shorCut.append(split[i]);
            }
            shorCut.append(" ");
        }
        return shorCut.toString();
    }
}
