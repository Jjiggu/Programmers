import java.util.*;

class Solution {
    class Node {
        int idx;
        Node prev, next;
        
        public Node(int idx) {
            this.idx = idx;
        }
    }
    
    
    public String solution(int n, int k, String[] cmd) {    
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int i = 1; i < n; i++) {
            nodes[i].prev = nodes[i - 1];
            nodes[i - 1].next = nodes[i];
        }
        
        Node cursor = nodes[k];
        Stack<Node> removed = new Stack<>();
        
        
        for (String c : cmd) {
            char type = c.charAt(0);

            if (type == 'U') {
                int x = Integer.parseInt(c.substring(2));
                for (int i = 0; i < x; i++) cursor = cursor.prev;
            } else if (type == 'D') {
                int x = Integer.parseInt(c.substring(2));
                for (int i = 0; i < x; i++) cursor = cursor.next;
            } else if (type == 'C') {
                removed.push(cursor);
                if (cursor.prev != null) cursor.prev.next = cursor.next;
                if (cursor.next != null) cursor.next.prev = cursor.prev;
                Node next = (cursor.next != null) ? cursor.next : cursor.prev;
                cursor = next;
            } else if (type == 'Z') {
                Node node = removed.pop();
                if (node.prev != null) node.prev.next = node;
                if (node.next != null) node.next.prev = node;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        boolean[] isDelete = new boolean[n];
        while(!removed.isEmpty()) isDelete[removed.pop().idx] = true;
        for (int i = 0; i < n; i++) sb.append(isDelete[i] ? 'X' : 'O');
        
        return sb.toString();
    }
}