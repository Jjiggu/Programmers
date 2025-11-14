import java.util.*;

class Solution {
    
    List<Set<Integer>> candidateKeys = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int maxCol = relation[0].length;
        
        for (int i = 0; i <= maxCol; i++) {
            dfs(0, i, maxCol, new ArrayList<>(), relation);
        }
        
        return candidateKeys.size();
    }
    
    private void dfs(int start, int target, int maxCol, ArrayList<Integer> arr, String[][] relation) {
        if (arr.size() == target) {
            Set<Integer> curSet = new HashSet<>(arr);
            for (Set<Integer> key : candidateKeys) {
                if (curSet.containsAll(key)) return;
            }
            
            if (isUnipue(curSet, relation)) candidateKeys.add(curSet);
            return;
        }
        
        for (int i = start; i < maxCol; i++) {
            arr.add(i);
            dfs(i + 1, target, maxCol, arr, relation);
            arr.remove(arr.size() - 1);
        }
    }
    
    private boolean isUnipue(Set<Integer> cols, String[][] relation) {
        Set<String> seen = new HashSet<>();
        
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            
            for (int col : cols) sb.append(row[col]).append("|");
            
            if (!seen.add(sb.toString())) return false;
        }
        
        return true;
    }
}