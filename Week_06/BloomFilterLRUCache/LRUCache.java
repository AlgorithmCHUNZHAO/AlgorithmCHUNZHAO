public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    
    }
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;
    }
    private void removeNode(DLinkedNode node) {

    }
    private void moveToHead(DLinkedNode node) {

    }
    private DLinkedNode popTail() {

    }
    private Hashtable<Integer, DLinkedNode> 
        cache = new Hashtable<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
      
        head = new DLinkedNode();
        head.pre = null;
      
        tail = new DLinkedNode();
        tail.post = null;
      
        head.post = tail;
        tail.pre = head;
    }
    public int get(int key) {

        DLinkedNode node = cache.get(key);
        if(node == null){
          return -1; // should raise exception here.
        }
      
        // move the accessed node to the head;
        this.moveToHead(node);
      
        return node.value;
    }
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
      
        if(node == null){
      
          DLinkedNode newNode = new DLinkedNode();
          newNode.key = key;
          newNode.value = value;
      
          this.cache.put(key, newNode);
          this.addNode(newNode);
      
          ++count;
      
          if(count > capacity){
            // pop the tail
            DLinkedNode tail = this.popTail();
            this.cache.remove(tail.key);
            --count;
          }
        }else{
          // update the value.
          node.value = value;
          this.moveToHead(node);
        }
      }
}