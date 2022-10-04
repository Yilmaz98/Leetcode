class Node {
    Integer val;
    List<Integer> path = new ArrayList<>();
    
    Node(int ni, List<Integer> arr) {
        val = ni;
        path = arr;
    }
}

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i=0;i<graph.length;i++) {
            adj.put(i , new ArrayList<>());
            
            for(int node : graph[i]) {
                adj.get(i).add(node);
            }
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.val - b.val);
        List<Integer> start = new ArrayList<>();
        start.add(0);
        q.add(new Node(0, start));
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        List<List<Integer>> result = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
            Node current = q.poll();
            List<Integer> currPath = current.path;
                
            if(current.val == n-1) {
                result.add(currPath);
            }
            
            List<Integer> neighbours = adj.get(current.val);
            for(int i=0;i<neighbours.size();i++) {
                if(!visited.contains(neighbours.get(i))) {
                    currPath = new ArrayList<>(current.path);
                    currPath.add(neighbours.get(i));
                    q.add(new Node(neighbours.get(i), currPath));
                }
            }                  
            }
        }
        
        return result;
    }
}