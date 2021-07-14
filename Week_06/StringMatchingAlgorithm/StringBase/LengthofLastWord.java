/*
Given a string s consists of some words separated by spaces, 
return the length of the last word in the string. If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Example 2:

Input: s = " "
Output: 0

*/
class Solution {
    public int lengthOfLastWord(String s) {
        int lastLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && lastLen > 0) {
                return lastLen;
            } else if (s.charAt(i) != ' ') {
                lastLen++;
            }
        }
        return lastLen;
    }
}



