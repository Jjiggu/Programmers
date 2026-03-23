import java.util.*;

class Solution {
    public String solution(String p) {
        return splitString(p);
    }

    private String splitString(String s) {
        if (s.isEmpty()) return "";
        
        Deque<Character> q = new ArrayDeque<>();
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        int openCnt = 0;
        int closeCnt = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') openCnt++;
            else if (c == ')') closeCnt++;
            
            q.offer(c);
            
            if (openCnt == closeCnt) {
                while (!q.isEmpty()) {
                    u.append(q.poll());
                }
                v.append(s.substring(i + 1));
                break;
            }
        }
        
        if (isCorrect(u.toString())) return u.toString() + splitString(v.toString());  // 올바른 괄호 문자열이라면 반환 
        else return transferBracket(u, v);  // u가 올바른 문자열이 아니라면 변환 과정 수행 
    }
    
    private String transferBracket(StringBuilder u, StringBuilder v) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(splitString(v.toString()));
        sb.append(")");
        u.deleteCharAt(0);
        u.deleteCharAt(u.length() - 1);
        sb.append(reverseBracket(u.toString()));

        return sb.toString();
    }
    
    private String reverseBracket(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '(') sb.append(')');
            else if (c == ')') sb.append('(');
        }
        
        return sb.toString();
    }
    
    // 균형잡힌 문자열인지 확인하는 방법 
    // 처음부터 "(", ")" 개수 세어보기 
    private boolean isBalance(String s) {
        int openCnt = 0;
        int closeCnt = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') openCnt++;
            else if (c == ')') closeCnt++;
        }
        
        return openCnt == closeCnt;
    }
    
    // 올바른 괄호 문자열인지 판별하는 방법 
    // "(" 면 stack에 넣고 ")" 만났을 때 pop
    // ")" 나왔는데 stack 비어있거나 끝까지 돌았는데 stack 남아있으면 false
    private boolean isCorrect(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}