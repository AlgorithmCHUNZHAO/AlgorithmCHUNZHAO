// 1.使用栈和ASCII解决没想到，很妙
// public boolean isValid(String s) {
//     Deque<Integer> d = new ArrayDeque<>();
//     for (int i = 0; i < s.length();i++) {
//         char c = s.charAt(i);
//         int u = c - '0';
//         if(c == '(' || c == '{' || c == '[' ) {
//             d.addLast(u);
//         } else {
//             if (!d.isEmpty && Math.abs(d.peekLast() - u) <=2) {
//                 d.pollLast();
//             } else {
//                 return false;
//             }
//         }
//         return d.isEmpty();
//     }
// }

class Solution {
    HashMap<Character,Character> map = new HashMap<Character,Character>() {{
        put(']','[');
        put('}','{');
        put(')','(');
    }};
    public boolean isValid(String s) {
        Deque<Character> d = new ArrayDeque<>();
        for(int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                d.addLast(c);
            } else {
                if (!d.isEmpty() && d.peekLast() == map.get(c)) {
                    d.pollLast();
                } else {
                    return false;
                }
            }
        }
        return d.isEmpty();
    }
}