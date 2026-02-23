class Solution {    
    
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] info, int n, int m) {
        boolean[][][] visited = new boolean[info.length][n][m];
        dfs(0, 0, 0, n, m, info, visited);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    private void dfs(int k, int ACnt, int BCnt, int n, int m, int[][] info, boolean[][][] visited) {
        if (ACnt >= n || BCnt >= m) return;
        
        if (k == info.length) {
            answer = Math.min(answer, ACnt);
            return;
        }
        
        if (ACnt >= answer) return;
        if (visited[k][ACnt][BCnt]) return;
        
        visited[k][ACnt][BCnt] = true;
        
        dfs(k + 1, ACnt + info[k][0], BCnt, n, m, info, visited);  // A가 훔치는 경우
        dfs(k + 1, ACnt, BCnt + info[k][1], n, m, info, visited);  // B가 훔치는 경우
    }
}