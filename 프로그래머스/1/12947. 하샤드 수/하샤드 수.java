class Solution {
    public boolean solution(int x) {
        
        String[] hashadnum = String.valueOf(x).split("");
        int sum = 0;
        
        for(String num:hashadnum) {
            sum += Integer.parseInt(num);
        }
        
        if (x % sum == 0) {
            return true;
        } else {
            return false;
        }
         
    }
}