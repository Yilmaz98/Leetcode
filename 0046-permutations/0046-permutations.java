class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, 0);
        return result;
    }
    
    public void helper(int[] arr, List<List<Integer>> result, int start) {
       if(start >= arr.length) {
           List<Integer> tempList = new ArrayList<>();
            for(int i = 0;i<arr.length;i++) {
                tempList.add(arr[i]);
            }
           result.add(tempList);
           return;
       }
        
        for(int i = start;i < arr.length;i++) {
            swap(arr, start, i);
            helper(arr,result, start+1);
            swap(arr,i, start);
        }
    }
    
    public void swap(int [] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}