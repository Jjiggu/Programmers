import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        int maxGems = new HashSet(Arrays.asList(gems)).size();  // 보석 종류 카운팅 
        int left = 0;  // 왼쪽 포인터 
        int minLen = Integer.MAX_VALUE; 
        int minLeft = 0, minRight = 0;
        
        Map<String, Integer> gemList = new HashMap<>();  // 보석 개수 관리를 위한 Map
        
        
        for (int i = 0; i < gems.length; i++) {
            String gemType = gems[i];
            
            gemList.put(gemType, gemList.getOrDefault(gemType, 0) + 1);
            
            while(gemList.get(gems[left]) > 1) {
                gemList.put(gems[left], gemList.get(gems[left]) - 1);
                left++;
            }
            
            if (gemList.size() == maxGems && (i - left) < minLen) { 
                minLen = i - left;
                minLeft = left + 1;
                minRight = i + 1;
            }
        }
        
        return new int[]{minLeft, minRight};
    }
}
