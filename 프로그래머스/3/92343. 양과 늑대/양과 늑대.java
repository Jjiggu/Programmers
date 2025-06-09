import java.util.*;

class Solution {
    int maxSheep = 0;
    
    public int solution(int[] info, int[][] edges) {
        List<Integer>[] children = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) children[i] = new ArrayList<>();
        for (int[] edge : edges) children[edge[0]].add(edge[1]);
        
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        dfs(0, 0, 0, nextNodes, info, children);
        
        return maxSheep;
    }
    
    public void dfs(int curr, int sheep, int wolf, List<Integer> nextNodes, int[] info, List<Integer>[] children) {
        if (info[curr] == 0) sheep++;
        else wolf++;
        
        if (wolf >= sheep) return;
        
        maxSheep = Math.max(maxSheep, sheep);
        
        List<Integer> canVisit = new ArrayList<>(nextNodes);
        canVisit.remove((Integer)curr);
        
        for (int next : children[curr]) {
            canVisit.add(next);
        }
        
        for (int next : canVisit) {
            dfs(next, sheep, wolf, canVisit, info, children);
        }
    }
}
