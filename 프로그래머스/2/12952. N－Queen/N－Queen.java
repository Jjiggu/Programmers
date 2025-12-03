class Solution {   
    
    int answer = 0;
    int n;
    int[] arr;
    
    public int solution(int n) {
        this.n = n;
        arr = new int[n];
        
        dfs(0);
        
        return answer;
    }
    
    private void dfs(int k) {
        if (k == n) {
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            arr[k] = i;
            if (isPossible(k)) dfs(k + 1);
        }
    }
    
    private boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) return false;
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }
        
        return true;
    }
}