import java.util.*;

class Solution {
    
    Set<List<String>> answer = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        dfs(0, new boolean[user_id.length], new ArrayList<>(), user_id, banned_id);
        
        return answer.size();
    }
    
    private void dfs(int k, boolean[] isUsed, List<String> list, String[] user_id, String[] banned_id) {
        if (k == banned_id.length) {
            Collections.sort(list);
            answer.add(list);
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (!isUsed[i] && isSame(user_id[i], banned_id[k])) {
                isUsed[i] = true;
                list.add(user_id[i]);
                dfs(k + 1, isUsed, list, user_id, banned_id);
                isUsed[i] = false;
                list.remove(user_id[i]);
            }
        }
    }
    
    private boolean isSame(String user, String banned) {
        
        if (user.length() != banned.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }
        
        return true;
    }
}
