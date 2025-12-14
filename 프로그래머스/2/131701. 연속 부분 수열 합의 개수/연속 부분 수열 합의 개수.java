import java.util.*;

class Solution {
    
    Set<Integer> answer = new HashSet<>();
    
    public int solution(int[] elements) {
        int n = elements.length;
        int[] arr = copyArray(elements);
        
        calcSum(arr, n);
        
        return answer.size();
    }
    
    private void calcSum(int[] arr, int n) {    
        for (int len = 1; len <= n; len++) {
            int sum = 0;
            
            for (int i = 0; i < len; i++) sum += arr[i];
            answer.add(sum);
            
            for (int start = 1; start < n; start++) {
                sum -= arr[start - 1];
                sum += arr[start + len - 1];
                answer.add(sum);
            }
        }
    }
    
    private int[] copyArray(int[] elements) {
        int n = elements.length;
        int[] newArr = new int[n * 2];
        
        for (int i = 0; i < n; i++) {
            newArr[i] = elements[i];
            newArr[i + n] = elements[i];
        }
        
        return newArr;
    }
}