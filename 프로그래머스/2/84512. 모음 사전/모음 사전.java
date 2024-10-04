class Solution {
    private static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    private static int answer = 0;
    private static boolean finished = false;
    
    private void recursive(String word, String current) {
        if (current.length() > 5) return ;
        if (current.equals(word)) {
            finished = true;
            return ;
        }
        
        ++answer;
        for (int i = 0; i < alpha.length; ++i) {
            if (finished) return ;
            recursive(word, current + alpha[i]);
        }
    }
    
    public int solution(String word) {
        recursive(word, "");
        return answer;
    }
}