import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; ++i) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 1) + 1);
        }
        
        int total = 1;
        for (String key : map.keySet()) {
            total *= map.get(key);
        }
        total -= 1;
        return total;
    }
}