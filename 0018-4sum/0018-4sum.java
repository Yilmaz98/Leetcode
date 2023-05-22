class Solution {  
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> triplet = new ArrayList<>();
    
    public void helper(int k, int[] nums,int start, long target) {
        if(k!=2) {
            for(int i= start;i<nums.length - k + 1;i++) {
                if(i>start && nums[i] == nums[i-1])
                    continue;
                triplet.add(nums[i]);
                helper(k-1,nums,i+1, (long)target - nums[i]);
                triplet.remove(triplet.size() - 1);
            }
            return;
        }
        
        int l = start;
        int r = nums.length - 1;
        
        while(l<r) {
            long sum = (long) nums[l] + nums[r];
            if(sum > target) {
                r--;
            } else if(sum < target) {
                l++;
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(triplet);
                newList.add(nums[l]);
                newList.add(nums[r]);
                result.add(newList);
                l++;
                while(l<r && nums[l] == nums[l-1]){
                    l++;
                }
            }
        }
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        helper(4,nums,0,target);
        return result;
    }
}