import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<Integer>[] graph = buildGraph(n, roads);
        
        int[] dist = bfs(n, graph, destination);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
    
    private int[] bfs(int n, List<Integer>[] graph, int start) {
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        dist[start] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        return dist;
    }
    
    private List<Integer>[] buildGraph(int n, int[][] roads) {
        
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        return graph;
    }
}