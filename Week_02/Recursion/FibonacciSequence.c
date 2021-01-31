//1 F(n) = n;n = 0,1;
//F(n) = F(n-1) + F(n-2),n >=2;

#include<stdio.h>
#include<stdlib.h>
unsigned long fibo(unsigned long int n);




int main(int argc,char *argv[])
{
    if(1 >= argc)
    {
        printf("usage:./fibo numn");
        return -1;
    }
    unsigned long n = atoi(argv[1]);
    unsigned long fiboNum = fibo(n);
    printf("the %lu result is %lun",n,fiboNum);
    return 0;
}
//1.递归调用
// unsigned long fibo(unsigned long int n)
// {
//     if( n <=1)
//         return n;
//     else
//     {
//         return fibo(n-1) + fibo(n-2);
//     }
    
// }
//2.迭代解法
// unsigned long fibo(unsigned long n)
// {
//     unsigned long preVal = 1;
//     unsigned long prePreVal = 0;
//     if(n <=2)
//         return n;
//     unsigned long loop = 1;
//     unsigned long returnVal = 0;
//     while (loop < n)
//     {
//         returnVal = preVal +prePreVal;
//         prePreVal = preVal;
//         preVal = returnVal;
//         loop++; 
//     }
//     return returnVal;
// }
//尾递归
unsigned long fiboProcess(unsigned long n,unsigned long prePreVal,unsigned long preVal,unsigned long begin)
{
    if(n == begin)
        return preVal + prePreVal;
    else
    {
        begin++;
        return fiboProcess(n,preVal,prePreVal,begin);
    }
}

unsigned long fibo(unsigned long n)
{
    if(n <=1)
        return n;
    else
    {
        return fiboProcess(n,0,1,2);
    }
    
}