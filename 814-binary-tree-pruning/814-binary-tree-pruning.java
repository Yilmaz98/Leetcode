class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(notContainsOne(root))
            return null;
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode currNode = queue.remove();
            if(notContainsOne(currNode.left))
                currNode.left=null;
            else
                queue.add(currNode.left);
            if(notContainsOne(currNode.right))
                currNode.right=null;
            else
                queue.add(currNode.right);
        }
        return root;
    }
    
    private boolean notContainsOne(TreeNode root)
    {
        if(root==null)
            return true;
        if(root.val==1)
            return false;
        return notContainsOne(root.left) && notContainsOne(root.right);
    }
}