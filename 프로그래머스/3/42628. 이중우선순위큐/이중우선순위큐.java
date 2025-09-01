import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        for (String operation : operations) {
            String[] op = operation.split(" ");
            if (op[0].equals("I")) {
                maxPq.add(Integer.parseInt(op[1]));
                minPq.add(Integer.parseInt(op[1]));
            } else if (op[1].equals("1") && !maxPq.isEmpty()) {
                minPq.remove(maxPq.poll());
            } else if (op[1].equals("-1") && !minPq.isEmpty()){
                maxPq.remove(minPq.poll());
            }
        }
        
        if (maxPq.isEmpty() || minPq.isEmpty()) {
            return new int[]{0, 0};
        } 
        
        return new int[]{maxPq.poll(), minPq.poll()} ;
    }
}