import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2, s.length() - 2);
        String[] parts = s.split("\\},\\{");
        
        List<List<Integer>> answer = new ArrayList<>();
        for (String part : parts) {
            List<Integer> arr = new ArrayList<>();
            for (String num : part.split(",")) {
                arr.add(Integer.parseInt(num));
            }
            answer.add(arr);
        }
        
        Collections.sort(answer, (o1, o2) -> o1.size() - o2.size());
        
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for (List<Integer> arr : answer) {
            for (int num : arr) {
                if (!set.contains(num)) {
                    set.add(num);
                    result.add(num);
                }
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}