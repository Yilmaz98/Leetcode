//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[S] = 0;
         
        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
        
        for(int i = 0;i<adj.size();i++) {
            if(!m.containsKey(i)) {
                m.put(i, new HashMap<>());
            }
            ArrayList<ArrayList<Integer>> neis = adj.get(i);
            for(int j = 0;j<neis.size();j++) {
                   for(int k = 0;k<neis.get(j).size();k++) {
                       m.get(i).put(neis.get(j).get(0), neis.get(j).get(1));
                   }
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{S,0});
        
        
        Set<Integer> visited = new HashSet<>();
        
        while(!pq.isEmpty()) {
            int size = pq.size();
            for(int k = 0;k<size;k++) {
                int[] curr = pq.poll();
                
                visited.add(curr[0]);
                
                for(Integer nei : m.get(curr[0]).keySet()) {
                    int d = m.get(curr[0]).get(nei);
                    
                    if(dist[curr[0]] + d < dist[nei] && !visited.contains(nei)) {
                        dist[nei] = dist[curr[0]] + d;
                        pq.add(new int[]{nei, dist[nei]});
                    }
                }
            }
        }
        
        return dist;
    }
}

