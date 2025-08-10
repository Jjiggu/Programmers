import java.util.*;

class Solution {
    
    char[] opsList = {'+', '-', '*'};
    long answer = 0;
    
    public long solution(String expression) {
        List<Long> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        String num = "";
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                nums.add(Long.parseLong(num));
                num = "";
                ops.add(c);
            } else num += c;
        }
        nums.add(Long.parseLong(num));

        perm(0, opsList.clone(), nums, ops);
        return answer;
    }
    
    
    void perm(int depth, char[] arr, List<Long> nums, List<Character> ops) {
        if (depth == arr.length) {
            List<Long> n = new ArrayList<>(nums);
            List<Character> o = new ArrayList<>(ops);
            for (char op : arr) {
                for (int i = 0; i < o.size();) {
                    if (o.get(i) == op) {
                        long a = n.remove(i), b = n.remove(i);
                        n.add(i, op == '+'? a+b : op == '-'? a - b : a * b);
                        o.remove(i);
                    } else i++;
                }
            }
            answer = Math.max(answer, Math.abs(n.get(0)));
            return;
        }
        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            perm(depth + 1, arr, nums, ops);
            swap(arr, depth, i);
        }
    }
    
    
    void swap(char[] a, int i, int j) { char t = a[i]; a[i] = a[j]; a[j] = t; }
}
