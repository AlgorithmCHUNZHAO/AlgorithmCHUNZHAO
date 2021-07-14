// //思路与算法
// 首先遍历整个数组，并使用哈希表记录每个数字出现的次数，并形成一个[出现次数数组]。
// 找出原数组的前k个高频元素，就是相当于找出【出现次数数组】的前k大值。
// 在这里首先利用堆的思想，建立一个小顶堆，然后遍历【出现次数数组】
// 如果堆的元素个数小于k,直接插入堆中
// 如果堆的元素个数等于k,则检查堆顶与当前出现次数的大小，如果堆顶更大，说明至少有k个数字的出现比当前值大，那么舍弃当前值；
// 否则，就弹出堆顶，并将当前值插入堆中；
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer,Integer> occurrences = new HashMap<Integer,Integer>();
//         for(int num: nums) {
//             occurrences.put(num,occurrences.getOrDefault(num,0)+1);
//         }

            // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
//         PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
//             public int compare(int[] m,int[] n) {
//                 return m[1] - n[1];
//             }
//         });
//         for(Map.Entry<Integer,Integer> entry: occurrences.entrySet()) {
//             int num = entry.getKey(),
//             count = entry.getValue();
//             if(queue.size() == k) {
//                 if(queue.peek()[1] < count) {
//                     queue.poll();
//                     queue.offer(new int[] {num,count});
//                 }
//             } else {
//                 queue.offer(new int[] {num,count});
//             }
//         }
//         int[] ret = new int[k];
//         for(int i = 0; i < k;++i) {
//             ret[i] = queue.poll()[0];
//         }
//         return ret;
//     }
// }

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);
        
        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }
}