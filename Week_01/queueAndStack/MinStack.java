// //方法一：使用栈stack

// class MinStack {
//     private Stack<Integer> stack;
//     private Stack<Integer> minStack;

//     public MinStack() {
//         stack = new Stack<>();
//         minStack = new Stack<>();
//     }
//     public void push(int x) {
//         stack.push(x);
//         if(!minStack.isEmpty()) {
//             int top = minStack.peek();
//             if(x <=top) {
//                 minStack.push(x);
//             }
//         } else {
//             minStack.push(x);
//         }
//     }
//     public void pop() {
//         int pop = stack.pop();
//         int top = minStack.peek();
//         if (pop == top) {
//             minStack.pop();
//         }
//     }
//     public int top() {
//         return stack.peek();
//     }
//     public int getMin() {
//         return minStack.peek();
//     }
// }


//单个链表法，用链表存储原来的最小值，
// class MinStack {
//     int min = Integer.MAX_VALUE;
//     Stack<Integer> stack = new Stack<Integer>();
//     public void push(int x) {
//         if (x <=min) {
//             stack.push(min);
//             min = x;
//         }
//         stack.push(x);
//     }
//     public void pop() {
//         if( stack.pop()==min) {
//             min = stack.pop();
//         }
//     }
//     public int top() {
//         return stack.peek();
//     }
//     public int getMin() {
//         return min;
//     }
// }
//使用链表来存储值

class MinStack {
    class Node{
        int value;
        int min;
        Node next;
        Node(int x ,int min) {
            this.value = x;
            this.min = min;
            next = null;
        }
    }
    Node head;
    public void push(int x) {
        if(null == head) {
            head = new Node(x,x);
        }else {
            Node n = new Node(x,Math.min(x,head.min));
            n.next = head;
            head = n;
        }
    }
    public void pop() {
        if (head !=null)
            head = head.next;
    }
    public int top() {
        if(head !=null)
            return head.value;
        return -1;
    }
    public int getMin() {
        if(null !=head)
            return head.min;
        return -1;
    }
}