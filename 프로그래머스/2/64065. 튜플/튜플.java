import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] sub = preProcess(s);
        
        List<Integer> answer = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        
        for (String tuple : sub) {
            String[] nums = tuple.split(",");
            
            for (String n : nums) {
                int num = Integer.parseInt(n);
                if (!seen.contains(num)) answer.add(num);
                seen.add(num);
            }      
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private String[] preProcess(String s) {
        s = s.substring(2, s.length() - 2);
        String[] sub = s.split("\\},\\{");
        Arrays.sort(sub, (o1, o2) -> o1.length() - o2.length());
        
        return sub;
    }
}