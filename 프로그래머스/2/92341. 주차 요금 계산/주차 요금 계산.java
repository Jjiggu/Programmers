import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, int[]> map = new HashMap<>();
        
        for (String record : records) {
            String[] r = record.split(" ");
            int time = timeToInt(r[0]); 
            String car = r[1];
            String inout = r[2];
            
            if (inout.equals("IN")) {
                map.putIfAbsent(car, new int[]{0, 0}); 
                map.get(car)[0] = time; 
            } else {
                int[] val = map.get(car);
                val[1] += time - val[0];
                val[0] = -1; 
            }
        }
        
        int endOfDay = 23 * 60 + 59;
        for (int[] val : map.values()) {
            if (val[0] != -1) {
                val[1] += endOfDay - val[0];
                val[0] = -1;
            }
        }
        
        List<String> cars = new ArrayList<>(map.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            int totalTime = map.get(cars.get(i))[1];
            answer[i] = calc(fees, totalTime);
        }
        
        return answer;
    }
    
    public int timeToInt(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    public int calc(int[] fees, int totalTime) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2]; 
        int unitFee = fees[3];
        int fee = 0;
        
        if (totalTime - baseTime <= 0) {
            return baseFee;
        } else {
            fee += baseFee;
            int extraFee = (int)Math.ceil((totalTime - baseTime) / (double)unitTime) * unitFee;
            return extraFee + fee;
        }
    }
}