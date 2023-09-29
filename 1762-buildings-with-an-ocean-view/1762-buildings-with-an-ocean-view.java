class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> arr = new ArrayList<>();
        arr.add(heights.length-1);
        
        int max = heights[heights.length-1];
        
        for(int i=heights.length-2;i>=0;i--) {
            if(max < heights[i]) {
                max = heights[i];
                arr.add(i);
            } else 
                continue;
        }
        
        int[] result = new int[arr.size()];
        
        for(int i = arr.size()-1;i>=0;i--) {
            result[arr.size() - i - 1] = arr.get(i);
        }
        
        return result;
    }
}