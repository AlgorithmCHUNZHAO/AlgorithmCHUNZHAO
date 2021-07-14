from collections import Counter

def findAnagrams(self,s,p):
    res = []
    pCounter = Counter(p)
    sCounter = Counter(s[:len(p)-1])
    for i in range(len(p)-1,len(s)):
        sCounter[s[i]] += 1
        if sCounter == pCounter:
            res.append(i-len(p)+1)
        sCounter[s[i-len(p)+1]] -= 1
        if sCounter[s[i-len(p)+1]] == 0:
            del sCounter[s[i-len(p)+1]]
    return res



def findAnagrams(self, s: str, p: str) -> List[int]:
        pC = collections.Counter(p)
        res = []
        window = None
        for i in range(len(s)-len(p)+1):
            if i==0: 
                window = collections.Counter(s[i:i+len(p)])
            else:
                minus = {s[i-1]:1}
                plus = {s[i+len(p)-1]:1}
                window -=minus
                window += plus
            if pC==window: res.append(i)
        return res