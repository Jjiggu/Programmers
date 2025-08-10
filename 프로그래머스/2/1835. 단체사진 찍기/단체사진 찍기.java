import java.util.*;

class Solution {
    
    private static final char[] MEMBERS = {'A','C','F','J','M','N','R','T'};
    private final Map<Character, Integer> IDX = Map.of(
        'A',0,'C',1,'F',2,'J',3,'M',4,'N',5,'R',6,'T',7
    );
    
    static class Cond {
        char a, b, op; 
        int v;
        
        Cond(char a, char b, char op, int v) { 
            this.a = a; 
            this.b = b; 
            this.op = op; 
            this.v = v; 
        }
    }
    
    private List<Cond> conds;
    private boolean[] used = new boolean[8];
    private char[] perm = new char[8];
    private int[] pos = new int[26];
    private int answer;
        
    public int solution(int n, String[] data) {
        conds = new ArrayList<>(data.length);
        for (String s : data) {
            char a = s.charAt(0); 
            char b = s.charAt(2);
            char op = s.charAt(3);
            int v = s.charAt(4) - '0';
            conds.add(new Cond(a, b, op, v));
        }
        
        Arrays.fill(used, false);
        Arrays.fill(pos, -1);
        answer = 0;
        
        dfs(0);
        return answer;
    }
    
    private void dfs(int depth) {
        if (depth == 8) { 
            answer++; return; 
        }
        
        for (int i = 0; i < 8; i++) {
            if (used[i]) continue;
            char who = MEMBERS[i];

            used[i] = true;
            perm[depth] = who;
            pos[who - 'A'] = depth;

            if (partialOk(who, depth)) {
                dfs(depth + 1);
            }

            pos[who - 'A'] = -1;
            used[i] = false;
        }
    }
    
    private boolean partialOk(char who, int depth) {
        int pWho = pos[who - 'A'];
        
        for (Cond c : conds) {
            if (c.a != who && c.b != who) continue;

            int pa = pos[c.a - 'A'];
            int pb = pos[c.b - 'A'];

            if (pa != -1 && pb != -1) {
                int dist = Math.abs(pa - pb) - 1;
                int v = c.v;
                char op = c.op;

                boolean ok = (op == '=' && dist == v)
                          || (op == '<' && dist <  v)
                          || (op == '>' && dist >  v);
                if (!ok) return false;
            }
        }
        return true;
    }
}