/*
方法一，暴力求解，通过对数字进行遍历，然后将长度与高度相乘，比较值得大小，最后得出最大值,时间复杂度为O(n2),就不写了。
方法二，使用双指针移动法，
首先将双指针放到容器两边，将其容器盛水得值视为暂定为最大值max，如果指针所指高度相对低得向内侧移动，每次移动将与最大值比较，
如果更大，那么将值进行替换，不是得话，在进行上述操作比较两边得值，最后得出最大值。

*/

// class Solution {
//     public int maxArea(int[] height) {
//         int left = 0;
//         int right = height.length - 1;
//         int res = 0;
//         while(left <= right) {
//             res = Math.max(res,(right - left) * Math.min(height[left],height[right]));
//             if (height[left] < height[right]) {
//                 left++;
//             } else {
//                 right--;
//             }
//         }
//         return res;
//     }
// }
// class Solution {
//     public int maxArea(int[] height) {
//     int max=0, left=0, right=height.length-1;
//     while (left < right) {
//         int area = (right-left) * Math.min(height[left], height[right]);
//         max = Math.max (max, area);
//         if (height[left] < height[right]) {
//             int i = left;
//             while (height[left] <= height[i] && left < right) left++;
//         } else {
//             int j = right;
//             while (height[j] >= height[right] && left < right) right--;
//         }
//     }
//     return max;
// }
// }
class Solution {
    public int maxArea(int[] height) {
        int max = 0,left = 0,right=height.length-1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, (right-left) * h);

            while (height[left] <= h && left < right) left++;
            while (height[right] <= h && left < right) right--; 
        }
        return max; 
    }
}