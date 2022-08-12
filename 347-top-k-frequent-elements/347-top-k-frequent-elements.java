class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            m.put(nums[i], m.getOrDefault(nums[i],0) + 1);
        }
        
        for(Integer i: m.keySet()) {
         q.offer(new int[]{i,m.get(i)});    
        }
        
        int[] ans = new int[k];
        
        for(int i=0;i<k;i++) {
            ans[i] = q.poll()[0];
        }
        
        return ans;
    }
}