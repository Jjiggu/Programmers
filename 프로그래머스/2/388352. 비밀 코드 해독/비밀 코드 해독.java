import java.util.*;

class Solution {
    List<List<Integer>> comb = new ArrayList<>();
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        dfs(0, n, new ArrayList<>());
        
        for (List<Integer> com : comb) {
            answer += check(com, q, ans);
        }
        
        return answer;
    }
    
    private int check(List<Integer> com, int[][] q, int[] ans) {
        
        for (int i = 0; i < q.length; i++) {
            int[] compareQ = q[i];
            int cnt = 0;
            
            for (int j = 0; j < compareQ.length; j++) {
                if (com.contains(compareQ[j])) cnt++;
                if (cnt > ans[i]) return 0;
            }
            if (cnt != ans[i]) return 0;
        }
        
        return 1;
    }
    
    private void dfs(int k, int n, List<Integer> arr) {
        
        if (arr.size() == 5) {
            comb.add(new ArrayList<>(arr));
            return;
        }
        
        for (int i = k; i < n; i++) {
            arr.add(i + 1);
            dfs(i + 1, n, arr);
            arr.remove(arr.size() - 1);
        }
    }
}