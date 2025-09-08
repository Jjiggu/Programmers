import java.util.*;

class Solution {    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        int answer = 0;
        int cnt = 0;
        
        for (int[] edge : costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            
            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                answer += cost;
                cnt++;
                if (cnt == n - 1) break;
            }
        }
        
        return answer;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }
    
    private void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
}