class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0; int right = height.length - 1; // Pointers to both ends of the array.
        int maxLeft = 0; int maxRight = 0;
        
        int totalWater = 0;
        while (left < right) {
            // Water could, potentially, fill everything from left to right, if there is nothing in between.
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) { 
                    maxLeft = height[left]; 
                } else { 
                    totalWater += maxLeft - height[left]; 
                }
                left++;
            } else {
                if (height[right] >= maxRight) { 
                    maxRight = height[right]; 
                } else {
                    totalWater += maxRight - height[right]; 
                }
                right--;
            }
        }
        return totalWater;
    }
}