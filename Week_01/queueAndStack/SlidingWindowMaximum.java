
class Solution {
    public int[] maxSlidingWindow(int[] nums.int k) {
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        int[] arr = new int[len - k + 1];
        int arr_index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0 ; i < k;i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
             }
             deque.offerLast(nums[i]);
        }
        arr[arr_index++] = deque.peekFirst();
        for(int j = k;j < len;j++) {
            if(nums[j-k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.offerLast(nums[j]);
            arr[arr_index++] = deque.peekFirst();
        }
        return arr;
    }
}