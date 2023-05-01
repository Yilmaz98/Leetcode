class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int i;
        for(i = 0; i < dist.length; i++)
            dist[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        
        Arrays.sort(dist);
        
        for(i = 0; i < dist.length; i++) {
           if(dist[i] <= i) {
                break;
            } 
        }
            
        return i;
    }
}