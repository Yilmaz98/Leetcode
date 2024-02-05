class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int cursor = 0;

        StringBuilder sentenceStr = new StringBuilder();

        for(String curr : sentence) {
            sentenceStr.append(curr + " ");
        }
        
        for(int i=0;i<rows;i++) {
            cursor += cols;

            if(sentenceStr.charAt(cursor % sentenceStr.length()) == ' ') {
                cursor++;
            } else {

                while(cursor >= 0 && sentenceStr.charAt(cursor % sentenceStr.length()) != ' ') {
                    cursor--;
                }
                cursor++;
            }
        }

        return cursor / sentenceStr.length();
    }
}