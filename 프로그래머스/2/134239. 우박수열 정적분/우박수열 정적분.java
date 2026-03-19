import java.util.*;

class Solution {
    
    List<Double> areaList = new ArrayList<>();
    int n;
    
    public double[] solution(int k, int[][] ranges) {
        List<Integer> collatzList = collatz(k);
        
        n = areaList.size();
        
        double[] prefix = calcprefix();
        double[] answer = findAnswer(prefix, ranges);
        
        return answer;
    }
    
    private double[] findAnswer(double[] prefix, int[][] ranges) {
        double[] arr = new double[ranges.length];
        
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int start = range[0];
            int end = n + range[1] - 1;
            
            if (start >= n || start > end) arr[i] = -1.0;
            else arr[i] = prefix[end] - prefix[start];
        }
        
        return arr;
    }
    
    private double[] calcprefix() {
        double[] arr = new double[n];
        
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + areaList.get(i);
        }
        
        return arr;
    }
    
    private List<Integer> collatz(int k) {
        int n = 0;
        List<Integer> list = new ArrayList<>();
        list.add(k);
        areaList.add(0.0);
        
        while (k > 1) {
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
            
            calcArea(n, k, list.get(n));
            
            n++;
            list.add(k);
        }
        
        return list;
    }
    
    private void calcArea(int x, int y, int prevY) {
        double area = (y + prevY) / 2.0;
        areaList.add(area);
    }
}