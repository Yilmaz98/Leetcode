class Solution {
    
    class Node {
        Integer node;
        Integer weight;
        
        Node(Integer node, Integer weight) {
            this.node = node;
            this.weight = weight;
        }
    };
    
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Node>> adj = new HashMap<>();
        
        for(int[] time: times) {
            if(!adj.containsKey(time[0]))
                adj.put(time[0], new ArrayList<>());
            
            adj.get(time[0]).add(new Node(time[1], time[2]));
        }
        
        Queue<Node> q = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        Set<Integer> visited = new HashSet<>();
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        q.add(new Node(k,0));
        dist[k] = 0;
        
        int res = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                Node curr = q.poll();
                visited.add(curr.node);    
            
                if(!adj.containsKey(curr.node))
                    continue;

                for(Node nbr : adj.get(curr.node)) {
                    if(dist[nbr.node] > (dist[curr.node] + nbr.weight))                      {
                        dist[nbr.node] = dist[curr.node] + nbr.weight;
                        q.add(nbr);
                    }   
                }
            }
        }
        
        for(int i=1;i<dist.length;i++) {
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            res = Math.max(res, dist[i]);
        }
        
        return res;
    }
}