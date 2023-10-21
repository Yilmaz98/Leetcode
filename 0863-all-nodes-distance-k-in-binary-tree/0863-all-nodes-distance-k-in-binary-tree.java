/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visited;
    List<Integer> result;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        adj = new HashMap<>();
        visited = new HashSet<>();
        result = new ArrayList<>();
        
        visited.add(target.val);
        buildGraph(root, null);
        
        dfs(target.val, adj, visited, 0, k);
        
        return result;
    }
    
    public void dfs(Integer curr, Map<Integer, List<Integer>> adj, Set<Integer> visited, int distance, int k) {
        if(distance == k) {
            result.add(curr);
            return;
        }
        
        if(!adj.containsKey(curr))
            return;
        
        for(Integer neighbour : adj.get(curr)) {
            if(!visited.contains(neighbour)) {
                            visited.add(neighbour);
            dfs(neighbour, adj, visited, distance + 1, k);
            }
        }
    }
    
    public void buildGraph(TreeNode root, TreeNode parent) {
        if(root == null)
            return;
        
        if(root != null && parent != null) {
            if(!adj.containsKey(root.val)) {
                adj.put(root.val, new ArrayList<>());
            }
            
            if(!adj.containsKey(parent.val)) {
                adj.put(parent.val, new ArrayList<>());
            }
            
            adj.get(root.val).add(parent.val);
            adj.get(parent.val).add(root.val);
        }
        
        buildGraph(root.left, root);
        buildGraph(root.right, root);
    }
}