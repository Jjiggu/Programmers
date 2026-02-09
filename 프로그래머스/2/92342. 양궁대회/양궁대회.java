import java.util.*;

class Solution {
    
    int maxScore = 0;
    int[] answer = {-1};
    
    public int[] solution(int n, int[] info) {
        dfs(0, n, new int[11], info);
        
        return answer;
    }
    
    private void dfs(int k, int remain, int[] ryan, int[] info) {
        if (k == 11) {
            if (remain > 0) ryan[10] += remain;
            
            int[] scoreArr = calcScore(ryan, info);
            int diff = scoreArr[0] - scoreArr[1];
            
            if (diff > 0 && diff > maxScore) {
                maxScore = diff;
                answer = Arrays.copyOf(ryan, 11);
            } else if (diff > 0 && diff == maxScore) {
                for (int i = 10; i >= 0; i--) {
                    if (ryan[i] > answer[i]) {
                        answer = Arrays.copyOf(ryan, 11);
                        break;
                    } else if (ryan[i] < answer[i]) {
                        break;
                    }
                }
            }
            
            if (remain > 0) ryan[10] -= remain;
            return;
        }
        
        if (remain > info[k]) {
            ryan[k] = info[k] + 1;
            dfs(k + 1, remain - ryan[k], ryan, info);
            ryan[k] = 0; 
        }
        
        dfs(k + 1, remain, ryan, info);
    }
    
    private int[] calcScore(int[] ryan, int[] info) {
        int ryanCalc = 0;
        int apeachCalc = 0;
        
        for (int i = 0; i < 11; i++) {
            if (ryan[i] == 0 && info[i] == 0) continue;
            if (ryan[i] > info[i]) ryanCalc += (10 - i);
            else apeachCalc += (10 - i);
        }
        
        return new int[]{ryanCalc, apeachCalc};
    }
}
