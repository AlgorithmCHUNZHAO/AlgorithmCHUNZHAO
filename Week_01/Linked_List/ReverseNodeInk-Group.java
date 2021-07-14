/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 思路：
// 1.使用栈，我们把k个数压入栈中，然后弹出来的顺序就是翻转的！这里要注意几个问题:
// 第一： 剩余的链表个数够不够k个
// 第二： 已经翻转的部分要与剩下链表连接起来。
// 思路二：尾插法：
// 思路三：递归

// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         Deque<ListNode> stack = new ArrayDeque<ListNode>();
//         ListNode dummy = new ListNode(0);
//         ListNode p = dummy;
//         while (true) {
//             int count  = 0;
//             ListNode tmp = head;
//             while (tmp != null && count < k) {
//                 stack.add(tmp);
//                 tmp = tmp.next;
//                 count++;
//             }
//             if (count !=k) {
//                 p.next = head;
//                 break;
//             }
//             while (!stack.isEmpty()) {
//                 p.next = stack.pollLast();
//                 p = p.next;
//             }
//             p.next = tmp;
//             head = tmp;
//         }
//         return dummy.next;
//     }
// }



// 2.画图解决函数提交问题
// 2.1链表分区分为已反转部分+待翻转部分+末翻转部分。
// 2.2需记录翻转链表前驱和后继，方便把已反转部分和末反转部分连接起来。
// 2.3总的时间复杂度为O(n*k)，最好情况是O(n)最差的情况未O(n2)
// 2.4空间复杂度为O(1)除了几个必须的节点之外，并没有占用其它空间。
// class Solution {

// public ListNode reverseKGroup(ListNode head,int k) {
//     ListNode dummy = new ListNode(0);
//     dummy.next = head;

//     ListNode pre = dummy;
//     ListNode end = dummy;
    
//     while (end.next != null) {
//         for (int i = 0; i < k && end != null;i++) end = end.next;
//         if (end == null) break;
//         ListNode start = pre.next;
//         ListNode next = end.next;
//         end.next = null;
//         pre.next = reverse(start);
//         start.next = next;
//         pre = start;

//         end = pre;

//     }
//     return dummy.next;
// }

// private ListNode reverse(ListNode head) {
//     ListNode pre = null;
//     ListNode curr = head;
//     while (curr != null) {
//         ListNode next = curr.next;
//         curr.next = pre;
//         pre = curr;
//         curr = next;
//     }
//     return pre;
// }

// }
//3.递归解法：
class Solution {
    public ListNode reverseKGroup(ListNode head,int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count !=k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr,k);
            while(count-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}