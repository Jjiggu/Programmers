import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int removeCnt = 0;

        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peekLast() < c && removeCnt < k) {
                stack.pollLast();
                removeCnt++;
            }
            stack.addLast(c);
        }

        while (removeCnt < k) {
            stack.pollLast();
            removeCnt++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        return sb.toString();
    }
}
