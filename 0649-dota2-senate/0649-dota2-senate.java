class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        
        Queue<Integer> dQueue = new LinkedList<>();
        Queue<Integer> rQueue = new LinkedList<>();
        
        for(int i=0;i<n;i++) {
            if(senate.charAt(i) == 'R')
                rQueue.add(i);
            else 
                dQueue.add(i);
        }
        
        while(!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rTurn = rQueue.poll();
            int dTurn = dQueue.poll();
            
            if(rTurn < dTurn) {
                rQueue.add(rTurn + n);
            } else 
                dQueue.add(dTurn + n);
        }
        
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}