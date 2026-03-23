import java.util.*;

class Solution {
    
    long answer = 0;
    
    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        parse(expression, numbers, operators);
        
        char[] ops = {'*', '+', '-'};
        boolean[] visited = new boolean[3];
        char[] selected = new char[3];
        
        permute(0, ops, visited, selected, numbers, operators);
        
        return answer;
    }
    
    private void permute(int k, char[] ops, boolean[] visited, char[] selected, List<Long> numbers, List<Character> operators) {
        if (k == 3) {
            long result = calc(numbers, operators, selected);
            answer = Math.max(answer, Math.abs(result));
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            selected[k] = ops[i];
            permute(k + 1, ops, visited, selected, numbers, operators);
            visited[i] = false;
        }
    }
    
    private long calc(List<Long> numbers, List<Character> operators, char[] priority) {
        List<Long> nums = new ArrayList<>(numbers);
        List<Character> ops = new ArrayList<>(operators);
        
        for (char target : priority) {
            for (int i = 0; i < ops.size(); ) {
                if (ops.get(i) == target) {
                    long n1 = nums.get(i);
                    long n2 = nums.get(i + 1);
                    long result = operate(n1, n2, target);
                    
                    nums.set(i, result);
                    nums.remove(i + 1);
                    ops.remove(i);
                } else {
                    i++;
                }
            }
        }
        
        return nums.get(0);
    }
    
    private long operate(long n1, long n2, char op) {
        if (op == '+') return n1 + n2;
        else if (op == '-') return n1 - n2;
        return n1 * n2;
    }
    
    private void parse(String expression, List<Long> numbers, List<Character> operators) {
       StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                numbers.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operators.add(c);
            }
        }
        numbers.add(Long.parseLong(sb.toString()));
    }
}