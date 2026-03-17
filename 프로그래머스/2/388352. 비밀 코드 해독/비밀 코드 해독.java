import java.util.*;

class Solution {
    
    int answer = 0;
    int n;
    int[][] q;
    int[] ans;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        dfs(0, 1, new int[5]);
        
        return answer;
    }
    
    private void dfs(int k, int start, int[] arr) {
        if (k == 5) {
            if (isValid(arr)) answer++;
            return;
        }
        
        for (int i = start; i <= n; i++) {
            arr[k] = i;
            dfs(k + 1, i + 1, arr);
            arr[k] = 0;
        }
    }
    
    private boolean isValid(int[] cur) {
        for (int k = 0; k < q.length; k++) {
            int curCnt = 0;
            for (int i = 0; i < 5; i++) {
                int[] target = q[k];
                if (contains(cur, target[i])) curCnt++;
            }
            if (curCnt != ans[k]) return false;
        }
        return true;
    }
    
    private boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}