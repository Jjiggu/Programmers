import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]); 
        
        int answer = 0;
        int pos = Integer.MIN_VALUE;
        
        for (int[] route : routes) {    
            if (pos < route[0]) {
                pos = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}