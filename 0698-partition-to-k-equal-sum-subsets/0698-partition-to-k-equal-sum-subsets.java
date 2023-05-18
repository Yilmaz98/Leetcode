class Solution {
    int res = 0;
    
     public void reverseArray(int intArray[]) 
    { 
        int i, k, temp; 
        for (i = 0; i < intArray.length / 2; i++) { 
            temp = intArray[i]; 
            intArray[i] = intArray[intArray.length - i - 1]; 
            intArray[intArray.length - i - 1] = temp; 
        } 
    } 
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
        }
        
        if(sum % k != 0)
            return false;
        
        backtrack(nums, 0, new ArrayList<>(), 0, new boolean[nums.length], sum/k, k);
        return res == 1;
    }
    
    public void backtrack(int[] nums, int start, List<Integer> temp, int sum, boolean[] used, int target, int k) {
        if( k == 1){
            res = 1;
            return;
        }
        
        if(sum == target) {
            backtrack(nums,0, temp, 0, used, target, k-1);
            return;
        }
        
        for(int i=start;i<nums.length;i++) {
            if(used[i] || sum + nums[i] > target) continue;
            //temp.add(nums[i]);
            used[i] = true;
            backtrack(nums,i+1, temp, sum + nums[i], used, target,k);
            //temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}