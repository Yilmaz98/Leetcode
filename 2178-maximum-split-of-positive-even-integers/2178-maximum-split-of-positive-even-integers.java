class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        
        if(finalSum %2 !=0)
            return new ArrayList<>();
        
        long cur = 2;
        while(finalSum > 0) {
            result.add(cur);
            finalSum -=cur;
            cur+=2;
        }
        
        //System.out.println(result);
        
        if(finalSum < 0) {
            long last = result.get(result.size()-1);
            long prev = result.get(result.size()-2);
            
            long fin = prev + last + finalSum;
            
            result.remove(result.size()-1);
            result.remove(result.size()-1);
            
            result.add(fin);
        }
        
        return result;
    }
}