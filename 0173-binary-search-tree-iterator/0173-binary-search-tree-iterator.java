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
class BSTIterator {
    List<Integer> arr = new ArrayList<>();
    int i = -1;
    
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    public int next() {
            return arr.get(++i);
    }
    
    public boolean hasNext() {
        if(i + 1 < arr.size()) {
            return true;
        }  
        return false;
    }
    
    public void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            arr.add(root.val);
            inorder(root.right);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */