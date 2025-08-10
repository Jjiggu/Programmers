class Solution {
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] info, int n, int m) {
        
        boolean[][][] visited = new boolean[info.length][n][m];
        dfs(0, info, n, m, 0, 0, visited);
        
        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }
    
    private void dfs(int k, int[][] info, int n, int m, int a, int b, boolean[][][] visited) {
        if (a >= n || b >= m) return;
        
        if (k == info.length) {
            if (a < answer) answer = a;
            return;
        }
        
        if (a >= answer) return;
        if (visited[k][a][b]) return;
        visited[k][a][b] = true;
        
        dfs(k + 1, info, n, m, a + info[k][0], b, visited);
        dfs(k + 1, info, n, m, a, b + info[k][1], visited);
    }
}