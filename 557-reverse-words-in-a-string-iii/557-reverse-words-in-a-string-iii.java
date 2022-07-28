class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        String result = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++) {
            sb.append(words[i]);
            result += sb.reverse().toString();
            if(i!=words.length - 1)
                result +=" ";
            sb.setLength(0);
        }
        
        return result;
        
    }
}