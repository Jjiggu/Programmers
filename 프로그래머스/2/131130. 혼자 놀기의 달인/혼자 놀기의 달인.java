import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            int cur = i;
            int cnt = 0;
            
            while (!visited[cur]) {
                visited[cur] = true;
                cnt++;
                cur = cards[cur] - 1;
            }
            
            if (cnt > 0) answer.add(cnt);
        }
        
        if (answer.size() < 2) return 0;
        answer.sort(Collections.reverseOrder());
        
        return answer.get(0) * answer.get(1);
    }
}