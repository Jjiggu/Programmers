import java.util.*;

class Solution {
    
    int maxSubscribers = 0;
    int maxSales = 0;
    int[] discountPer = {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, new int[emoticons.length], users, emoticons);
        
        return new int[]{maxSubscribers, maxSales};
    }
    
    private void dfs(int k, int[] discounts, int[][] users, int[] emoticons) {
        if (k == emoticons.length) {
            int subscribers = 0;
            int sales = 0;
            
            for (int[] user : users) {
                int sum = 0;
                
                
                for (int i = 0; i < emoticons.length; i++) {
                    if (discounts[i] >= user[0]) {
                        sum += emoticons[i] * (100 - discounts[i]) / 100;
                    }
                }
                
                if (sum >= user[1]) subscribers++;
                else sales += sum;
            }
            
            if (subscribers > maxSubscribers || subscribers == maxSubscribers && sales > maxSales) {
                maxSubscribers = subscribers;
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