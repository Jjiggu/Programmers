import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int left = n;
        
        for (int i = 0; i < enemy.length; i++) {
            left -= enemy[i];
            pq.add(enemy[i]);
            
            if (left < 0) {
                if (k > 0) {
                    left += pq.poll();
                    k--;   
                } else {
                    return i;
                }
            } 
        }
        
        return enemy.length;
    }
}