class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums = null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if(nums[p] !=nums[q]) {
                if(q - p > 1) {
                    nums[p+1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int res = 1;
        for (int i = 1;i < nums.length;i++) {
            if(nums[i] !=nums[i-1]) {
                nums[res] = nums[i];
                res++
            }
        }
        return res;
    }
}





