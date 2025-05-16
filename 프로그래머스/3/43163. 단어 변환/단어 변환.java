import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        boolean[] isUsed = new boolean[words.length];
        Arrays.sort(words);
        
        return bfs(begin, target, words, isUsed, 0);   
    }
    
    
    public int bfs(String begin, String target, String[] words, boolean[] isUsed, int cnt) {
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        
        while(!q.isEmpty()) {
            String nowWord = q.poll();
            
            if (nowWord.equals(target)) {
                return cnt;
            }
            
            
            for (int i = 0; i < words.length; i++) {
                if (!isUsed[i] && isMatched(nowWord, words[i])) {
                    System.out.println(words[i]);
                    q.offer(words[i]);
                    isUsed[i] = true;
                    cnt++;
                    break;
                }
            }
        }
        
        return 0;
    }
    
    
    public boolean isMatched(String word, String target) {
        int cnt = 0;
        
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) cnt++;
        }
        
        return cnt == 1;
    }
}