class Solution {
      public boolean isBoomerang(int[][] p) {
        int firstSlope =  (p[1][1] - p[0][1]) * (p[2][0] - p[1][0]);
        int secondSlope = (p[2][1] - p[1][1]) * (p[1][0] - p[0][0]);
          
        return firstSlope != secondSlope;
    }
}