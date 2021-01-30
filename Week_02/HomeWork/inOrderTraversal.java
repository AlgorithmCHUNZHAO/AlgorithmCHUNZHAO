
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         inorder(root,res);
//         return res;    
//     }
//     public void inorder(TreeNode root,List<Integer> res) {
//         if (root == null) {
//             return ;
//         }
//         inorder(root.left,res);
//         res.add(root.val);
//         inorder(root.right,res);
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while(root !=null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}