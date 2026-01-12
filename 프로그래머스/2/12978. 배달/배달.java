import java.util.*;

class Solution {    
    static class Node {
        int v;
        int cost;
        
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    static List<Node>[] graph;
    
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        
        for (int[] r : road) {
            int u = r[0];
            int v = r[1];
            int cost = r[2];
            graph[u].add(new Node(v, cost));
            graph[v].add(new Node(u, cost));
        }
        
        int[] dist = dijkstra(N, 1);
        int answer = 0;
        
        for (int d : dist) if (d <= K) answer++;
        
        return answer;
    }
    
    private int[] dijkstra(int N, int start) {
        int[] dist = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dist[cur.v] < cur.cost) continue;
            
            for (Node next : graph[cur.v]) {
                int curCost = cur.cost + next.cost;
                
                if (dist[next.v] > curCost) {
                    dist[next.v] = curCost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        
        return dist;
    }
}