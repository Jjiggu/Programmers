import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int gemTypes = new HashSet<>(Arrays.asList(gems)).size();
        int left = 0;
        int length = Integer.MAX_VALUE;
        int answerLeft = 0, answerRight = 0;
        Map<String, Integer> gemList = new HashMap<>();
        
        for (int i = 0; i < gems.length; i++) {
            gemList.put(gems[i], gemList.getOrDefault(gems[i], 0) + 1);
            
            while (gemList.get(gems[left]) > 1) {
                gemList.put(gems[left], gemList.get(gems[left]) - 1);
                left++;
            }
            
            if (gemList.size() == gemTypes && (i - left) < length) {
                length = i - left;
                answerLeft = left + 1;
                answerRight = i + 1;
            }
        }
        
        return new int[]{answerLeft, answerRight};  
    }
}
