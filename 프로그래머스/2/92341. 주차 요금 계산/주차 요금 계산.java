import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, int[]> map = initMap(records);
        int[] answer = new int[map.size()];
        int maxTime = 23 * 60 + 59;
        int idx = 0;
        
        for (int[] parking : map.values()) {
            if (parking[0] != -1) parking[1] += maxTime - parking[0];
            answer[idx++] = calcFee(fees, parking);
        }
        return answer;
    }
    
    private int calcFee(int[] fees, int[] parking) {
        int basicTime = fees[0];
        int basicFare = fees[1];
        int unitTime = fees[2];
        int excess = fees[3];
        int totalFare = 0;
        
        if (parking[1] <= basicTime) {  // 기본 시간 내 주차 
            totalFare = basicFare;
        } else {
            totalFare = basicFare + (int)Math.ceil((double)(parking[1] - basicTime) / unitTime) * excess;
        }
        
        return totalFare;
    }
    
    private Map<String, int[]> initMap(String[] records) {
        Map<String, int[]> map = new TreeMap<>();
        
        for (String record : records) {
            String[] r = record.split(" ");
            int time = timeToInt(r[0]);
            String carNum = r[1];
            String inOut = r[2];
            
            if (inOut.equals("IN")) {
                map.computeIfAbsent(carNum, k -> new int[2])[0] = time;
            } else {
                int[] val = map.get(carNum);
                val[1] += time - val[0];
                val[0] = -1;
            }
        }
        
        return map;
    }
    
    private int timeToInt(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}