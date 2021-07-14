/* 
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

*/

class Solution {
    public boolean isAnagram(String s,String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t2);
        for (int i = 0; i< s1.length;i++) {
            if(s1[i] != t2[i]) {
                return false;
            }
        }
        return true;
    }
}


/*
1.首先判断两个字符串的长度是否相等
2.若相等的话，则初始化26个字母的哈希表，遍历字符串s和t
3.最终如果哈希表的值为0，则二者是字母异位词
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }
}

