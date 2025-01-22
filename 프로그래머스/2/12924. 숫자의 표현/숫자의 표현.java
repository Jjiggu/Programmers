class Solution {
    static int cnt = 0;
    
    public int solution(int n) {
        dfs(1, n);
        
        return cnt;
    }
    
    
    public void dfs(int start, int target) {
        int result = 0;
        
        // if (start == target) {
        //     cnt++;
        //     return;
        // }
        
        for (int i = start; i <= target; i++) {
            result += i;
            
            if (result == target) {
                cnt++;
                dfs(start + 1, target);
                return;
            } else if (result > target) {
                dfs(start + 1, target);
                return;
            }
        }
    }
}