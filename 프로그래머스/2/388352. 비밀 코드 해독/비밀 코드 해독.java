import java.util.*;

class Solution {
    List<int[]> comb = new ArrayList<>();
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        dfs(0, n, new ArrayList<>());
        
        for (int[] com : comb) {
            answer += check(com, q, ans);
        }
        
        return answer;
    }
    
    private int check(int[] com, int[][] q, int[] ans) {
        HashSet<Integer> s = new HashSet<>();
        for (int num : com) s.add(num);
        
        for (int i = 0; i < q.length; i++) {
            int[] inputQ = q[i];
            int cnt = 0;
            
            for (int j = 0; j < inputQ.length; j++) {
                if (s.contains(inputQ[j])) cnt++;
                if (cnt > ans[i]) return 0;
            }    
            if (cnt != ans[i]) return 0;
        }
        
        return 1;
    }
    
    private void dfs(int k, int n, List<Integer> arr) {
        
        if (arr.size() == 5) {
            comb.add(arr.stream().mapToInt(Integer::intValue).toArray());
            return;
        }
        
        for (int i = k; i < n; i++) {
            arr.add(i + 1);
            dfs(i + 1, n, arr);
            arr.remove(arr.size() - 1);
        }
    }
}