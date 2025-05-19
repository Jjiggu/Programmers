import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
    	PriorityQueue<Integer> teamA = new PriorityQueue<>();
        PriorityQueue<Integer> teamB = new PriorityQueue<>();
        
        for (int a : A) teamA.offer(a);
        for (int b : B) teamB.offer(b);
        
        return canWin(teamA, teamB);
    }
    
    
    public int canWin(PriorityQueue<Integer> teamA, PriorityQueue<Integer> teamB) {
        int cnt = 0;
        
        while(!teamB.isEmpty()) {
            int aNum = teamA.poll();
            int bNum = teamB.poll();
            
            if (aNum < bNum) cnt++;
            else teamA.offer(aNum);
        }
        
        return cnt;
    }
}