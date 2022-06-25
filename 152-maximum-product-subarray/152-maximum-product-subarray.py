class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        ans = nums[0]
        maxi = nums[0]
        mini = nums[0]
        
        for i in range(1, len(nums)):
            temp = maxi
            maxi = max(nums[i], max(mini * nums[i], maxi * nums[i]))
            mini = min(nums[i], min(mini * nums[i], temp * nums[i]))
            
            ans = max(ans,maxi)
            
        return ans