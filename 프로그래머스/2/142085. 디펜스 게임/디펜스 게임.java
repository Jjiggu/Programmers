import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int left = n;
        
        for (int i = 0; i < enemy.length; i++) {
            left -= enemy[i];
            pq.add(enemy[i]);
            
            if (left < 0) { // 병사가 부족하면
                if (k > 0) { // 무적권 사용
                    left += pq.poll(); 
                    k--;
                } else {
                    return i; // 더 이상 못 막음
                }
            }
        }
        return enemy.length;
    }
}
