class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3)
            return false;
        
        boolean greater = false;
        boolean lesser = false;
        
        for(int i=0;i<arr.length - 1;i++) {
            if(arr[i] < arr[i + 1]) {
                if(lesser)
                    return false;
                greater = true;
            } else if(arr[i] > arr[i + 1]) {
                if(!greater)
                    return false;
                lesser = true;
            } else if(arr[i] == arr[i+1])
                return false;
        }
        
        return greater && lesser;
    }
}