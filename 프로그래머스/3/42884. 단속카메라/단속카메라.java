import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] r1, int[] r2) {
                return r1[1] - r2[1];
            }
        }); 
        
        int answer = 0;
        int pos = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            
            if (start > pos || pos > end) {
                answer++;
                pos = end;
            }
        }
        
        return answer;
    }
}