class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adj = new HashMap<>();
       Map<String, Integer> indegree = new HashMap<>();
        
        for(int i=0;i<recipes.length;i++) {
            for(int j=0;j<ingredients.get(i).size();j++) {
                if(!adj.containsKey(ingredients.get(i).get(j)))
                    adj.put(ingredients.get(i).get(j), new ArrayList<>());
                adj.get(ingredients.get(i).get(j)).add(recipes[i]);
            }
            indegree.put(recipes[i], indegree.getOrDefault(recipes[i],0)+ ingredients.get(i).size());
        }        
        Queue<String> q = new LinkedList<>();
        
        for(String s : supplies) {
            q.add(s);
        }
        
        List<String> result = new ArrayList<>();
        
        while(!q.isEmpty()) {
            String curr = q.poll();
            
            for(String s : adj.getOrDefault(curr, new ArrayList<>())) {
                    indegree.put(s,indegree.get(s)-1);
                    if(indegree.get(s) == 0) {
                        q.add(s);
                        result.add(s);
                    }
            }
        }
        
        
        return result;
    }
}