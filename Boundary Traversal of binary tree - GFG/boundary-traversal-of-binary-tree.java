//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    public boolean isLeaf(Node temp) {
        if(temp.left == null && temp.right == null)
            return true;
            
        return false;
    }
    
    public void addLeftBoundary(Node node, List<Integer> result) {
        Node temp = node.left;
        while(temp != null) {
            if(!isLeaf(temp)) {
                result.add(temp.data);
            }
            if(temp.left != null) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
    }
    
    public void addRightBoundary(Node node, List<Integer> result) {
        Node temp = node.right;
        List<Integer> reverseYilu = new ArrayList<>();
        while(temp != null) {
            if(!isLeaf(temp)) {
                reverseYilu.add(temp.data);
            }
            if(temp.right != null) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        
        for(int i = reverseYilu.size() - 1;i>=0;i--) {
            result.add(reverseYilu.get(i));
        }
    }
    
    public void addLeaves(Node temp, List<Integer> result) {
        if(temp == null)
            return;
            
        if(temp.left == null && temp.right == null)
            result.add(temp.data);
            
        addLeaves(temp.left, result);
        addLeaves(temp.right, result);
    }
    
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> result = new ArrayList<>();
	    if(!isLeaf(node)) result.add(node.data);
	    addLeftBoundary(node, result);
	    Node temp = node;
	    addLeaves(temp, result);
	    addRightBoundary(node, result);
	    
	    return result;
	}
}
