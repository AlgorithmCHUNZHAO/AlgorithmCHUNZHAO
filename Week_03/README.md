
## 代码模板
### 分治代码模板
```
//Java
private static int divider_conquer(Problem problem) {

    if (problem == NULL) {
        int res = process_last_result();
        return res;
    }

    subProblems = split_problem(problem)

    res0 = divide_conquer(subProblems[0]);
    res1 = divide_conquer(subProblems[1]);

    result = process_result(res0,res1);

    return result;
}
//Python

def divide_conquer(problem,param1,param1,param2,...):
    # recursion terminator
    if problem is None:
        print_result
        return
    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem,data)
    
    # conquer subproblems
    subresult1 = self.divide_conquer(subprblems[0],p1,...)
    subresult2 = self.divide_conquer(subprblems[1],p2,...)
    subresult3 = self.divide_conquer(subproblems[2],p3,...)


    #process and generate the final result
    result = process_result(subresult1,subresult2,subresult3,...)

    #revert the current level states
```
### DFS递归

```
// java

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root == null) {
            return allResult;
        }
        travel(root,0,allResults);
        return allResults;
    }

    private void travel(TreeNode root ,int level,List<List<Integer>>results) {
        if(results.size() == level) {
            result.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null) {
            travel(root.left,level+1,results);
        }
        if(root.right!=null) {
            travel(root.right,level+1,results);
        }
    }

//python

visited = set()
def dfs(node,visited):
    if node in visited: #terminator
        # already visited
        return
    visited.add(node)
    # process current node here
    ...
    for next_node in node.children():
        if next_node not in visited:
            dfs(next_node,visited)
```
### DFS非递归
```
#Python 

def DFS(self,tree):
    if tree.root is None:
        return []
    visited,stack = [],[tree.root]
    while stack:
        node = stack.pop()
        visited.add(node)
    process(node)
    nodes = generate_related_nodes(node)
    stack.push(nodes)
    # other processing work
#C/C++
void dfs(Node* root) {
    map<int,int> visited;
    if(!root) return;
    stack<Node*> stackNode;
    stackNode.push(root);

    while(!stackNode.empty()) {
        Node* node = stackNode.top();
        stackNode.pop();
        if(visited.count(node->val)) continue;
        visited[node->val] = 1;

        for (int i = node->chilren.size() - 1;i >=0;--i) {
            stackNode.push(node->chilren[i]);
        }
    }
    return;
}
```
### BFS代码模板
```
//Python
def BFS(graph,start,end):
    visited = set()
    queue = []
    queue.append([start])

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
    #other processing work


//Java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNde(int x) {
        val = x;
    }
}
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if(root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while(!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < size;i++>) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if(node.left !=null) {
                nodes.add(node.left);
            }
            if(node.right !=null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}

//C/C++



```