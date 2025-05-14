import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        
        for (String operation : operations) {
            if (operation.startsWith("I ")) {
                int n = Integer.parseInt(operation.substring(2));
                maxPq.offer(n);
                minPq.offer(n);
            } else {
                if (operation.equals("D 1") && !maxPq.isEmpty()) {
                    minPq.remove(maxPq.poll());
                }
                
                if (operation.equals("D -1") && !minPq.isEmpty()) {
                    maxPq.remove(minPq.poll());
                }
            }
        }
        
        if (maxPq.isEmpty() || minPq.isEmpty()) {
            return new int[]{0, 0};
        } 
        
        return new int[]{maxPq.poll(), minPq.poll()};
    }
}