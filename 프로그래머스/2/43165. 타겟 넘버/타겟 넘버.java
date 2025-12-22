class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {  
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    private void dfs(int k, int curSum, int[] numbers, int target) {
        if (k == numbers.length) {
            if (curSum == target) answer++; 
            return;
        }
        
        int num = numbers[k];
        dfs(k + 1, curSum + num, numbers, target);
        dfs(k + 1, curSum - num, numbers, target);
    }
}