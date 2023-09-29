class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        
        while(i < word.length() && j < abbr.length()) {
            if(word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            }
            else if(Character.isDigit(abbr.charAt(j))) {
                int digit = 0;
                while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    if(digit == 0 && abbr.charAt(j) == '0')
                        return false;
                    digit = digit * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                i += digit;
            } else {
                return false;
            }
        }
        
        return i == word.length() && j == abbr.length();
    }
}