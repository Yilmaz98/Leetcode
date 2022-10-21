class Solution {
     class UnionFind {
        int[] parent;
        int[] size;
        int components;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ)
                return;
            if (size[rootI] <= size[rootJ]) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
            else {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            }
            components --;
        }

        public boolean connected(int i, int j) {
            return find(i) == find(j);
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges) {
            uf.union(edge[0],edge[1]);
        }
        
        return uf.components;
    
    }
}