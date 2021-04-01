import java.util.Arrays;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false


*/

class Solution {
    public boolean isAnagram(String s,String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}

class Solution1 {
    public boolean isAnagram(String s,String t) {
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length();i++) alphabet[s.charAt(i)-'a']++;
        for(int i = 0; i < t.length();i++) alphabet[t.charAt(i)-'a']--;
        for (int i: alphabet) if (i != 0)return false;
        return true;
    }
}