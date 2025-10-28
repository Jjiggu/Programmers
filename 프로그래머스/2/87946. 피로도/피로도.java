class Solution {
    
    int minFatigue = Integer.MAX_VALUE;
    int minCnt = 0;
    
    public int solution(int k, int[][] dungeons) {
        dfs(k, new boolean[dungeons.length], dungeons, 0);
        
        return minCnt;
    }
    
    private void dfs(int k, boolean[] visited, int[][] dungeons, int cnt) {
        minCnt = Math.max(minCnt, cnt);
            
        for (int i = 0; i < dungeons.length; i++) {
            int need = dungeons[i][0];
            int consume = dungeons[i][1];
            
            if (visited[i]) continue;
            
            if (k >= need) {
                visited[i] = true;
                dfs(k - consume, visited, dungeons, cnt + 1);
                visited[i] = false;
            }
        }
    }
}