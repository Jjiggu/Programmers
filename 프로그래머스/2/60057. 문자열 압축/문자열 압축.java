public class Solution {
    public int solution(String s) {
        int n = s.length();
        int minLength = n; 

        for (int k = 1; k <= n / 2; k++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, k); 
            int count = 1;
            
            for (int i = k; i < n; i += k) {
                String curr = (i + k <= n) ? s.substring(i, i + k) : s.substring(i);
                if (prev.equals(curr)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(prev);
                    prev = curr;
                    count = 1;
                }
            }
            
            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);

            minLength = Math.min(minLength, compressed.length());
        }

        return minLength;
    }
}
