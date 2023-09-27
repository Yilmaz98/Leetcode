class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>(); 
        Map<Integer, Integer> right = new HashMap<>();
        
        int maxCount = 0;
        for(int i=0;i<nums.length;i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            maxCount = Math.max(count.get(nums[i]),maxCount);
        }
        
        List<Integer> maxis = new ArrayList<>();
        
        for(Integer key : count.keySet()) {
            if(maxCount == count.get(key)) {
                maxis.add(key);
            }
        }
        
        for(int i=0;i<maxis.size();i++) {
            for(int j=0;j<nums.length;j++) {
                if(left.containsKey(maxis.get(i)) || nums[j] != maxis.get(i))
                    continue;
                left.put(maxis.get(i), j);
            }
            for(int j=nums.length-1;j>=0;j--) {
                if(right.containsKey(maxis.get(i)) || nums[j] != maxis.get(i))
                    continue;
                right.put(maxis.get(i), j);
            }
        }
                        
        int result = Integer.MAX_VALUE;
        
        for(int i=0;i<maxis.size();i++) {
            result = Math.min(result, Math.abs(right.get(maxis.get(i)) - left.get(maxis.get(i))) + 1);
        }
        
        return result;
    }
}