/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        Stack<TreeNode> st = new Stack<>();
        boolean leftChildIncoming = false;
        boolean rightChildIncoming = false;
        boolean isNegative = false;
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '-') {
                isNegative = true;
                continue;
            }
            else if(c != '(' && c != ')') {
                int curr = c - '0';
                while(i+ 1< s.length() && Character.isDigit(s.charAt(i+1))) {
                    curr = curr * 10 + (s.charAt(i+1) - '0');
                    i++;
                } 
            
                int val = isNegative ? 0 - curr : curr; 
                TreeNode root  = new TreeNode(val);
                isNegative = false;
                if(leftChildIncoming) {
                    TreeNode prev = st.pop();
                    prev.left = root;
                    st.add(prev);
                    leftChildIncoming = false;
                }
                if(rightChildIncoming) {
                    TreeNode prev = st.pop();
                    prev.right = root;
                    st.add(prev);
                    rightChildIncoming = false;
                }
                st.add(root);
            } else if(c == '(') {
                if(!rightChildIncoming)
                    leftChildIncoming = true;
            } else if(c == ')') {
                    st.pop();
                    rightChildIncoming = true;
            }
        }
        
        return !st.isEmpty() ? st.pop() : null;
    }
}