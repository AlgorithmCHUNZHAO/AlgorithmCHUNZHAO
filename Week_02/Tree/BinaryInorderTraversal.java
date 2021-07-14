

//递归
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         dfs(res,root);
//         return res;
//     }
//     void dfs(List<Integer> res,TreeNode root) {
//         if(root == null) {
//             return;
//         }
//         dfs(res,root.left);
//         dfs.add(root.val);
//         dif(res,root.right);
//     }
// }

//非递归
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(stack.size() > 0 || root !=null) {
            if(root!=null){
                stack.add(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop()
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }
}