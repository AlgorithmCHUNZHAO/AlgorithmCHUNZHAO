/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// class Solution {
//     public List<Integer> postorder(Node root) {
//         List<Integer> list = new ArrayList<>();
//         order(root);
//         return list;
//     }
//     public void order(Node root) {
//         if(root == null ) {
//             return;
//         }
//         for(Node child: root.children) {
//             order(child);
//         }
//         list.add(root.val);
//     }
// }




// class Solution {
//     List<Integer> list = new ArrayList<>();
//     public List<Integer> postorder(Node root) {
//         if (root == null)
//             return list;
        
//         for(Node node: root.children)
//             postorder(node);
        
//         list.add(root.val);
        
//         return list;
//     }
// }

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for(Node node: root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }
}