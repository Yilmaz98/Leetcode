class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
       Map<String, Set<String>> adj = new HashMap<>();
       Map<String, Integer> indegree = new HashMap<>();
        
        for(int i=0;i<recipes.length;i++) {
            adj.put(recipes[i], new HashSet<>());
            adj.get(recipes[i]).addAll(ingredients.get(i));
            if(i<ingredients.size()) {
                   indegree.put(recipes[i], indegree.getOrDefault(recipes[i],0)+ adj.get(recipes[i]).size());
            }
        }
        
        Queue<String> q = new LinkedList<>();
        
        for(String s : supplies) {
            q.add(s);
        }
        List<String> result = new ArrayList<>();
        
        while(!q.isEmpty()) {
            String curr = q.poll();
            
            for(String s: adj.keySet()) {
                if(adj.get(s).contains(curr)) {
                    indegree.put(s,indegree.get(s)-1);
                    if(indegree.get(s) == 0) {
                        q.add(s);
                        result.add(s);
                    }
                }
            }
        }
        
        
        return result;
    }
}