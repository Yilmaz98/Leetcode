class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            m.put(nums[i],i);
        }
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++) {
            if(m.containsKey(target-nums[i]) && (m.get(target-nums[i]) != i)) {
                result[0] = i;
                result[1] = m.get(target-nums[i]);
                break;
            }
        }
        return result;
    }
}