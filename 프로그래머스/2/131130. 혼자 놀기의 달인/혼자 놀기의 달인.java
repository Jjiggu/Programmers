import java.util.*;

class Solution {
    
    boolean[] visited;
    List<List<Integer>> answer = new ArrayList<>();
    
    public int solution(int[] cards) {
        int n = cards.length;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                play(cards[i] - 1, cards);
            }
        }
        
        Collections.sort(answer, (o1, o2) -> o2.size() - o1.size());
        
        return answer.size() == 1 ? 0 : answer.get(0).size() * answer.get(1).size();
    }
    
    private void play(int idx, int[] cards) {
        
        List<Integer> list = new ArrayList<>();
        int nowIdx = idx;      
        int nextIdx = cards[nowIdx] - 1;
        
        while(true) {
            if (visited[nowIdx]) {
                answer.add(list);
                return;
            }
            
            visited[nowIdx] = true;            
            list.add(nowIdx);
            
            nowIdx = nextIdx;
            nextIdx = cards[nextIdx] - 1;
        }
    }
}