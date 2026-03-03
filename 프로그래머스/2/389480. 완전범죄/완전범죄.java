class Solution {
    
    int minA = Integer.MAX_VALUE;
    int n, m;
    
    public int solution(int[][] info, int n, int m) {
        this.n = n;
        this.m = m;
        
        boolean[][][] visited = new boolean[info.length][n][m];
        dfs(0, 0, 0, info, visited);
        
        return minA == Integer.MAX_VALUE ? -1 : minA;
    }
    
    private void dfs(int k, int ACnt, int BCnt, int[][] info, boolean[][][] visited) {
        // 잡힌 경우
        if (ACnt >= n || BCnt >= m) return;
        
        // 끝까지 다 돌았을 경우 
        if (k == info.length) {
            minA = Math.min(minA, ACnt);
            return;
        }
        
        if (ACnt >= minA) return;
        if (visited[k][ACnt][BCnt]) return;
        
        visited[k][ACnt][BCnt] = true;
            
        int[] cur = info[k];
        
        // A가 훔치는 경우
        dfs(k + 1, ACnt + cur[0], BCnt, info, visited);
        // B가 훔치는 경우 
        dfs(k + 1, ACnt, BCnt + cur[1], info, visited);
        
        // visited[k][ACnt][BCnt] = false;
    }
}