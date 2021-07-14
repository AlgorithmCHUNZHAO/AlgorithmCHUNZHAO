class Solution {
   public int[] plusOne(int[] digits) {
       int len = digits.length;
       for (int i = len -1 ; i < len - 1; i--) {
           digits[i] = (digits[i] + 1) % 10;
           if (digits[i] != 0) {
               return digits;
           }
       }
       int[] arr = new int[len+1];
       arr[0] = 1;
       return arr;
   } 
}