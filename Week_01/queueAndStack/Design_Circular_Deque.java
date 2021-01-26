class MyCircularDeque {
    int size;
    int k;
    DoubleListNode head;
    DoubleListNode tail;
    // Initialize your data structure here.Set the size of the deque to be k
    public MyCircularDeque(int k) {
        head = new DoubleListNode(-1);
        tail = new DoubleListNode(-1);
        head.pre = tail;
        tail.next = head;
        this.k = k;
        this.size = 0;
    }
    public boolean insertFront(int value) {
        if (size == k )
            return false;
        DoubleListNode node = new DoubleListNode(value);
        node.next = head;
        node.pre = head.pre;
        head.pre.next = node;
        head.pre = node;
        size++;
        return true;
    }
    public boolean insertLast(int value) {
        if (size == k)
            return false;
        DoubleListNode node = new DoubleListNode(value);
        node.next = tail.next;
        tail.next.pre = node;
        tail.next = node;
        node.pre = tail;
        size++;
        return true;
    }
    public boolean deleteFront() {
        if (size == 0) 
            return false;
        head.pre.pre.next = head;
        head.pre = head.pre.pre;
        size--;
        return true;
    }    
    public boolean deleteLast() {
        if (size == 0)
            return false;
        tail.next.next.pre = tail;
        tail.next = tail.next.next;
        size--;
        return true;
    }
    public int getFront() {
        return head.pre.val;
    }
    public int getRear() {
        return tail.next.val;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == k;
    }
}

class DoubleListNode {
    DoubleListNode pre;
    DoubleListNode next;
    int val;
    public DoubleListNode(int val) {
        this.val =val;
    }
}