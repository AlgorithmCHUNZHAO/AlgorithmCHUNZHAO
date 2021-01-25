// 1.对数组进行遍历，使用index记录数组中非零的值，然后如果该值为非零，那么将该值往前一位，，最后遍历完所有非零值，
// 然后将该数组的所有空位补零，

// 2.对数组进行遍历，使用两个指针记录数组中的值，一个指针记录非零值，一个指针记录0值，然后再将非零值与其交换，直到遍历完成。

// class Solution {
//     public void moveZeroes(int[] nums) {

//         if (nums == null) {
//             return ;
//         }

//         int j = 0;
//         for(int i = 0 ; i < nums.length;++i) {
//             if(nums[i] != 0) {
//                 nums[j++] = nums[i];
//             }
//         }
//         for (int i = j;i < nums.length;++i) {
//                 nums[i] = 0;
//         }
        
//     }
// }


class Solution {
    public void moveZeroes(int[] nums) {

        if (nums == null) {
            return ;
        }
        int j = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] =tmp;
            }
        }
    }
}


// public void moveZeroes(int[] nums) {

//     int j = 0;
//     for(int i = 0; i < nums.length; i++) {
//         if(nums[i] != 0) {
//             int temp = nums[j];
//             nums[j] = nums[i];
//             nums[i] = temp;
//             j++;
//         }
//     }
// }
// Shift non-zero values as far forward as possible
// Fill remaining space with zeros

// public void moveZeroes(int[] nums) {
//     if (nums == null || nums.length == 0) return;        

//     int insertPos = 0;
//     for (int num: nums) {
//         if (num != 0) nums[insertPos++] = num;
//     }        

//     while (insertPos < nums.length) {
//         nums[insertPos++] = 0;
//     }
// }