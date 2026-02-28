import java.util.*;

class Solution {
    
    private static final char[] MEMBERS = {'A','C','F','J','M','N','R','T'};
    
    int answer;
    int memberLen = MEMBERS.length;
    
    public int solution(int n, String[] data) {
        answer = 0;

        dfs(0, new ArrayList<>(), new boolean[8], data);
        
        return answer;
    }
    
    private void dfs(int k, List<Character> list, boolean[] used, String[] data) {
        if (k == memberLen) {
            answer++;
            return;
        }
        
        for (int i = 0; i < memberLen; i++) {
            if (!used[i]) {
                char member = MEMBERS[i];
                used[i] = true;
                list.add(member);
                if (isCorrect(list, data)) {
                    dfs(k + 1, list, used, data);   
                }
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
    
    private boolean isCorrect(List<Character> list, String[] data) {
        
        for (String d : data) {
            char mem1 = d.charAt(0);
            char mem2 = d.charAt(2);
            char op = d.charAt(3);
            int v = d.charAt(4) - '0';  
            
            int mem1Idx = list.indexOf(mem1);
            int mem2Idx = list.indexOf(mem2);
            int dist = Math.abs(mem1Idx - mem2Idx) - 1;
            
            if (mem1Idx == -1 || mem2Idx == -1) continue;
            
            boolean ok = (op == '=' && dist == v) 
                || (op == '<' && dist <  v)
                || (op == '>' && dist >  v);
            
            if (!ok) return false;
        } 
        
        return true;
    }
}