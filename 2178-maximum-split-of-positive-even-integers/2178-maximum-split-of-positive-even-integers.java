class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum % 2 != 0)
            return new ArrayList<>();
        
        LinkedList<Long> result = new LinkedList<>();
        
        long i = 2;
        
        while(i<= finalSum) {
            System.out.println(i);
            result.add(i);
            finalSum -=i;
            i+=2;
        }
        
        result.add(finalSum + result.pollLast());
        
        return result;
    }
}