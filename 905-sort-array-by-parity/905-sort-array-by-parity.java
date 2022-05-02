class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int j=0;
        
        for(int i=1;i<nums.length;i++) {
            while(j< nums.length && nums[j]%2==0){
                j++;
            }
            if(j >= i)
                continue;
            if(nums[i]%2 == 0 && j< nums.length) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;  
                    j++;
            }
        }
        
        return nums;
    }
}