import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    
    public int[] solution(int[][] edges) {
        int maxNode = findMaxNode(edges);
        
        int[] inDegree = new int[maxNode + 1];
        int[] outDegree = new int[maxNode + 1];
        
        buildGraph(maxNode, edges, inDegree, outDegree);
        
        int genNode = findGenNode(maxNode, inDegree, outDegree);
        int stick = 0;
        int eight = 0;
        
        for (int i = 1; i <= maxNode; i++) {
            if (i == genNode) continue;
            
            if (outDegree[i] == 0 && inDegree[i] > 0) stick++;
            if (outDegree[i] == 2 && inDegree[i] >= 2) eight++;
        }
        
        int donut = outDegree[genNode] - stick - eight;
        
        return new int[]{genNode, donut, stick, eight};
    }
    
    private int findGenNode(int maxNode, int[] inDegree, int[] outDegree) {
        for (int i = 1; i <= maxNode; i++) {
            if (inDegree[i] == 0 && outDegree[i] >= 2) return i;
        }
        
        return -1;
    }
    
    private int findMaxNode(int[][] edges) {
        int maxNode = 0;
        
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }
        
        return maxNode;
    }
    
    private void buildGraph(int maxNode, int[][] edges, int[] inDegree, int[] outDegree) {
        
        graph = new ArrayList[maxNode + 1];
        
        for (int i = 1; i <= maxNode; i++) graph[i] = new ArrayList<>();
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            graph[u].add(v);
            inDegree[v]++;
            outDegree[u]++;
        }
    }
}