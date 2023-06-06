class Solution {
    class UnionFind {
        int[] parent;
        int[] size;
        int components;
        
        UnionFind(int n) {
            components = n;
            parent = new int[n];
            size = new int[n];
            
            for(int i=0;i<n;i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int a) {
            if(parent[a] == a)
                return a;
            
            return parent[a] = find(parent[a]);
        }
        
        public void union(int a, int b) {
            int x = find(a);
            int y = find(b);
            
            if(x == y)
                return;
            
            if(size[x] <= size[y]) {
                     parent[y] = x;
                size[x]+=1;
            }
           
            else {
                parent[x] = y;
                size[y] +=1;
            }
                
            
            components--;
        }
    };
    
    
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        UnionFind uf = new UnionFind(m);
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<m;j++) {
                if(i!= j && isConnected[i][j] == 1) {
                    uf.union(i,j);
                }
            }
        }
        
        return uf.components;
    }
}