class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        char[] digits = {'1', '2', '4'};
        
        while (n > 0) {
            n--;
            int r = n % 3;
            sb.append(digits[r]);
            n /= 3;
        }
        
        return sb.reverse().toString();
    }
}