//1.遍历整个数组，对记录每个值出现得次数，接着遍历HashMap中的每个Entry
//寻找value值 > nums.length / 2 的 key即可

class Solution {
    public int majorityElement(int nums) {
        int limit = nums.length >> 1;
        HashMap<Integer,Integer> map = new HashMap<>(limit);
        for(int num:nums)
            map.merge(num,1,(o_val,n_val) -> o_val + n_val);
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
            if(entry.getValue() > limit)
                return entry.getKey();
        return -1;
    }
}

// 对数组进行排序，然后找出次数大于n/2的元素

class Solution1 {
    public int majorityElement(int[] nums) {
        Array.sort(nums);
        return nums[nums.length >> 1];
    }
}
class Solution2 {
    public int majorityElement(int[] nums) {
        int len = (nums.length + 1) >> 1;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(len,Comparator.comparingInt(item -> -item));
        for(int num:nums) {
            pQueue.offer(num);
            if(pQueue.size() > len)
                pQueue.poll();
        }
        return pQueue.poll();
    }
}


// Bit manipulation 
class Solution {
    public int majorityElement(int[] nums) {
    int[] bit = new int[32];
    for (int num: nums)
        for (int i=0; i<32; i++) 
            if ((num>>(31-i) & 1) == 1)
                bit[i]++;
    int ret=0;
    for (int i=0; i<32; i++) {
        bit[i]=bit[i]>nums.length/2?1:0;
        ret += bit[i]*(1<<(31-i));
    }
    return ret;
}
}
