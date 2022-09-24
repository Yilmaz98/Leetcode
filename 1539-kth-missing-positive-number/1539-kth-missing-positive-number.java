class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing = 0;
        int start = 1;
        
        Set<Integer> s = new HashSet<>();
        for(int c : arr) {
            s.add(c);
        }
        
        while(true) {
            if(!s.contains(start)) {
                missing++;
            }
            
            if(missing == k) {
                return start;
            }
            start++;
        }
    }
}