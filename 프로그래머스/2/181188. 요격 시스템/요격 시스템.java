import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparing(o1 -> o1[1]));
        int answer = 0;
        int last = -1;
        
        for (int[] target : targets) {
            int s = target[0];
            int e = target[1];
            if (last < s) {
                answer++;
                last = e - 1;
            }
        }
        
        return answer;
    }
}