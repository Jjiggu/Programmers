import java.util.*;

class Solution {
    
    static final Set<HashSet<String>> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        boolean[] isUsed = new boolean[user_id.length];
        dfs(0, isUsed, user_id, banned_id, set, new ArrayList<>());
        return set.size();
    }
    
    private void dfs(int k, boolean[] isUsed, String[] user_id, String[] banned_id, Set<HashSet<String>> set, ArrayList<String> list) {
        if (k == banned_id.length) {
            set.add(new HashSet<>(list));
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (!isUsed[i] && isSame(user_id[i], banned_id[k])) {
                isUsed[i] = true;
                list.add(user_id[i]);
                dfs(k + 1, isUsed, user_id, banned_id, set, list);
                list.remove(list.size() - 1);
                isUsed[i] = false;
            }
        }        
    }
    
    
    
    private boolean isSame(String user, String banned) {
        
        if (user.length() != banned.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (banned.charAt(i) != user.charAt(i)) return false;
        }
        
        return true;
    }
}
