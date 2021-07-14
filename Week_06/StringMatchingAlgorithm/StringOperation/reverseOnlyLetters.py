class Solution(object):
    def reverseOnlyLetters(slef,S):
        S,i,j = list(S),0,len(S) - 1
        while i < j:
            if not S[i].isalpha():
                i += 1
            elif not S[j].isalpha():
                j -=1
            else:
                S[i],S[j] = S[j],S[i]
                i,j = i+1,j+1
        return "".join(S)

    def reverseOnlyLetters2(self,S):
        i,j = 0,len(S) - 1
        S = list(S)
        while i < j:
            while i < j and not S[i].isalpha(): i += 1
            while i < j and not S[j].isalpha(): j -= 1
            S[i],S[j] = S[j],S[i]
            i,j = i+1,j-1
        return "".join(S)



