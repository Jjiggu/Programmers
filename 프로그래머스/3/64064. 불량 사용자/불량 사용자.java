import java.util.*;

class Solution {
    static HashSet<HashSet<String>> answer = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        HashSet<String> set = new HashSet<>();
        
        dfs(0, user_id, banned_id, set);
        
        return answer.size();
    }

    
    public void dfs(int k, String[] user_id, String[] banned_id, HashSet<String> set) {
        if (k == banned_id.length) {
            if (set.size() == banned_id.length) {
                answer.add(new HashSet<>(set)); 
            }
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (set.contains(user_id[i])) continue;
            
            if(isValid(user_id[i], banned_id[k])) {
                set.add(user_id[i]);
                dfs(k + 1, user_id, banned_id, set);
                set.remove(user_id[i]);
            }
        }
    }

        
    public boolean isValid(String user, String bannedUser) {
        
        if (user.length() != bannedUser.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            if (bannedUser.charAt(i) == '*') continue;
            if (user.charAt(i) != bannedUser.charAt(i)) return false;
        }
        
        return true;
    }
}
