
class Solution {
    public boolean searchMatrix(int[][] maxtrix,int target) {
        int m = maxtrix.length;
        if (m == 0) return false;
        int n = maxtrix[0].length;
    
        int left = 0,right = m * n - 1;
        int pivotIdx,pivotElement;
        while(left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = maxtrix[pivotIdx / n][pivotIdx % n];
            if(target == pivotElement) return true;
            else {
                if(target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }
}
