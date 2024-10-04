import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        Arrays.sort(arr);
        
        list.remove(list.indexOf(arr[0]));
        
        if (list.size() <= 0) return new int[]{-1};
        
        return list.stream().mapToInt(i->i).toArray();
        
    }
}