## 学习笔记

### 字典树

### 并查集

```
class UnionFind{
    private int count = 0;
    private int[] parent;
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for(int i = 0; i < n;i++) {
            parent[i] = i;
        }
    }
    public int find(int p) {
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public void union(int p,int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return ;
        parent[rootP] = rootQ;
        count--;
    }
}

```
### 双向BFS

```
def BFS(graph,start,end):
    visited = set()
    queue = []
    queue.append[start]
    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        node = generate_related_nodes(node)
        queue.push(nodes)
    #other process work


def dBFS(graph,start,end):
    visited = set()
    front = []
    back = []
    front.append(start)
    back.append(end)
    while front and back:
        nodes = set()
        for node in front:
            visited.add(node)
            process(node)
            nodes.append(generate_related_nodes(node))
        front = nodes

        if len(back) < len(front)
            front,back = back,front
```