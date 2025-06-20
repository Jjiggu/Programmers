import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {

        Arrays.sort(bans, (o1, o2) -> {
            if (o1.length() != o2.length()) return o1.length() - o2.length();
            return o1.compareTo(o2);
        });
        
        long curr = n;
        for (String ban : bans) {
            String cand = getOrder(curr);
            if (ban.length() < cand.length() || (ban.length() == cand.length() && ban.compareTo(cand) <= 0)) {
                curr++;
            } else if (ban.length() > cand.length()) {
                break;
            }
        }
        
        return getOrder(curr);
    }
    
    private String getOrder(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            long mod = n % 26;
            if (mod == 0) {
                sb.append('z');
                n = n / 26 - 1;
            } else {
                sb.append((char)('a' + mod - 1));
                n = n / 26;
            }
        }
        return sb.reverse().toString();
    }
}
