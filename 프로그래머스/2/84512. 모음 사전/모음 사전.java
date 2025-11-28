import java.util.*;

class Solution {
    
    Character[] vowel = {'A', 'E', 'I', 'O', 'U'};
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        
        dfs(0, new StringBuilder());
        Collections.sort(list);
        
        return list.indexOf(word) + 1;
    }
    
    private void dfs(int k, StringBuilder sb) {
        
        if (sb.length() > 0) list.add(sb.toString());
        
        if (sb.length() == vowel.length) return;
        
        for (int i = 0; i < vowel.length; i++) {
            sb.append(vowel[i]);
            dfs(k + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}