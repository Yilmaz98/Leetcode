class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            m.put(nums[i], m.getOrDefault(nums[i],0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]  - a[1]);
        
        for(Integer i : m.keySet()) {
            pq.add(new int[]{i, m.get(i)});
        }
        
        int[] ans = new int[k];
        
        int idx = 0;
        while(k>0) {
            ans[idx++] = pq.poll()[0];
            k--;
        }
        
        return ans;
    }
}