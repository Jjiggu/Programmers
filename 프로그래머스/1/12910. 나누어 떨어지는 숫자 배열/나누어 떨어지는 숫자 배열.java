import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> num_list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                num_list.add(arr[i]);
            }
        }
        
        if (num_list.isEmpty()) {
            return new int[] {-1};
        }
           
        int[] answer = num_list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
            
        return answer;
    }
}