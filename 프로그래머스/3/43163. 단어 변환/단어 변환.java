import java.util.*;

class Solution {
    static boolean isUsed[];
    static int cnt = 0;
    
    public int solution(String begin, String target, String[] words) {
        isUsed = new boolean[words.length];
        
        int answer = dfs(0, begin, target, words, 0);
        
        return answer == -1 ? 0 : answer;
    }
    
    public static int dfs(int idx, String nowWord, String target, String[] words, int cntNum) {
        if (nowWord.equals(target)) return cntNum;
        
        int minCount = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (!isUsed[i] && checkEquals(nowWord, words[i])) {
                isUsed[i] = true;
                int result = dfs(idx + 1, words[i], target, words, cntNum + 1);
                if (result != -1) {
                    minCount = Math.min(minCount, result);
                }
                isUsed[i] = false;
            }
        }
        
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
    
    public static boolean checkEquals(String nowWord, String comWord) {
        int cnt = 0;
        
        for (int i = 0; i < nowWord.length(); i++) {
            if (nowWord.charAt(i) != comWord.charAt(i)) cnt++;
        }
        
        return cnt == 1;
    }
}