import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<int[]> collatzList = collatz(k);
        int n = collatzList.get(collatzList.size() - 1)[1];
        
        double[] prefixSum = prefix(collatzList);
        
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int x = range[0];
            int y = n + range[1];
            
            if (x > y) {
                answer[i] = -1;
            } else if (x == y) {
                answer[i] = 0;
            } else {
                answer[i] = prefixSum[y] - prefixSum[x];
            }
        }
        
        // System.out.println(Arrays.deepToString(collatzList.toArray()));
        return answer;
    }
    
    public List<int[]> collatz(int k) {
        List<int[]> collatzList = new ArrayList<>();
        int num = k;
        int idx = 1;
        collatzList.add(new int[]{num, 0});
        
        while(num != 1) {
            int[] tmp = new int[2];
            
            if (num % 2 == 0) {
                tmp[0] = num / 2;
                tmp[1] = idx;
                num /= 2;
                idx++;
                collatzList.add(tmp);
            } else if (num % 2 == 1) {
                tmp[0] = num * 3 + 1;
                tmp[1] = idx;
                num = num * 3 + 1;
                idx++;
                collatzList.add(tmp);
            }
        }
        
        return collatzList;
    }
    
    public double[] prefix(List<int[]> collatzList) {
        double[] prefixSum = new double[collatzList.size()];
        prefixSum[0] = 0.0;
        
        for (int idx = 1; idx < collatzList.size(); idx++) {
            double prevX = collatzList.get(idx - 1)[0];
            double nowX = collatzList.get(idx)[0];
            double area = (prevX + nowX) / 2.0;  
            prefixSum[idx] = prefixSum[idx - 1] + area;
        }
        
        return prefixSum;
    }
}