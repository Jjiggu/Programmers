import java.util.*;

class Solution {
    
    class Node {
        int x, y, index;
        Node left;
        Node right;
        
        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        
        for (int i = 0; i < nodeinfo.length; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            nodes.add(new Node(x, y, i + 1));
        }
        
        nodes.sort((o1, o2) -> {
            if (o1.y == o2.y) return o1.x - o2.x;
            return o2.y - o1.y;
        });
        
        Node root = nodes.get(0);
        
        for (int i = 1; i < nodes.size(); i++) {
            insert(root, nodes.get(i));
        }
        
        List<Integer> pre = new ArrayList<>();
        preorder(root, pre);
        int[] preArr = pre.stream().mapToInt(i -> i).toArray();
        
        List<Integer> post = new ArrayList<>();
        postorder(root, post);
        int[] postArr = post.stream().mapToInt(i -> i).toArray();
        
        return new int[][]{preArr, postArr};
    }
    
    
    public void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    
    public void preorder(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.index);
            preorder(node.left, result);
            preorder(node.right, result);
        }
    }
    
    public void postorder(Node node, List<Integer> result) {
        if (node != null) {
            postorder(node.left, result);
            postorder(node.right, result);
            result.add(node.index);
        }
    }
}