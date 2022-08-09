class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> tempList = new ArrayList<>();
        LinkedList<Integer> finalRes = new LinkedList<>();
        int[] result = new int[nums.length];
        
        for(int i=nums.length-1; i>=0; i--) {
            result[i] = insert(tempList, nums[i]);
            finalRes.addFirst(result[i]);
        }
        
        return finalRes; 
    }
    
    
    int insert(List<Integer> tempList, int num) {
        int left = 0;
        int right = tempList.size()-1;
        
        while(left <= right) {
            int mid = left + (right-left) /2;
            int midVal = tempList.get(mid);
            
            if(num <= midVal) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        tempList.add(left, num); 
        return left;
    }
}