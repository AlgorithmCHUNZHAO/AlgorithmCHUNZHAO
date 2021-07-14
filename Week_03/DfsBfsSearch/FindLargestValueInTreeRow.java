class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res,1);
        return res;
    }
    private void helper(TreeNode root,List<Integer> res,int level) {
        if(root == null)
            return ;
        if(level == res.size() + 1) {
            res.add(root.val);
        }else {
            res.set(level - 1,Math.max(res.get(level - 1),root.val));
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}