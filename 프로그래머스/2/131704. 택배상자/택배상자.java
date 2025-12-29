import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        int idx = 0;
        
        for (int i = 1; i <= order.length; i++) {
            // System.out.println(stack);
            // 현재 order와 같으면 택배 실어야 됨
            if (i == order[idx]) {
                idx++;
                answer++;
            } else if (!stack.isEmpty() && stack.peek() == order[idx]) {
                while (!stack.isEmpty() && stack.peek() == order[idx]) {
                    answer++;
                    idx++;
                    stack.pop();   
                }
                stack.push(i);
            } else { // 다른 경우 stack에 삽입 
                stack.push(i);   
            }
        }
        
        
        while (!stack.isEmpty()) {
            if (stack.peek() == order[idx]) {
                answer++;
                idx++;
                stack.pop();
            } else {
                break;
            }
        }
        
        return answer;
    }
}