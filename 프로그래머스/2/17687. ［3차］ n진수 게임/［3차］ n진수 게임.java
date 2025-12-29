class Solution {
    
    private static final char[] DIGITS = 
    {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    
    public String solution(int n, int t, int m, int p) {
        int roop = t * m;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i <= roop; i++) sb.append(convertNum(i, n));
        
        StringBuilder answer = new StringBuilder();
        for (int i = p - 1; i < roop; i += m) answer.append(sb.charAt(i));
        
        return answer.toString();
    }
    
    private String convertNum(int num, int n) {
        if (num == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            sb.append(DIGITS[num % n]);
            num /= n;
        }
        
        return sb.reverse().toString();
    }
}