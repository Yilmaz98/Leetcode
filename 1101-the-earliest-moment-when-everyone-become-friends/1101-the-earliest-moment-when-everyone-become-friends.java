class UnionFind {
    int[] parent;
    int[] sizes;
    int components;
    
    UnionFind(int n) {
        parent = new int[n];
        sizes = new int[n];
        components = n;
        
        for(int i=0;i<n;i++) {
            parent[i] = i;
            sizes[i] = 1; 
        }
    }
    
    public int find(int a) {
        if(parent[a] == a)
            return a;
        
        return find(parent[a]);
    }
    
    public boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);
        
        if(x == y)
            return false;
        
        components--;
        
        if(sizes[x] >= sizes[y]) {
            parent[y] = x;
            sizes[x]++;
        } else {
            parent[x] = y;
            sizes[y]++;
        }
        return true;
    }
}

class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a,b) -> a[0] - b[0]);
        
        UnionFind uf = new UnionFind(n);
        
        for(int[] log : logs) {
            uf.union(log[1], log[2]);
            
            if(uf.components == 1) {
                return log[0];
            }
        }
        
        return -1;
    }
}