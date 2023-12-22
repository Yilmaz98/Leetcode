//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int[] edge: edges) {
		    if(!m.containsKey(edge[0])) {
		        m.put(edge[0], new HashMap<>());
		    }
		    m.get(edge[0]).put(edge[1], edge[2]);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
		pq.add(new int[]{0, 0});
		
		dist[0] = 0;
		
		while(!pq.isEmpty()) {
		    int[] curr = pq.poll();
		    
		    if(!m.containsKey(curr[0]))
		        continue;
		    
		    for(Integer nei : m.get(curr[0]).keySet()) {
		        int d = m.get(curr[0]).get(nei);
		        
		        if(dist[curr[0]] + d < dist[nei]) {
		            dist[nei] = dist[curr[0]] + d;
		            pq.add(new int[]{nei, dist[nei]});
		        }
		    }
		}
		
		for(int i=0;i<dist.length;i++) {
	        if(dist[i] == Integer.MAX_VALUE)
	            dist[i] = -1;
		}
	
		return dist;
	}
}