import java.util.*;

class Solution {
    
    int[] answer = new int[]{-1};
    int maxDiff = Integer.MIN_VALUE;
    
    public int[] solution(int n, int[] info) {
        dfs(0, n, new int[11], info);
        
        return answer;
    }
    
    private void dfs(int k, int remain, int[] ryan, int[] info) {
        if (remain < 0) return;
        
        // 경기 종료 
        if (k == 11 && remain > 0) {  // 남은 화살 있는 경우 
            ryan[k - 1] += remain;  // 마지막 점수에 화살 몰빵
            
            // 점수 계산 
            int diff = calcScore(ryan, info);
            if (diff == -1) return;
            
            if (diff > maxDiff) {
                maxDiff = diff;
                answer = Arrays.copyOf(ryan, ryan.length);
            } else if (maxDiff == diff) {
                compareRyan(ryan);
            }
            
            ryan[k - 1] -= remain;
            return;
        } else if (k == 11 && remain == 0){  // 화살 없는 경우 
            // 점수 계산 
            int diff = calcScore(ryan, info);
            if (diff == -1) return;
            
            if (diff > maxDiff) {
                maxDiff = diff;
                answer = Arrays.copyOf(ryan, ryan.length);
            } else if (maxDiff == diff) {
                compareRyan(ryan);
            }
            
            return;
        }
        
        int shotArrow = info[k];  // 어피치가 쏜 화살 수 
        
        ryan[k] = shotArrow + 1;
        dfs(k + 1, remain - ryan[k], ryan, info);  // 라이언이 해당 점수 가져가는 경우
        
        ryan[k] = 0;
        dfs(k + 1, remain, ryan, info);  // 라이언이 해당 점수 가져가지 않는 경우 
    }
    
    private int calcScore(int[] ryan, int[] apeach) {
        
        int ryanScore = 0;
        int apeachScore = 0;
        
        for (int i = 0; i < 11; i++) {
            if (ryan[i] > apeach[i]) ryanScore += (10 - i);
            else if (ryan[i] < apeach[i]) apeachScore += (10 - i);
        }
        
        return ryanScore > apeachScore ? ryanScore - apeachScore : -1;
    }
    
    private void compareRyan(int[] ryan) {
        for (int i = 10; i >= 0; i--) {
            if (ryan[i] > answer[i]) {
                answer = Arrays.copyOf(ryan, ryan.length);
                return;
            } 
            else if (ryan[i] < answer[i]) {
                return;
            }
        }
    }
}