//使用回溯法求该值

// class Solution {
//     public int robotSim(int[] commands, int[][] obstacles) {
//         int result = 0;
//         int x = 0,y = 0,direction = 0;

//         int[] directX = new int[]{0,1,0,-1};
//         int[] directY = new int[]{1,0,-1,0};

//         Set<String> obstaclesSet = new HashSet<String>();
//         for(int i = 0; i < obstacles.length;i++) {
//             obstaclesSet.add(obstacles[i][0] + "," + obstacles[i][1]);
//         }
//         for(int com: commands) {
//             if(com == -2) {
//                 direction = (direction + 3) % 4;
//             } else if(com == -1) {
//                 direction = (direction + 1) % 4;
//             }else {
//                 for(int i = 1;i <=com;i++) {
//                     int newX = x + directX[direction];
//                     int newY = y + directY[direction];
//                     if(obstaclesSet.contains(newX + "," + newY)) {
//                         break;
//                     }
//                     x = newX;
//                     y = newY;
//                     result = Math.max(result,x * x + y * y);
//                 }
//             }

//         }
//         return result;
//     }  
// }

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;
        int x = 0, y = 0, direction = 0;
        int[][] xy = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // 用 set 存储障碍物的坐标
        Set<String> obstaclesSet = new HashSet<String>();
        for (int[] obs : obstacles) {
            obstaclesSet.add(obs[0] + "," + obs[1]);
        }

        for (int com : commands) {
            if (com == -2) {
                // turn left
                direction = (direction == 0) ? 3 : direction - 1;
            } else if (com == -1) {
                // turn right
                direction = (direction == 3) ? 0 : direction + 1;
            } else {
                // 没有遇到障碍物，一直往前走 com 个单位长度
                while (com-- > 0 && !obstaclesSet.contains((x + xy[direction][0]) + "," + (y + xy[direction][1]))) {
                    x += xy[direction][0];
                    y += xy[direction][1];
                }
                // 最大欧式距离的平方
                // 这里放在 while 循环的外面，是因为和上一个前进的指令相比，只能往上下左右四个方向走
                // 如果是往远离原点的方向走，则肯定是最后停下的点最远；如果是往回走，那么 max 就是上一次的 result
                result = Math.max(result, x * x + y * y);
            }
        }
        return result;
    }
}