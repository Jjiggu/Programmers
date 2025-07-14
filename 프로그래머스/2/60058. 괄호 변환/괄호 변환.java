import java.util.*;

class Solution {
    public String solution(String p) {
        return splitString(p);
    }
    
    public String splitString(String w) {
        if (w.isEmpty()) {
            return "";
        }
        
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        Deque<Character> q = new ArrayDeque<>();
        
        int leftCnt = 0, rightCnt = 0;
        int idx = 0;
        
        // u와 v로 분리
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') leftCnt++;  // 열린 괄호
            else rightCnt++;  // 닫힌 괄호
            
            q.offer(w.charAt(i));
            
            // 왼쪽 괄호와 오른쪽 괄호의 개수가 같아지면, u를 완성
            if (leftCnt == rightCnt) {
                while (!q.isEmpty()) {
                    u.append(q.poll());
                }
                v.append(w.substring(i + 1));
                break;
            }
        }
        
        // u가 올바른 괄호 문자열이면, v에 대해 재귀 호출
        if (isCorrect(u.toString())) {
            return u.toString() + splitString(v.toString());
        } else {
            // u가 잘못된 괄호 문자열인 경우
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(splitString(v.toString()));
            sb.append(')');
            // u의 첫 번째와 마지막 괄호를 제거하고, 괄호를 뒤집어서 이어 붙임
            u.deleteCharAt(0);  // 첫 번째 '(' 삭제
            u.deleteCharAt(u.length() - 1);  // 마지막 ')' 삭제
            sb.append(reverseU(u.toString()));
            
            return sb.toString();
        }
    }
    
    // 괄호 문자열이 올바른지 확인
    public boolean isCorrect(String u) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : u.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
    
    // 괄호 문자열을 뒤집어서 반환
    public String reverseU(String u) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }
        
        return sb.toString();
    }
}
