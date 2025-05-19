import java.util.*;

public class Solution {
    public int[] solution(int n, int s) {
        
        if (n > s) return new int[] {-1};
        
        int fillNum = s / n;
        int sumCnt = s % n;
        
        int[] answer = new int[n];
        Arrays.fill(answer, fillNum);
        
        for (int i = answer.length - 1; i >= 0; i--) {
            if (sumCnt == 0) break;
            
            answer[i] += 1;
            sumCnt--;
        }
        
        return answer;
    }
}
