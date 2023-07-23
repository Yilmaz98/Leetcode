class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] arr = new double[query_row+2][query_row+2];
        arr[0][0] = (double) poured;
        for(int i=0;i<=query_row;i++) {
            for(int j=0;j<=i;j++) {
                double excess = (arr[i][j] - 1)/2.0;
                
                if(excess>0) {
                    arr[i+1][j] += excess;
                    arr[i+1][j+1] += excess; 
                }
            }
        }

        return Math.min(1,arr[query_row][query_glass]);
    }
}