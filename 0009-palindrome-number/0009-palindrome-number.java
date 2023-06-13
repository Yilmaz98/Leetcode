class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        
        List<Integer> arr1 = new ArrayList<>();
        while(x!=0) {
            arr1.add(x%10);
            x/=10;
        }
        
        List<Integer> arr2 = new ArrayList<>(arr1);
        
        Collections.reverse(arr2);
        
        for(int i=0;i<arr1.size();i++) {
            if(arr1.get(i) != arr2.get(i))
                return false;
        }
        
        return true;
 
    }
}