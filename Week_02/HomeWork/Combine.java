//思路解析：
//




class Solution {
    public List<List<Integer>> combine(int n,int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs();
        return res;
    }
    private void dfs(int n,int k ,int index,Deque<Integer> path,List<List<Integer>> res) {
        if(path.size() == k) {
            res.add(new ArrayDeque<>(path));
            return;
        }
        for (int i = index; i <=n - (k-path.size()) + 1;i++) {
            path.addLast(i);
            dfs(n,k,i+1,path.res);
            path.removeLast();
        }
    }
}