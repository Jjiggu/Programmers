import java.util.*;

class Solution {    
    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
    
    public static int find(int[] parent, int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent, parent[a]);
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        
        for (int i = 0; i < n; i++) parent[i] = i;
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for (int i = 0; i < costs.length; i++) {
            if (find(parent, costs[i][0]) != find(parent, costs[i][1])) {
                union(parent, costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
}