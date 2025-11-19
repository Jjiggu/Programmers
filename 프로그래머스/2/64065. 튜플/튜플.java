import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
         
        String[] sub = s.split("\\},\\{");        
        Arrays.sort(sub, (o1, o2) -> o1.length() - o2.length());
        
        List<Integer> answer = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        
        for (String tuple : sub) {
            String[] nums = tuple.split(",");
            int[] arr = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                int num = Integer.parseInt(nums[i]);
                if (!seen.contains(num)) answer.add(num);
                seen.add(num);
            } 
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}