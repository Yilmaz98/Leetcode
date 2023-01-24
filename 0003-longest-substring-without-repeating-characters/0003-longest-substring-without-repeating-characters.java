class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[95];
        
        int index = 0;
        int max = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            index = Math.max(index, arr[c-32]);
            arr[c-32] = i+1;
            max = Math.max(max, i-index+1);
        }
        return max;
    }
}