import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int maxEnd = 0;
        
        for (int i = 0; i < targets.length; i++) {
            int[] cur = targets[i];
            int start = cur[0];
            int end = cur[1];
            
            // 시작 구간이 끝나는 구간보다 큰 경우 +1 하고 구간 갱신 
            if (start >= maxEnd) {
                answer++;
                maxEnd = Math.max(maxEnd, end);
            }
        }
        
        return answer;
    }
}