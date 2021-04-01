/*
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. 
If there are less than 2k but greater than or equal to k characters, 
then reverse the first k characters and left the other as original.

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"

*/



// class Solution {
//     public String reverseStr(String s, int k) {
//         char[] ch = s.toCharArray();
//         for (int i = 0; i < ch.length; i += 2 * k) {
//             rev(ch, i, i + k);
//         }
//         return String.valueOf(ch);
//     }
    
//     private void rev(char[] ch, int i, int j) {
//         j = Math.min(ch.length, j) - 1;
//         for (; i < j; i++, j--) {
//             char tmp = ch[i];
//             ch[i] = ch[j];
//             ch[j] = tmp;
//         }
//     }
// }
class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        
        for(int i=0; i<c.length; i += 2*k) {
            int j = i+k-1;
            int idx = i;
            if(j < c.length) {
                reverse(idx, j, c);
            } else {
            	j = c.length - 1;
            	reverse(idx, j, c);
            }
        }
        return String.valueOf(c);
    }
	
	private void reverse(int idx, int j, char[] c) {
		while(idx <= j) {
            char temp = c[idx];
            c[idx] = c[j];
            c[j] = temp;
            idx++;
            j--;
        }
	}
}




