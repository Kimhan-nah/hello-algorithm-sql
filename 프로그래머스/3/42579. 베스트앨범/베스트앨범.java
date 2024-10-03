import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new LinkedList<>();
        // <장르, 재생수>
        Map<String, Integer> total = new HashMap<>();
        // <장르, <고유번호, 재생수>>
        Map<String, Map<Integer, Integer>> info = new HashMap<>();
        int n = genres.length;
        
        for (int i = 0; i < n; ++i) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
            info.putIfAbsent(genres[i], new HashMap<>());
            info.get(genres[i]).put(i, plays[i]);
        }
        // sort
        List<Map.Entry<String, Integer>> rank = new LinkedList<>(total.entrySet());
        rank.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        
        for (Map.Entry<String, Integer> entry : rank) {
            String genre = entry.getKey();
            Map<Integer, Integer> tmp = info.get(genre);
            // sort
            List<Map.Entry<Integer, Integer>> sorted = new LinkedList<>(tmp.entrySet());
            sorted.sort(
                    Comparator.<Map.Entry<Integer, Integer>>comparingInt(Map.Entry::getValue).reversed()
    .thenComparingInt(Map.Entry::getKey)
            );
            
            int count = 0;
            for (Map.Entry<Integer, Integer> music : sorted) {
                answer.add(music.getKey());
                ++count;
                if (count == 2) break;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}