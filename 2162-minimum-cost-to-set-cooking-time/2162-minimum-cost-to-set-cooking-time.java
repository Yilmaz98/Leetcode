class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
            int finalCost = 0;
         char start = String.valueOf(startAt).charAt(0);
        
            int roundMins = targetSeconds/60;
            int roundSecs = targetSeconds%60;
            
            int minusMins = roundMins;
            int minusSecs = roundSecs;  
            
            if(roundSecs < 40) {
              minusMins = roundMins - 1;
              minusSecs = roundSecs + 60;   
            }
           
            
            String roundStr = String.valueOf(roundMins*100+roundSecs);
            String minusStr = String.valueOf(minusMins*100+minusSecs);
            
            if(start != roundStr.charAt(0))
               finalCost += moveCost;
            
            for(int i=0;i<roundStr.length()-1;i++) {
                if(roundStr.charAt(i) != roundStr.charAt(i+1))
                    finalCost += moveCost;
                finalCost += pushCost;
            }
            finalCost += pushCost;
            
            int finalCost2 = 0;
            
            if(start != minusStr.charAt(0))
               finalCost2 += moveCost;
            
            for(int i=0;i<minusStr.length()-1;i++) {
                if(minusStr.charAt(i) != minusStr.charAt(i+1))
                    finalCost2 += moveCost;
                finalCost2 += pushCost;
            }
            finalCost2 += pushCost;
            
           if(targetSeconds > 5999)
               return finalCost2;
            
            finalCost = Math.min(finalCost, finalCost2);
        
        return finalCost;
    }
}