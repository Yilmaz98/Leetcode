class Solution {
    class UnionFind {
        int[] parent;
        int[] size;
        int components;
        int extraEdges;
        
        UnionFind(int n) {
            components = n;
            extraEdges = 0;
            parent = new int[n];
            size = new int[n];
            
            for(int i=0;i<n;i++) {
                parent[i] = i;
                size[i]  =1;
             }
        }
        
        
        public int find(int a) {
            if(parent[a] == a)
                return a;
            
            return a = find(parent[a]);
        }
        
        public void union(int a, int b) {
            int x = find(a);
            int y = find(b);
            
            if(x == y) {
                extraEdges++;
                return;
            }
                
            
            if(size[x] >= size[y]) {
                parent[y] = x;
                size[x] +=1; 
            } else {
                parent[x] = y;
                size[y] +=1;
            }
            components--;
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        for(int[] connection : connections) {
            uf.union(connection[0], connection[1]);
        }
        
        return uf.extraEdges <  uf.components - 1 ? -1: uf.components - 1;
    }
}