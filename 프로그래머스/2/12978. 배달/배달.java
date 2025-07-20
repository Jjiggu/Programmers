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
    
    static ArrayList<Node>[] graph;
    
    public int solution(int N, int[][] road, int K) {
        
        graph = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        
        for (int[] r : road) {
            graph[r[0]].add(new Node(r[1], r[2]));
            graph[r[1]].add(new Node(r[0], r[2]));
        }
        
        int[] dist = dijkstra(N, 1);
        
        int answer = 0;
        for (int d : dist) {
            if (d <= K) answer++;
        }
        
        return answer;
    }
    
    private int[] dijkstra(int N, int start) {
        
        int[] dist = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (dist[now.v] < now.cost) continue;
            
            for (Node next : graph[now.v]) {
                if (dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        
        return dist;
    }
}