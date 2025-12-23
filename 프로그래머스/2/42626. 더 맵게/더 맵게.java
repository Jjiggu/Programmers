import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = scoville.length;
        int tryCnt = 0;
        
        for (int i = 0; i < n; i++) pq.offer(scoville[i]);
        
        while (!pq.isEmpty()) {
            if (pq.size() == 1 && pq.peek() < K) return -1;
            if (pq.peek() >= K) break;
            
            int first = pq.poll();
            int second = pq.poll();
            int newScovile = first + second * 2;
            
            pq.offer(newScovile);
            tryCnt++;
        }
        
        return tryCnt;
    }
}