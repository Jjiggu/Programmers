import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = scoville.length;
        int cnt = 0;
        
        for (int i = 0; i < n; i++) pq.offer(scoville[i]);
        
        while (pq.size() >= 2 && cnt <= n * 3 + 1) {
            if (pq.peek() >= K) break;
            
            int first = pq.poll();
            int second = pq.poll();
            
            pq.offer(first + second * 2);
            cnt++;
        }
        
        return pq.peek() < K ? -1 : cnt;
    }
}