import java.util.*;

class Solution {        
    public int solution(int n, int[][] results) {
        int[][] matchResult = new int[n + 1][n + 1];
        int answer = 0;
        
        for (int[] result : results) {
            int win = result[0];
            int defeat = result[1];
            
            matchResult[win][defeat] = 1; // 이긴 경우
            matchResult[defeat][win] = 2; // 진 경우
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matchResult[i][k] == 1 && matchResult[k][j] == 1) {
                        matchResult[i][j] = 1; // i가 j를 이긴다
                    }
                    if (matchResult[i][k] == 2 && matchResult[k][j] == 2) {
                        matchResult[i][j] = 2; // i가 j에게 진다
                    }
                }
            }
        }

        
        for (int[] match : matchResult) {
            int cnt = 0;
            
            for (int i = 1; i <= n; i++) {
                
                if (match[i] == 1 || match[i] == 2) cnt++;
            }
            
            if (cnt == n - 1) answer++;
        }
        
        return answer;
    }
}