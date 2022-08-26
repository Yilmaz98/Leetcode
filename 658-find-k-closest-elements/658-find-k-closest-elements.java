class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> lst = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++) {
            lst.add(arr[i]);
        }
        
        Collections.sort(lst, (a,b) -> Math.abs(a-x) - Math.abs(b-x));
        
        Collections.sort(lst.subList(0,k));
        
        return lst.subList(0,k);
        
    }
}