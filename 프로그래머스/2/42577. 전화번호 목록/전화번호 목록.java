import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        int n = phone_book.length;
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; ++i) {
            set.add(phone_book[i]);
        }
        
        for (int i = 0; i < n; ++i) {
            String target = phone_book[i];
            set.remove(target);
            for (int j = 1; j <= target.length(); ++j) {
                String substr = target.substring(0, j);
                if (set.contains(substr)) return false;
            }
            set.add(target);
        }
        
        return true;
    }
}