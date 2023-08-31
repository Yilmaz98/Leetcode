class Solution {
    
    public void fillRow(int[][] matrix, Set<Integer> rows, int r, int cols) {
        for(int i=0;i<cols;i++) {
            matrix[r][i] = 0;
        }
    }
    
    public void fillCol(int[][] matrix, Set<Integer> cols, int c,  int rows) {
         for(int i = 0;i<rows;i++) {
            matrix[i][c] = 0;
        }
    }
    
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int i=0;i<m;i++) {
            if(rows.contains(i)) {
                fillRow(matrix,rows, i, n);
            }
        }
        
        for(int j=0;j<n;j++) {
            if(cols.contains(j)) {
                fillCol(matrix,cols, j, m);
            }
        }
    }
}