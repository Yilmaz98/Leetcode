//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color = new int[V+1];
        boolean[] visited = new boolean[V+1];
        
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                color[i] = 0;
                visited[i] = true;
                if(!check(adj, i, color, 0, visited)) {
                    return false; 
                }
            }
        }
        
        return true;
    }
    
    public boolean check(ArrayList<ArrayList<Integer>> adj, int src, int[] color, int prevColor, boolean[] visited) {
        for(Integer nei : adj.get(src)) {
            if(!visited[nei]) {
                visited[nei] = true;
                color[nei] = 1 - prevColor;
                if(!check(adj, nei, color, color[nei], visited))
                    return false;
            } else {
                if(color[nei] == color[src]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}