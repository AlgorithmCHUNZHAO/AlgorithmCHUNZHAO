



class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0) {
            return new int[0];
        }
        Queue<Integer> heap = new PriorityQueue<>(k,(i1,i2) -> Integer.compare(i2,i1));
        for(int e : arr) {
            //当前数字小于堆顶元素才会入堆
            if(heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if(heap.size() > k) {
                heap.poll();//删除堆顶元素
            }
        }
        //将堆中元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for(int e: heap) {
            res[j++] = e;
        }
        return res;
    }
}