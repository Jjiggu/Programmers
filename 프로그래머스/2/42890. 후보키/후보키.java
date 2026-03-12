import java.util.*;

class Solution {
    
    List<Set<Integer>> candidateKeys = new ArrayList<>();
    
    public int solution(String[][] relation) {
        
        int n = relation[0].length;
        for (int i = 0; i <= n; i++) {
            dfs(0, i, new ArrayList<>(), relation);
        }
        
        return candidateKeys.size();
    }
    
    private void dfs(int k, int target, List<Integer> list, String[][] relation) {
        if (list.size() == target) {
            Set<Integer> curSet = new HashSet<>(list);
            for (Set<Integer> key : candidateKeys) {
                if (curSet.containsAll(key)) return;
            }
            
            if (isUnique(curSet, relation)) candidateKeys.add(curSet);
            return;
        }
        
        for (int i = k; i < relation[0].length; i++) {
            list.add(i);
            dfs(k + 1, target, list, relation);
            list.remove(list.size() - 1);    
        }
    }
    
    private boolean isUnique(Set<Integer> cols, String[][] relation) {
        Set<String> seen = new HashSet<>();
        
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int col : cols) sb.append(row[col]);
            
            if (!seen.add(sb.toString())) return false;
        }
        
        return true;
    }
}