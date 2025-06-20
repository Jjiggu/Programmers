import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        ArrayList<ArrayList<Integer>> boxGroup = new ArrayList<>();
        
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                ArrayList<Integer> group = new ArrayList<>();
                findBoxGroup(i, cards, visited, group);
                boxGroup.add(group);
            }
        }
        
        return findAnswer(boxGroup);
    }
    
    public void findBoxGroup(int nowIdx, int[] cards, boolean[] visited, ArrayList<Integer> group) {
        if (visited[nowIdx]) return;
        visited[nowIdx] = true;
        group.add(nowIdx + 1); 
        int nextIdx = cards[nowIdx] - 1;
        findBoxGroup(nextIdx, cards, visited, group);
    }
    
    public int findAnswer(ArrayList<ArrayList<Integer>> boxGroup) {
        boxGroup.sort(Comparator.comparingInt((List<Integer> l) -> l.size()).reversed());
        if (boxGroup.size() < 2) return 0;

        return boxGroup.get(0).size() * boxGroup.get(1).size();
    }
}