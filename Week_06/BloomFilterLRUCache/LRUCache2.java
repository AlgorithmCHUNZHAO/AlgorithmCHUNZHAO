class LRUCache {
    LinkedNodeList list;
    Map<Integer, Node> map;
    Integer cap;
    public LRUCache(int capacity) {
        list = new LinkedNodeList();
        map = new HashMap(capacity);
        cap = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        list.moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            list.moveToHead(node);
            node.val = value;

        }else{
             Node newNode = new Node(key, value);
            if(map.size() == cap){
                Node tail = list.getTail();
                map.remove(tail.key);
                list.removeTail();
            }
            map.put(key, newNode);
            list.addToHead(newNode);
        }
    }
}

class LinkedNodeList{
    Node dummyHead;
    Node dummyTail;
    
    LinkedNodeList(){
        dummyHead = new Node(0,0);
        dummyTail = new Node(0,0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    void moveToHead(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }
    
    void addToHead(Node node){
        Node tmp = dummyHead.next ;
        dummyHead.next = node;
        node.next = tmp;
        node.prev = dummyHead;
        tmp.prev = node;
    }
    
    void removeTail(){
        Node newTail = dummyTail.prev.prev;
        newTail.next = dummyTail;
        dummyTail.prev = newTail;
    }
    
    Node getTail(){
        return dummyTail.prev;
    }
    
}

 class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int value){
            this.key = key;
            this.val =value;
        }
}