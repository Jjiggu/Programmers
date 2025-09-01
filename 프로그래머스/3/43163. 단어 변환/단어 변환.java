import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {

        boolean[] isUse = new boolean[words.length];
        
        return bfs(begin, target, words, isUse);
    }
    
    private int bfs(String begin, String target, String[] words, boolean[] isUse) {
        Deque<Word> q = new ArrayDeque<>();
        q.offer(new Word(begin, 0));
        
        while (!q.isEmpty()) {
            Word cur = q.poll();
            
            if (cur.word.equals(target)) {
                return cur.cnt;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!isUse[i] && isMatched(cur.word, words[i])) {
                    isUse[i] = true;
                    q.offer(new Word(words[i], cur.cnt + 1));
                }
            }
        }
        
        return 0;
    }
    
    public boolean isMatched(String from, String to) {
        int cnt = 0;
        
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) cnt++;
        }
        
        return cnt == 1;
    }
    
    class Word {
        String word;
        int cnt;
        
        Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}