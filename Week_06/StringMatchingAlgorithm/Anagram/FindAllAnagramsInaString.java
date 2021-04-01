/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".



*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int len1 = s.length(), len2 = p.length();
		if (len2 > len1)
			return result;
		
		int[] anagram = new int[26];
		for (int i = 0; i < len2; ++i) 
		{
			anagram[p.charAt(i)-'a']++;
			anagram[s.charAt(i)-'a']--;
		}
		if(allZero(anagram))
		{
			result.add(0);
		}
		for (int i = len2 ; i < len1; ++i) 
		{
			//System.out.println(i);
			anagram[s.charAt(i) - 'a']--;
			anagram[s.charAt(i - (len2 )) - 'a']++;
			if(allZero(anagram))
			{
				result.add(i-len2 + 1);
			}
		}
		//System.out.println(result);
		return result;
	}
    public boolean allZero(int[] freq)
	{
		for(int i=0;i<26;i++)
		{
			if(freq[i]!=0)
				return false;
		}
		return true;
	}
}