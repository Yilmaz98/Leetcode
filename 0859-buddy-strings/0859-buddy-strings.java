class Solution {
    public boolean buddyStrings(String st, String goal) {
        if(st.length() != goal.length())
            return false;
        
        if(st.equals(goal)) {
            int[] frequency = new int[26];
            for (char ch : st.toCharArray()) {
                frequency[ch - 'a'] += 1;
                if (frequency[ch - 'a'] == 2) {
                    return true;
                }
            }
            // Otherwise, if we swap any two characters, it will make the strings unequal.
            return false;
        }
        
        int f = -1;
        int s = -1;
        
        for(int i=0;i<st.length();i++) {
            if(st.charAt(i) != goal.charAt(i)) {
                if(f == -1) {
                    f = i;
                } else if(s == -1)
                {
                    s= i;
                } else
                    return false;
            }
        }
                
        if(s == -1 ^ f == -1)
            return false;
        
        return st.charAt(f) == goal.charAt(s) && st.charAt(s) == goal.charAt(f);
    }
}