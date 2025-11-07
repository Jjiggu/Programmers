import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = 0;
        int curServer = 0;
        
        for (int time = 0; time < players.length; time++) {
            while (!pq.isEmpty() && pq.peek() <= time) {
                pq.poll();
                curServer--;
            }
            
            int required = players[time] / m;
            
            if (required > curServer) {
                int toAdd = required - curServer;
                total += toAdd;
                curServer += toAdd;
                
                for (int i = 0; i < toAdd; i++) pq.offer(time + k);
            }
            
        }
        return total;
    }
}