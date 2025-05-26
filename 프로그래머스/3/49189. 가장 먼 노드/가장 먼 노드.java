import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = buildGraph(n, edge);
        int[] dist = bfs(1, n, graph);
        
        return countMax(dist);
    }
    
    
    private List<List<Integer>> buildGraph(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        return graph;
    }
    
    
    private int[] bfs(int start, int n, List<List<Integer>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
        
        return dist;
    }
    
    
    private int countMax(int[] dist) {
        int max = 0;
        
        for (int d : dist) {
            if (d > max) max = d;
        }
        
        int cnt = 0;
        for (int d : dist) {
            if (d == max) cnt++;
        }
        
        return cnt;
    }
}