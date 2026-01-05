import java.util.*;

class Solution {
    
    class Truck {
        int weight;
        int enterTime;
        
        public Truck(int weight, int enterTime) {
            this.weight = weight;
            this.enterTime = enterTime;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Truck> q = new ArrayDeque<>();
        int time = 0;
        int idx = 0;
        int curWeight = 0;
        
        while (idx < truck_weights.length || !q.isEmpty()) {
            time++;
            
            if (!q.isEmpty()) {
                Truck front = q.peek();
                if (time - front.enterTime == bridge_length) {
                    curWeight -= front.weight;
                    q.poll();
                }
            }
            
            if (idx < truck_weights.length) {
                int next = truck_weights[idx];
                if (curWeight + next <= weight) {
                    q.offer(new Truck(next, time));
                    curWeight += next;
                    idx++;
                }
            }
        }
        return time;
    }
}