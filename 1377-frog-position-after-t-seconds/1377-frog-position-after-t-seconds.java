class Solution {
    public class TreeNode {
        int val;
        double probability;
        
        TreeNode(int val, double probability){
            this.val = val;
            this.probability = probability;
        }
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int[] edge: edges) {
            if(!adj.containsKey(edge[0]))
                adj.put(edge[0], new ArrayList<>());
            if(!adj.containsKey(edge[1]))
                adj.put(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        if(adj.isEmpty())
            return 1.0;
        
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        TreeNode root = new TreeNode(1,1.0);
        q.add(root);
        visited.add(1);
        
        int time = 0;
        
        //System.out.println(adj);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                //System.out.println(curr.val + " " + curr.probability + " " + time);

                if(curr.val == target) {
                    if(time==t)
                        return curr.probability;
                    else if(time > t)
                        return 0.0;
            for(int j=0;j<adj.get(curr.val).size();j++) {
                if(!visited.contains(adj.get(curr.val).get(j))) {
                       return 0.0;
                    }
                }
                    return curr.probability;
                }
                
                if(!adj.containsKey(curr.val)) {
                    continue;
                }
                
                int nSize = adj.get(curr.val).size();
                
                for(int j=0;j<adj.get(curr.val).size();j++) {
                if(visited.contains(adj.get(curr.val).get(j))) {
                       nSize--;
                       continue;
                }
                 
                    TreeNode neighbour = new TreeNode(adj.get(curr.val).get(j),curr.probability/nSize);

                    q.add(neighbour);
                    visited.add(adj.get(curr.val).get(j));
                }

            }
            time++;
        }
        
        return 0.0;
    }
}