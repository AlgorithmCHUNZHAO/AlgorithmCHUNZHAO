class Solution {
    public List<Integer> preoderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root !=null || (!stack.isEmpty())) {
            if (root !=null){
                list.add(root.val);//步骤一，取根节点的value
                stack.push(root);
                root = root.left;//步骤二，遍历左子树
            }
            else {
                TreeNode tem = stack.pop();
                root = tem.right;//遍历右子树
            }
        }
        return list;
    }
}