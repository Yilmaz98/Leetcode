class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        recurse(nums, 0, 3, new ArrayList<>(), result, 0);
        
        return result;
    }
    
    public void recurse(int[] nums, int start, int k, List<Integer> tempList, List<List<Integer>> result, int sum) {
        if(k != 2) {
            for(int i = start;i<nums.length - k + 1;i++) {
                if(i > start && nums[i] == nums[i-1])
                    continue;
                    tempList.add(nums[i]);
                    recurse(nums, i + 1, k-1, tempList, result, sum + nums[i]);
                    tempList.remove(tempList.size() - 1);
            }
            return;
        }
        
        int low = start;
        int high = nums.length - 1;
        
        while(low < high) {
            int total = nums[low] + nums[high] + sum;
            
            if(total > 0) {
                high--;
            } else if(total < 0) {
                low++;
            } else {
                List<Integer> curr = new ArrayList<>();
                curr.add(nums[low]);
                curr.add(nums[high]);
                
                for(int i=0;i<tempList.size();i++) {
                    curr.add(tempList.get(i));
                }
                
                result.add(new ArrayList<>(curr));
    
                low++;
                while(low < high && nums[low] == nums[low - 1]) {
                    low++;
                }
            } 
         }
    }
}