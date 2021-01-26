// 字母异位词等价于两个字符串中字符出现的种类和次数均相等。
// 1.方法一：首先对字符串进行排序，然后对两个字符串进行对比看是否相等，通过排序，从而该时间复杂度为NlogN
// 2.方法二：使用哈希表来统计其中一个字符串s，另一个字符串t遍历，对应相应的频次，做出判断。



// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) {
//             return false;
//         }
//         char[] str1 = s.toCharArray();
//         char[] str2 = t.toCharArray();
//         Arrays.sort(str1);
//         Arrays.sort(str2);
//         return Arrays.equals(str1,str2);
//     }
// }


// class Solution {
//     public boolean isAnagram(String s,String t) {
//         if (s.length() != t.length()) {
//             return false;
//         }
//         int[] table = new int[26];
//         for (int i = 0;i < s.length();i++) {
//             table[s.charAt(i) - 'a']++;
//         }
//         for (int i = 0; i < t.length();i++) {
//             table[t.charAt(i) - 'a']++;
//             if (table[t.charAt(i) - 'a'] < 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isAnagram(String s,String t) {
        int[] alphabet = new int[26];
        for( int i = 0; i < s.length();i++) alphabet[s.charAt(i) - 'a']++;
        for( int i = 0; i < t.length();i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
