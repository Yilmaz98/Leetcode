class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[130];
        int index = 0, max = 0;
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            index = Math.max(index, arr[c]);
            arr[c] = i+1;
            max = Math.max(max, i-index+1);
        }
        
        return max;
    }
}