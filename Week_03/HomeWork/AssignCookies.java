//

class Solution {
    public findContentChildren(int[] g,int[] s) {
        Array.sort(g);
        Array.sort(s);

        int numOfChildren = g.length,numOfCookies = s.length;
        int count = 0;
        for(int i = 0,j = 0;i < numOfChildren && j < numOfCookies;i++,j++) {
            while( j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                count++;
            }
        }
        return count;
    }
}