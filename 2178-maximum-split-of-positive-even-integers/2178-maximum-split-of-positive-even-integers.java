class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        LinkedList<Long> res = new LinkedList<>();
        if(finalSum % 2!=0)
            return new ArrayList<>();
        long i=2;
        while(finalSum>=i) {
            res.add(i);
            finalSum -=i;
            i+=2;
        }
        
        if(finalSum>0 && (finalSum) %2==0){
            res.add(res.pollLast() + finalSum);   
        }

        return res;
    }
}