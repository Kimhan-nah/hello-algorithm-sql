import java.util.*;

class Solution {
    private static int n;
    private static Set<Integer> answers = new HashSet<>();
    private static boolean[] used;
    
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i < num; ++i) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    private void recursive(String current, String numbers) {
        if (current.length() > 0) {
            // 소수인지 확인 -> 맞으면 answers에 추가
            int num = Integer.parseInt(current);
            if (isPrime(num)) answers.add(num);
        }
        if (current.length() == n) {
            return ;
        }
        
        for (int i = 0; i < n; ++i) {
            if (used[i]) continue;
            used[i] = true;
            recursive(current + numbers.charAt(i), numbers);
            used[i] = false;
        }
        
    }
    
    public int solution(String numbers) {
        n = numbers.length();
        used = new boolean[n];
        recursive("", numbers);
        return answers.size();
    }
}