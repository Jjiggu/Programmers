import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = buildGraph(n, roads);
        int[] answer = new int[sources.length];
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = bfs(sources[i], n, graph, destination);
        }
        
        return answer;
    }    
    
    
    private List<List<Integer>> buildGraph(int n, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : roads) {
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        
        return graph;
    }
    
    
    private int bfs(int start, int n, List<List<Integer>> graph, int destination) {
        int[] dist = new int[n + 1];
        Deque<Integer> q = new ArrayDeque<>();
        
        Arrays.fill(dist, -1);
        q.add(start);
        dist[start] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            if (cur == destination) return dist[cur];
            
            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
        
        return -1;
    }
}