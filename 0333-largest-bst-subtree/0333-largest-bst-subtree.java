class Solution {
    // Function to check if given tree is a valid Binary Search Tree or not.
    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
          if(root == null)
            return true;
        
        if((min!= null && min >= root.val) || (max != null && root.val >= max)) {
            return false;
        }
        
        if(!isValidBST(root.left, min, root.val) || !isValidBST(root.right, root.val, max))
            return false;
        
        return true;
    }

    private int findMax(TreeNode root) {
        // Max node in a empty tree should be smaller than parent.
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        
        // Check the maximum node from the current node, left and right subtree of the current tree
        return Math.max(Math.max(root.val, findMax(root.left)), findMax(root.right));
    }

    private int findMin(TreeNode root) {
        // Min node in a empty tree should be larger than parent.
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        
        // Check the minimum node from the current node, left and right subtree of the current tree
        return Math.min(Math.min(root.val, findMin(root.left)), findMin(root.right));
    }
    
    private int countNodes(TreeNode root) {
        // Empty tree has 0 nodes.
        if (root == null) {
             return 0;
        }
        
        // Add nodes in left and right subtree.
        // Add 1 and return total size.
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // If current subtree is a validBST, its children will have smaller size BST.
        if (isValidBST(root, null, null)) {
            return countNodes(root);
        }
        
        // Find BST in left and right subtrees of current nodes.
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
}