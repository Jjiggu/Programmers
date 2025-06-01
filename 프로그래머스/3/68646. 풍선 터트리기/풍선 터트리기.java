import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 2;
        int n = a.length;
        int[] leftMin = buildAccumulatedMin(a, "left");
        int[] rightMin = buildAccumulatedMin(a, "right");
        
        
        for (int i = 1; i < a.length - 1; i++) {
            int nowNum = a[i];
            
            if (a[i] > leftMin[i - 1] && a[i] > rightMin[i + 1]) continue;
            
            answer++;
        }
        
        return answer;
    }
    
    
    private int[] buildAccumulatedMin(int[] arr, String direction) {
        int n = arr.length;
        int[] minArr = new int[n];
        
        if ("left".equals(direction)) {
            minArr[0] = arr[0];
            for (int i = 1; i < n; i++) {
                minArr[i] = Math.min(minArr[i - 1], arr[i]);
            }
        } else if ("right".equals(direction)) {
            minArr[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                minArr[i] = Math.min(minArr[i + 1], arr[i]);
            }
        }
        
        return minArr;
    }
}
