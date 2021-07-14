// 1.方法一：对字符串排序，用Hashmap存储值，判断值
// 2.方法二: 通过对字母进行存储，然后进行判断ASCII码判断其字母的个数
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String,List<String>> map = new HashMap<String,List<String>>();
//         for (String str : strs) {
//             char[] array = str.toCharArray();
//             Arrays.sort(array);
//             String key = new String(array);
//             List<String> list = map.getOrDefault(key,new ArrayList<String>());
//             list.add(str);
//             map.put(key,list);
//         }
//         return new ArrayList<List<String>>(map.values());
//     }
// }

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray())
                ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr))
                map.put(keyStr,new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}