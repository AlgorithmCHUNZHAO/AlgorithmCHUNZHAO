class Solution {
    List<String> res;
    int M, N;
    public List<String> findWords(char[][] board, String[] words) {
        // root Node of trie
		TrieNode root = new TrieNode();
        this.M = board.length;
        this.N = board[0].length;
        
        res= new ArrayList();
        
        for (String w: words)
			insert(root, w);
        
        TrieNode node = root;
        for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
                node = hasPrefix(node, board[i][j]);
                if(node!=null){
                    boolean[][] visited = new boolean[M][N];
                    dfs(board, visited, i, j, root);
                }
                node  = root;
            }
        }
        
        return res;
    }
    
    public boolean dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode node){
        if(i < 0 || i >= M || j < 0 || j >= N || visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        TrieNode curnode  = hasPrefix(node, board[i][j]);
        
        if(curnode == null){
            visited[i][j] = false;
            return false;
        }
        
        if(curnode.word != null){
            res.add(curnode.word);
            curnode.word = null;
        }
        
        boolean result = dfs(board, visited, i+1, j, curnode) || dfs(board, visited, i-1, j, curnode) || 
                    dfs(board, visited, i, j+1, curnode) || dfs(board, visited, i, j-1, curnode);
        
        visited[i][j] = false;
        return result;
        
    }
    
    
    public TrieNode hasPrefix(TrieNode node, char c){
        return node.child.getOrDefault(c, null);
    }
    
	public void insert(TrieNode root, String word) {
		if(word == null)
            return;
        
        TrieNode cur = root;
        
        for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
            cur.child.putIfAbsent(c, new TrieNode());
            cur = cur.child.get(c);
        }
        
        cur.word = word;
	}
    
    class TrieNode {
		Map<Character, TrieNode> child;
		String word;

		public TrieNode() {
			word = null;
			child = new HashMap();
		}
	}

}