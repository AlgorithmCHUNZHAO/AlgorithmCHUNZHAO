//方法一：对两个数组进行合并，然后再排序
//O((n+m)log(n+m))
//O(1)
class Solution {
    public void merge(int[] nums1,int m,int[] nums2,int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1)
    }
}

// 从前往后遍历

class Solution {
    public void merge(int[] nums1,int m,int[] nums2,int n) {
        //Make a copy of nums1.
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++]:nums2[p2++];
        if (p1 < m)
            System.arraycopy(nums1_copy,p1,nums1,p1+p2,m+n-p1-p2);
        if (p2 < n)
            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);
    }
}


class Solution {
    public void merge(int[] nums1,int m,int[] nums2,int n) {
        if (n == 0) return;
        int i = m - 1;
        int j = n - 1;
        int cur_max_pos = nums1.length - 1;
        while (i >=0 && j >=0) {
            if(nums1[i] >= nums2[j]) {
                nums1[cur_max_pos--] = nums1[i--];
            }else {
                nums1[cur_max_pos--] = nums2[j--];
             }
        }
        while (j >= 0) {
            nums1[cur_max_pos--] = nums2[j--];
        }
    }
}


