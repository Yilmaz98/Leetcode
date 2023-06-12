class Solution {
    public int trap(int[] height) {
        int maxIndex = 0;
        int maxHeight = Integer.MIN_VALUE;
        
        for(int i=0;i<height.length;i++) {
            if(maxHeight < height[i]) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        
        int leftMax = height[0];
        int leftAns = 0;
        
        for(int i=1;i<=maxIndex;i++) {
            if(leftMax >= height[i]) {
                leftAns += (leftMax - height[i]);
            } else if(leftMax < height[i]) {
                leftMax = height[i];
            } 
        }
        
        
        int rightAns = 0;
        int rightMax = height[height.length - 1];
        
          for(int i=height.length - 2;i>=maxIndex;i--) {
            if(rightMax >= height[i]) {
                rightAns += (rightMax - height[i]);
            } else if(rightMax < height[i]) {
                rightMax = height[i];
            } 
        }
        
        return leftAns + rightAns;
        
        
        
    }
}