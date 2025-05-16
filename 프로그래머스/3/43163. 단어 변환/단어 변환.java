import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        boolean[] isUsed = new boolean[words.length];
        
        int result = dfs(0, begin, target, isUsed, words);
        
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    
    
    public int dfs(int k, String nowWord, String target, boolean[] isUsed, String[] words) {
        
        if (nowWord.equals(target)) {
            return k;
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (!isUsed[i] && isMatched(nowWord, words[i])) {
                isUsed[i] = true;
                int val = dfs(k + 1, words[i], target, isUsed, words);
                
                if (val < min) {
                    min = val;
                }
                
                isUsed[i] = false;
            }
        }
        
        return min;
    }
    
    
    public boolean isMatched(String word, String target) {
        int cnt = 0;
        
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) cnt++;
        }
        
        return cnt == 1;
    }
}