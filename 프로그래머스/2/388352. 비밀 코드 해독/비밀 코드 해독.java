import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        dfs(0, 0, arr, n, q, ans);
        
        return answer;
    }
    
    private void dfs(int start, int k, ArrayList<Integer> arr, int n, int[][] q, int[] ans) {
        if (arr.size() == 5) {
            if (check(arr, q, ans)) answer++;
            return;
        }
        
        int cnt = 0;
        for (int i = start; i < n; i++) {
            arr.add(i + 1);
            dfs(i + 1, k + 1, arr, n, q, ans);
            arr.remove(arr.size() - 1);
        }
    }
    
    private boolean check(ArrayList<Integer> arr, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int num : q[i]) {
                if (arr.contains(num)) cnt++;
            }
            
            if (cnt != ans[i]) return false;
        }
        
        return true;   
    }
}