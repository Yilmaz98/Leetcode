class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        
        String[] paths = path.split("/");
        
        for(String p : paths) {
            if(p.isEmpty() || p.equals(".")) {
                continue;
            }
            else if(p.equals("..")) {
                if(!st.isEmpty()) {
                    st.pop();
                }
            } else {
                            st.add(p);
            }

        }
        
               // Stich together all the directory names together
        StringBuilder result = new StringBuilder();
        for (String dir : st) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/" ;
    }
}