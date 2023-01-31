class Solution {
    Map<Character, String> m = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6', "mno", '7', "pqrs", '8',"tuv", '9', "wxyz");
    String phoneDigits;
    List<String> combinations = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
            
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        
        return combinations;
    }
    
    public void backtrack(int index, StringBuilder path) {
        if(path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return;
        }
        
        String possibleCharacters = m.get(phoneDigits.charAt(index));
        for(char letter : possibleCharacters.toCharArray()) {
            path.append(letter);
            backtrack(index+1,path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}