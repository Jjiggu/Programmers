import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> group = new HashMap<>();
        Map<String, Integer> profit = new HashMap<>();
        
        // 레퍼럴, 수익 초기화 
        for (int i = 0; i < enroll.length; i++) {
            group.put(enroll[i], referral[i]);
            profit.put(enroll[i], 0);
        }
        
        // 수익 계산
        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int price = amount[i] * 100;
            
            while (!sellerName.equals("-") && price > 0) { // 추천인 없을때까지 
                int refIncome = price / 10;
                int income = price - refIncome;
                
                profit.put(sellerName, profit.get(sellerName) + income);
    
                sellerName = group.get(sellerName);;
                price = refIncome;
            }
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profit.get(enroll[i]);
        }
        
        return answer;
    }
}
