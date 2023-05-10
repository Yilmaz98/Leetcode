class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> stNum = new Stack<>();
        Stack<StringBuilder> stStrs = new Stack<>();
        
        
        int tmpNum = 0;
        StringBuilder tmpStr = new StringBuilder("");
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stNum.push(tmpNum);
                stStrs.push(tmpStr);
                tmpStr = new StringBuilder();
                tmpNum = 0;
            } else if (c == ']') {
                int count = stNum.pop();
                StringBuilder sb = stStrs.pop();
                for (int i=0; i<count; i++) {
                    sb.append(tmpStr);
                }
                tmpStr = sb;
            } else if (c >= '0' && c <= '9') {
                tmpNum = (tmpNum * 10) + (c - '0');
            } else {
                tmpStr.append(c);
            }
        }
        return tmpStr.toString();
    }
}