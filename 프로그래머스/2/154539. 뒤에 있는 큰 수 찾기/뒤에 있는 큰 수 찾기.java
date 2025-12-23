import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        // 맨 뒤부터 순회
        for (int i = n - 1; i >= 0; i--) {
            int cur = numbers[i];
            
            while (!stack.isEmpty() && stack.peek() <= cur) stack.pop();
            
            if (!stack.isEmpty()) answer[i] = stack.peek();
            // else answer[i] = -1;
            
            stack.push(cur);
        }
        
        return answer;
    }
}