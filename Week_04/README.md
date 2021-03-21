## 学习笔记

### 递归代码模板
```
public void recur(int level,int param) {
    
    //teminator
    if(level > MAX_LEVEL) {
        //process result
        return 

    }
    // process current logic
    process(level,param);
    //drill down 
    recur(level:level + 1,newParam);
    // restore current status
}
```

### 动态规划的关键点
#### 1.最优子结构 
`
opt[n] = best_of[opt[n-1],opt[n-2]]
`
#### 2.存储中间状态

`
opt[i]
`
#### 3.递归公式

`
Fib:opt[i] = opt[n-1] + opt[n-2]
`
#### 

