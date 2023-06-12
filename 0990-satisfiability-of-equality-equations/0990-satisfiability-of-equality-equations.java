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
            
            return a = find(parent[a]);
        }
        
        public void union(int a, int b) {
            int x = find(a);
            int y = find(b);
            
            if(x == y)
                return;
            
            if(size[x] >= size[y]) {
                parent[y] = x;
                size[x] +=1;
            } else {
                parent[x] = y;
                size[y] += 1;
            }
            components--;
        }
    };
    
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for(String equation: equations) {
            if(equation.charAt(1) == '=') {
                uf.union(equation.charAt(0) -'a', equation.charAt(3) - 'a');
            }
        }  
        
        System.out.println(uf.components);
        
         for(String equation: equations) {
            if(equation.charAt(1) == '!') {
               if(uf.find(equation.charAt(0) -'a') == uf.find(equation.charAt(3) -'a'))
                   return false;
            }
        }
        
        return true;
        
    }
}