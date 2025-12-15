class Solution {
    
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        dfs(0, k, dungeons, new boolean[dungeons.length], 0);    
        
        return answer;
    }
    
    private void dfs(int idx, int fatigue, int[][] dungeons, boolean[] visited, int cnt) {    
        answer = Math.max(answer, cnt);
        
        for (int i = 0; i < dungeons.length; i++) {
            int minFatigue = dungeons[i][0];
            int waste = dungeons[i][1];
            
            if (visited[i]) continue;
            if (fatigue >= minFatigue && fatigue >= waste) {
                visited[i] = true;
                dfs(i + 1, fatigue - waste, dungeons, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }
}