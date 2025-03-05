import java.util.*;

class Solution {
    public int[] solution(String[] operations) throws Exception{
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            
            char command = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            
            if (command == 'I') {
                pq.add(num);
            } else {
                if (!pq.isEmpty()) {
                    if (num == 1) {
                        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
                        maxHeap.addAll(pq);
                        maxHeap.poll();
                        pq.clear();
                        pq.addAll(maxHeap);
                    } else {
                        pq.poll();
                    }    
                }
                
            }
            
        }
        
        if (pq.isEmpty()) {
            return new int[] {0, 0};
        }
        
        int min = Collections.min(pq);
        int max = Collections.max(pq);
        
        return new int[] {max, min};
    }
}