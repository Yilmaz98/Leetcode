class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        
        while(i < word.length() && j < abbr.length()) {
            if(word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            
            if(Character.isDigit(abbr.charAt(j))) {
                int sum  = 0;
                while(j< abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    if(sum == 0 && (abbr.charAt(j) - '0') == 0)
                        return false;
                    sum = sum * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += sum;
            } else if(word.charAt(i) != abbr.charAt(j)) {
                return false;
            }
        }
        
        return i == word.length() && j == abbr.length();
    }
}