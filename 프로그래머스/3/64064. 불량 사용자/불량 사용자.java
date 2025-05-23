import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        Set<Set<String>> answers = new HashSet<>();
        
        dfs(0, user_id, banned_id, new HashSet<>(), answers);
        
        return answers.size();
    }

    
    public void dfs(int depth, String[] user_id, String[] banned_id, Set<String> currentSet, Set<Set<String>> answers) {
        if (depth == banned_id.length) {
            if (currentSet.size() == banned_id.length) {
                answers.add(new HashSet<>(currentSet)); 
            }
            return;
        }
        
        for (String user : user_id) {
            if (currentSet.contains(user)) continue;
            
            if(isMatch(user, banned_id[depth])) {
                currentSet.add(user);
                dfs(depth + 1, user_id, banned_id, currentSet, answers);
                currentSet.remove(user);
            }
        }
    }

        
    public boolean isMatch(String user, String banned) {
        
        if (user.length() != banned.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }
        
        return true;
    }
}
