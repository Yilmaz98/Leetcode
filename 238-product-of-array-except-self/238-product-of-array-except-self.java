class Solution {
    
    public void print(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i] + " ");
        }
        
        System.out.println();
    }
    
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int first = 1;
        for(int i=0;i<nums.length;i++) {
            first *= nums[i];
            prefix[i] = first;
        }
        
        int[] suffix = new int[nums.length];
        first = 1;
        for(int i=nums.length-1;i>=0;i--) {
            first *= nums[i];
            suffix[i] = first;
        }
         int[] result = new int[nums.length];
        
          for(int i=0;i<nums.length;i++) {
            if(i == 0) {
                result[i] = suffix[i+1];
            }
            else if(i == nums.length - 1) {
                result[i] = prefix[i-1];
            } 
            else {
                result[i] = prefix[i-1] * suffix[i+1];
            }
        }
        
        return result;
    }
}