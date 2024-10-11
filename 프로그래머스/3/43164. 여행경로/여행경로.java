import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> 
                    o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));
        
        List<String> route = new ArrayList<>();
        route.add("ICN");
        
        boolean[] used = new boolean[tickets.length];
        dfs("ICN", tickets, used, route, tickets.length);
        
        return route.toArray(new String[0]);
    }
    
    private boolean dfs(String current, String[][] tickets, boolean[] used, List<String> route, int remainingTickets) {
        if (remainingTickets == 0) {
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                route.add(tickets[i][1]);
                
                if (dfs(tickets[i][1], tickets, used, route, remainingTickets - 1)) {
                    return true;
                }
                
                used[i] = false;
                route.remove(route.size() - 1);
            }
        }
        
        return false;
    }
}