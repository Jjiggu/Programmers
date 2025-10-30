import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int cnt = 0;
        
        for (long sco : scoville) pq.offer(sco);
        
        while (!pq.isEmpty() && pq.peek() < K) {
            
            if (pq.size() < 2) return -1;
            
            long curFir = pq.poll();
            long curSec = pq.poll();
            long newFood = curFir + curSec * 2;
            
            pq.offer(newFood);
            cnt++;
        }
        
        return cnt;
    }
}