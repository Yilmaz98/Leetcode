class Solution {
    class UnionFind {
        private int[] parent;
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public void union(int node1, int node2) {
            node1 = find(node1);
            node2 = find(node2);
            if (node1 == node2) return;
            parent[node1] = node2;
        }
        
        public boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }
        
        private int find(int node) {
            if (parent[node] == node) return node;
            return parent[node] = find(parent[node]);
        }
    }
    
	// check from 8 directions
    private int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = row * col + 2;
		// set left and right bound dummy nodes
        int leftBound = n - 2, rightBound = n - 1;
        int[][] matrix = new int[row][col];
        
        UnionFind uf = new UnionFind(n);
        
        for (int day = 0; day < cells.length; day++) {
            int waterRow = cells[day][0] - 1;
            int waterCol = cells[day][1] - 1;
            
            matrix[waterRow][waterCol] = 1;
            if (waterCol == 0) uf.union(leftBound, waterRow * col + waterCol);
            if (waterCol == col - 1) uf.union(rightBound, waterRow * col + waterCol);
            for (int i = 0; i < dx.length; i++) {
                int neighborRow = waterRow + dx[i];
                int neighborCol = waterCol + dy[i];
                if (!isValid(row, col, neighborRow, neighborCol) || matrix[neighborRow][neighborCol] != 1) continue;
                uf.union(waterRow * col + waterCol, neighborRow * col + neighborCol);
            }
            

            if (uf.isConnected(leftBound, rightBound)) return day;
        }
        
        return -1;
    }
    
    private boolean isValid(int rowSize, int colSize, int row, int col) {
        return row >= 0 && row < rowSize && col >= 0 && col < colSize;
    }
}