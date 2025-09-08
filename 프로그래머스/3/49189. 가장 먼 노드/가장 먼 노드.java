import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<Integer>[] graph = buildGraph(n, edge);     
        int[] dist = bfs(n, graph, 1);
        return countFartestNodes(dist);
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
    
    private int countFartestNodes(int[] dist) {
        int maxDist = 0;
        
        for (int d : dist) {
            if (d > maxDist) maxDist = d;
        }
        
        int cnt = 0;
        for (int d : dist) {
            if (d == maxDist) cnt++;
        }
        
        return cnt;
    }
    
    private List<Integer>[] buildGraph(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        return graph;
    }
}