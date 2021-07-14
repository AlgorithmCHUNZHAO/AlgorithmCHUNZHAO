// 1122
class Solution {
    Map<Integer, Integer> record;
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        record = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            record.put(arr2[i], i);
        }
        shellSort(arr1);
        return arr1;
    }
    public void shellSort(int[] arr) {
        int len = arr.length;
        int h = 0;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                    swap(arr, j, j - h);
                }
            }
            h /= 3;
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public boolean less(int nums1, int nums2) {
        if (record.containsKey(nums1) && record.containsKey(nums2)) {
            return record.get(nums1) < record.get(nums2);
        } else if (record.containsKey(nums1)) {
            return true;
        } else if (record.containsKey(nums2)) {
            return false;
        } else {
            return nums1 < nums2;
        }
    }
}