import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> usedWords = new HashSet<>();
        
        usedWords.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            String previousWord = words[i - 1];
            
            boolean isValidChain = currentWord.charAt(0) == previousWord.charAt(previousWord.length() - 1);
            boolean isDuplicate = usedWords.contains(currentWord);
            
            if (!isValidChain || isDuplicate) {
                    
                return new int[] {i % n + 1, i / n + 1};
            }    
            
            usedWords.add(currentWord);
        }
        
        return new int[] {0, 0};
    }
}