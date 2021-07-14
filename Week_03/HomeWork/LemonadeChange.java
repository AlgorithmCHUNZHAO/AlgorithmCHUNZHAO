//通过常识来分析找零钱，得出不同情况的应对方式不一样。

class Solution {
    // public boolean lemonadeChange(int[] bills) {
    //     int five = 0,ten = 0;
    //     for(int bill:bills) {
    //         if(bill == 5) {
    //             five++;
    //         } else if(bill == 10) {
    //             five--;
    //             ten++;
    //         } else if (ten > 0) {
    //             ten--;
    //             five--;
    //         } else {
    //             five -=3;
    //         }
    //         if (five < 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
}

