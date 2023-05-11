/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i != j) {
                    if(knows(i,j)) {
                        indegree[j]++;
                        outdegree[i]++;
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++) {
            if(indegree[i] == n-1 && outdegree[i] == 0)
                return i;
        }
        
        return -1;
    }
}