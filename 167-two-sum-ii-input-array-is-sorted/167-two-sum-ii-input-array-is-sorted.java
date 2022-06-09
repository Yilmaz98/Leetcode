class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        
        for(int i=0;i<numbers.length;i++) {
               m.put(numbers[i], i); 
        }
        int result[] = new int[2];
        
        for(int i=0;i<numbers.length;i++) {
            if(m.containsKey(target-numbers[i])) {
                result[0] = i+1;
                result[1] = m.get(target-numbers[i])+1;
                return result;
            }
        }
        return result;
    }
}