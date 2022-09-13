class Solution {
    public boolean checkLeadingDiagonal(char[][] matrix) {
        return (matrix[0][0] == matrix[1][1]) && (matrix[1][1] == matrix[2][2]) && (matrix[0][0] == matrix[2][2]);
    }
    
    public boolean checkAntiDiagonal(char[][] matrix) {
        return (matrix[0][2] == matrix[1][1]) && (matrix[1][1] == matrix[2][0]) && (matrix[0][2] == matrix[2][0]);
    }
    
    public boolean checkRow(int row, char[][] matrix) {
        return (matrix[row][0] == matrix[row][1]) && (matrix[row][1] == matrix[row][2]) && (matrix[row][0] == matrix[row][2]);
    }
    
    public boolean checkColumn(int column, char[][] matrix) {
        return (matrix[0][column] == matrix[1][column]) && (matrix[1][column] == matrix[2][column]) && (matrix[0][column] == matrix[2][column]);
    }
    
    
    public String tictactoe(int[][] moves) {
        char[][] matrix = new char[3][3];
              
        int i = 0;
        for(int[] move : moves) {
            i++;
            matrix[move[0]][move[1]] = i%2 != 0 ?'X' : 'O';
            if(checkRow(move[0] ,matrix) || checkColumn(move[1], matrix))
                return i%2!=0 ? "A" : "B";
            
            if(move[0] == move[1]) {
                if(checkLeadingDiagonal(matrix))
                     return i%2!=0 ? "A" : "B";
            }
            if(move[0] + move[1] == 2){
                if(checkAntiDiagonal(matrix))
                     return i%2!=0 ? "A" : "B";
            }
        }
        
        if(moves.length < 9)
            return "Pending";
        
        return "Draw";
        
    }
}