import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int size = words.length;
        String startWord = words[0];
        
        int[] result = new int[2];
        ArrayList<String> isUsed = new ArrayList<>();
        
        isUsed.add(words[0]);
        
        for (int i = 1; i < size; i++) {
            isUsed.add(words[i]);
            
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) || checkMulti(words[i], isUsed)) {
                result[0] = i % n + 1;
                result[1] = i / n + 1;
                
                
                System.out.println(i);
                System.out.println(isUsed);
                    
                return result;
            }    
        }
        
        return result;
    }
    
    
    private boolean checkMulti(String word, ArrayList<String> wordList) {
        for (int i = 0; i < wordList.size() - 1; i++) {
            if (word.equals(wordList.get(i))) {
                return true;
            }
        }
        
        return false;
    }
}