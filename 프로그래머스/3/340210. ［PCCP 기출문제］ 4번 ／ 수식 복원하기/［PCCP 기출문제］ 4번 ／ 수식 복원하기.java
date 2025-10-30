import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        String[][] expressionsArr = parseExpression(expressions);
        
        // 가능한 최소 진법 수 (자릿수 최댓값 + 1, 최소 = 2)
        int minBase = Math.max(2, maxDigitAmongAll(expressionsArr) + 1);
        
        // 완성식, X 포함된 식 분리 
        List<String[]> full = new ArrayList<>();
        List<String[]> withX = new ArrayList<>();
        for (String[] ex : expressionsArr) {
            if (ex[3].equals("X")) withX.add(ex);
            else full.add(ex);
        }
        
        // 가능한 진법 후보 초기화
        Set<Integer> validNum = new HashSet<>();
        for (int i = minBase; i <= 9; i++) validNum.add(i);
        
        // 수식별 진법 탐색
        for (String[] ex : full) {
            Set<Integer> pos = new HashSet<>();
            
            for (int base = minBase; base <= 9; base++) {
                if (!validInBase(ex[0], base) || !validInBase(ex[2], base) || !validInBase(ex[3], base)) continue;  // 진법 가능한 지 확인
                Integer x = parseBase(ex[0], base);  // 해당 진법으로 변환
                Integer y = parseBase(ex[2], base);
                Integer r = parseBase(ex[3], base);
                
                Integer calc = eval(x, y, ex[1]);  // 계산
                if (calc.equals(r)) pos.add(base);  // 계산 결과 같은 경우 해당 진법 저장
            }
            validNum.retainAll(pos);  // 진법 후보와 교집합
        }
        
        List<String> answer = new ArrayList<>();
        for (String[] ex : withX) {  
            String a = ex[0];
            String op = ex[1];
            String b = ex[2];
            Set<String> reprs = new HashSet<>();
            
            for (int base : validNum) {  // 진법 후보 하나씩 확인
                if (!validInBase(a, base) || !validInBase(b, base)) continue;
                Integer x = parseBase(a, base);
                Integer y = parseBase(b, base);
                Integer val = eval(x, y, op);
                reprs.add(toBase(val, base));  // 계산 결과 저장
            }
            
            String fill = (reprs.size() == 1) ? reprs.iterator().next() : "?";  // 1개 이상인 경우 ?로 대체
            
            answer.add(a + " " + op + " " + b + " = " + fill);
        }
        
        return answer.toArray(new String[0]);
    }
    
    private int maxDigitAmongAll(String[][] arr) {
        int max = 0;
        for (String[] ex : arr) {
            max = Math.max(max, maxDigit(ex[0]));
            max = Math.max(max, maxDigit(ex[2]));
            if (!ex[3].equals("X")) max = Math.max(max, maxDigit(ex[3]));
        }
        return max;
    }
    
    private int maxDigit(String s) {
        if ("X".equals(s)) return -1; 
        int m = -1;
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') continue;
            m = Math.max(m, c - '0');
        }
        return m;
    }
        
    private boolean validInBase(String num, int base) {
        if (num.equals("X")) return true;
        for (char c : num.toCharArray()) {
            int d = c - '0';
            if (d >= base) return false;
        }
        return true;
    }
    
    private Integer parseBase(String s, int base) {
        try {
            return Integer.parseInt(s, base);
        } catch (Exception e) {
            return null;
        }
    }
    
    private Integer eval(int x, int y, String op) {
        if (op.equals("+")) return x + y;
        if (op.equals("-")) return x - y;
        return null;
    }
    
    private String toBase(int val, int base) {
        if (val == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (val > 0) {
            sb.append((char)('0' + (int)(val % base)));
            val /= base;
        }
        return sb.reverse().toString();
    }
    
    private String[][] parseExpression(String[] expressions) {
        String[][] expressionsArr = new String[expressions.length][4];
        
        int idx = 0;
        for (String expression : expressions) {
            expression = expression.replaceAll("=", "");
            expressionsArr[idx++] = expression.split("\\s+");
        }
        
        return expressionsArr;
    }
}