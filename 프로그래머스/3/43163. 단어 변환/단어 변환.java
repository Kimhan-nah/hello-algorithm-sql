import java.util.*;

class Solution {
    private static String target;
    private static String[] words;
    private static boolean[] visited;
    private static int answer = Integer.MAX_VALUE;
    
    private void recursive(String word, int level) {
        if (word.equals(target)) {
            answer = Math.min(answer, level);
            return ;
        }
        
        // 현재 단어 -> 다음 단어
        for (int i = 0; i < words.length; ++i) {
            if (!visited[i] && changeable(word, words[i])) {
                visited[i] = true;
                recursive(words[i], level + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean changeable(String word, String next) {
        int count = 0;
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) != next.charAt(i)) ++count;
        }
        return count == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        // 현재 단어 -> 다음 단어(알파벳 하나 변경) -> 만들어진 단어가 target과 동일하면 answer의 최솟값으로 갱신
        this.target = target;
        this.words = words;
        visited = new boolean[words.length];
        recursive(begin, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}