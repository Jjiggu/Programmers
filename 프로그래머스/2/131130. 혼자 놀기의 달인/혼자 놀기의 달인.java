import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> groupSizes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            int cur = i;
            int cnt = 0;
            
            while (!visited[cur]) {
                visited[cur] = true;
                cnt++;
                cur = cards[cur] - 1;   // 다음 상자 번호 (1-based → 0-based)
            }
            
            if (cnt > 0) groupSizes.add(cnt);
        }
        
        // 사이클(그룹)이 2개 미만이면 점수는 0
        if (groupSizes.size() < 2) return 0;
        
        // 내림차순 정렬
        groupSizes.sort(Collections.reverseOrder());
        
        // 가장 큰 두 그룹의 크기 곱
        return groupSizes.get(0) * groupSizes.get(1);
    }
}