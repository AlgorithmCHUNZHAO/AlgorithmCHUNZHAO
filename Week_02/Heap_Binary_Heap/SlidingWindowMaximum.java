// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int len = nums.length;
//         if(len == 0) {
//             return nums;
//         }
//         int[] arr = new int[len- k + 1];
//         int arr_index = 0;
//         Deque<Integer> deque = new LinkedList<>();
//         for (int i = 0; i < k;i++){
//             while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
//                 deque.removeLast();
//             }
//             deque.offerLast(nums[i]);
//         }
//         arr[arr_index++] = deque.peekFirst();
//         for(int j = k;j < len;j++) {
//             if(nums[j-k] == deque.peekFirst()) {
//                 deque.removeFirst();
//             }
//             while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
//                 deque.removeLast();
//             }
//             deque.offerLast(nums[j]);
//             arr[arr_index++] = deque.peekFirst();
//         }
//         return arr;
//     }
// }

// Brute-Force
//check every sliding window and compute the maximum value
// class Solution {
//     public int[] maxSlidingWindow(int[] nums,int k) {
//     int n = nums.length;
//     if (n == 0 || k == 0) {
//         return new int[0];
//     }

//     int numOfWindow = n -k+1;
//     int[] result = new int[numOfWindow];//number of windows
//     for(int start = 0; start < numOfWindow;++start)  {
//         int end = start + k - 1;
//         int maxVal = nums[start];
//         for(int i = start + 1;i <=end;++i) {
//             if(nums[i] > maxVal) {//update
//                 maxVal = nums[i];
//             }
//         }
//         result[start] = maxVal;
//     }
//     return result;
// }

// }

// class Solution {
//     public int[] maxSlidingWindow(int[] nums,int k) {
//         //assume nums is not null
//         if (nums.length == 0 || k == 0) {
//             return new int[0];
//         }
//         int n = nums.length;
//         int[] result = new int[n- k + 1];

//         PriorityQueue<Integer> maxPQ = new PriorityQueue<>((i1,i2) -> (nums[i2] - nums[i1]));

//         for(int i = 0;i < n;++i) {
//             int start = i - k;
//             if (start >= 0) {
//                 maxPQ.remove(start); // remove the out-of-bound value by index
//             }
//             maxPQ.offer(i);
//             if (maxPQ.size() == k) {
//                 result[i - k + 1] = nums[maxPQ.peek()];
//             }
//         }
//         return result;
//     }
// }
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      // assume nums is not null
      if (nums.length == 0 || k == 0) {
        return new int[0];
      }
      int n = nums.length;
      int[] result = new int[n - k + 1]; // number of windows
      
      // left & right
      int[] left = new int[n];
      int[] right = new int[n];
      left[0] = nums[0]; // init
      right[n - 1] = nums[n - 1];
      
      for (int i = 1; i < n; ++i) {
        // left
        if (i % k == 0) left[i] = nums[i];
        else            left[i] = Math.max(left[i - 1], nums[i]);
        // right
        int j = n - i - 1;
        if (j % k == (k - 1)) right[j] = nums[j];
        else                  right[j] = Math.max(right[j + 1], nums[j]);
      }
      
      // dp
      for (int i = 0, j = i + k - 1; j < n; ++i, ++j) {
        result[i] = Math.max(right[i], left[j]);
      }
      
      return result;
    }
    }