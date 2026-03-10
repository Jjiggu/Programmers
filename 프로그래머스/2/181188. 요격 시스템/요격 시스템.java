import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int curStart = targets[0][0];
        int curEnd = targets[0][1];
        
        for (int i = 1; i < targets.length; i++) {
            int[] target = targets[i];
            int start = target[0];
            int end = target[1];
            
            if (start >= curEnd) {
                answer++;
                curEnd = end;
            }
        }
        
        return answer;
    }
}