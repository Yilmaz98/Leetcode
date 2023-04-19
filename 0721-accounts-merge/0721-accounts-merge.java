class Solution {
    class UnionFind {
        int[] parents;
        int[] sizes;
        
        UnionFind(int components) {
            parents = new int[components];
            sizes = new int[components];
            
            for(int i=0;i<components;i++) {
                parents[i] = i;
                sizes[i] = 1;
            }            
        }
        
        public int find(int v) {
            if(v == parents[v])
                return v;
            
            return parents[v] = find(parents[v]);
        }
        
        public void union(int a, int b) {
            int u = find(a);
            int v = find(b);
            
            if(u == v)
                return;
            
            if(sizes[u] >= sizes[v]) {
                sizes[u] += sizes[v];
                parents[v] = u;
            } else {
                sizes[v] += sizes[u];
                parents[u] = v;
            }
        }
    }
    
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailMap = new HashMap<>();
        UnionFind u = new UnionFind(accounts.size());
        
        for(int i=0;i<accounts.size();i++) {
           for(int j=1;j<accounts.get(i).size();j++) {
               String currEmail = accounts.get(i).get(j);
               
               if(!emailMap.containsKey(currEmail)) {
                   emailMap.put(currEmail, i);
               } else {
                   u.union(emailMap.get(currEmail),i);
               }
           }
        }
        
        
        Map<Integer, List<String>> groups = new HashMap<>();
        
        for(String email : emailMap.keySet()) {
            int grp = emailMap.get(email);
            int supergroup = u.find(grp);
            
            if(!groups.containsKey(supergroup)) {
                groups.put(supergroup, new ArrayList<String>());
            }
            
            groups.get(supergroup).add(email);
        }
        
        List<List<String>> result = new ArrayList<>();
        
        for(Integer curr : groups.keySet()) {
            String name = accounts.get(curr).get(0);
            List<String> emails = new ArrayList<>();
            emails = groups.get(curr);
            Collections.sort(emails);
            emails.add(0, name);
            result.add(emails);
        }
        
        return result;
    }
}