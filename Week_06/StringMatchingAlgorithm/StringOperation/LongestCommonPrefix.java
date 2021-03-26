/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


*/


class Solution {
    // public String longestCommonPrefix(String[] strs) {
    //     if(strs == null || strs.length == 0)    return "";
    //     String pre = strs[0];
    //     int i = 1;
    //     while(i < strs.length){
    //         while(strs[i].indexOf(pre) != 0)
    //             pre = pre.substring(0,pre.length()-1);
    //         i++;
    //     }
    //     return pre;
    // }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
        return pre;
    }



}