class Solution {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> res = new ArrayList<>();
        if(len==0) return res;

        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        dfs(res,map,digits,sb,0,len);
        return res;
    }
    public void dfs(List<String> res,String[] map,String digits,StringBuilder sb,int depth,int len) {
        if(depth == len) {
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(depth);
        String str = map[c-'0'];
        for(int i = 0;i < str.length();++i) {
            sb.append(str.charAt(i));
            dfs(res,map,digits,sb,depth+1,len);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}