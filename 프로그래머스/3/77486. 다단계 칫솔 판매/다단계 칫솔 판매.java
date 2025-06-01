import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int[] answer = new int[enroll.length];
        Map<String, String> group = new HashMap<>();
        Map<String, Integer> profit = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            group.put(enroll[i], referral[i]);
            profit.put(enroll[i], profit.getOrDefault(enroll[i], 0));
        }
        
        
        for (int i = 0; i < amount.length; i++) {
            int price = amount[i] * 100;
            String sellerName = seller[i];
            
            while (!sellerName.equals("-") && price > 0) {
                int refProfit = price / 10;
                int myProfit = price - refProfit;   
                
                profit.put(sellerName, profit.get(sellerName) + myProfit);
                
                sellerName = group.get(sellerName);
                price = refProfit;  
            }
        }
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profit.get(enroll[i]);
        }
        
        return answer;
    }
}
