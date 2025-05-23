import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int gemTypes = new HashSet<>(Arrays.asList(gems)).size();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int answerLeft = 0, answerRight = 0;
        
        Map<String, Integer> gemList = new HashMap<>();
        
        
        while (true) {
            if (gemList.size() < gemTypes) {
                if (right == gems.length) break;
                
                gemList.put(gems[right], gemList.getOrDefault(gems[right], 0) + 1);
                right++;
            } else {
                if (right - left < minLen) {
                    minLen = right - left;
                    answerLeft = left;
                    answerRight = right;
                }
                
                gemList.put(gems[left], gemList.get(gems[left]) - 1);
                
                if (gemList.get(gems[left]) == 0) {
                    gemList.remove(gems[left]);
                }
                left++;
            }
        }
        
        return new int[] {answerLeft + 1, answerRight};
    }
}
