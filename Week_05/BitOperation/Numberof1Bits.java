// 位运算可知,任何数与1进行位运算都得最低位
// class Solution {
//     public int hammingWeight(int n) {
//         int bits = 0;
//         int mask = 1;
//         for (int i = 0; i < 32;i++) {
//             if((n & mask) !=0) {
//                 bits++;
//             }
//             mask <<=1;
//         }
//         return bits;
//     }
// }

public class Solution {
    public int hammingWeight(int n) {
        int sum = 0;
        while( n !=0) {
            sum++;
            n &=(n-1);
        }
        return sum;
    }
}