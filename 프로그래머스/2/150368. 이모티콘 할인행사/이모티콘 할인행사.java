import java.util.*;

class Solution {
    
    int maxSubscribe = 0;
    int maxSales = 0;
    int[] discountPer = {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, new int[emoticons.length], users, emoticons);
        
        return new int[]{maxSubscribe, maxSales};
    }
    
    public void dfs(int k, int[] discounts, int[][] users, int[] emoticons) {
        if (k == emoticons.length) {
            int subscriber = 0;
            int sales = 0;
            
            for (int[] user : users) {
                int sum = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (discounts[i] >= user[0]) {
                        sum += emoticons[i] * (100 - discounts[i]) / 100;
                    }
                }

                if (sum >= user[1]) subscriber++;
                else sales += sum;
            }
            
            if (subscriber > maxSubscribe || subscriber == maxSubscribe && sales > maxSales) {
                maxSubscribe = subscriber;
                maxSales = sales;
            }
            return;
        }
        
        for (int d : discountPer) {
            discounts[k] = d;
            dfs(k + 1, discounts, users, emoticons);
        }
    }
}