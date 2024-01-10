class TrieNode {
    TrieNode[] links;
    
    TrieNode() {
        links = new TrieNode[2];
    }
    
    public void put(int bit, TrieNode node)
    {
        links[bit] = node;
    }    
    
    public TrieNode get(int bit) {
        return links[bit];
    }
    
    public boolean containsKey(int bit) {
        return links[bit] != null;
    }
}

class Trie {
    TrieNode root;
    
    Trie() {
        root = new TrieNode();
    }
    
    public void insert(int num) {
        TrieNode ws = root;
        
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1;
            
            if(!ws.containsKey(bit)) {
                ws.put(bit, new TrieNode());
            }
            ws = ws.get(bit);
        }
    }
    
    public int getMax(int num) {
        TrieNode ws = root;
        int maxSum = 0;
        
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1;
            
            if(ws.containsKey(1 - bit)) {
                maxSum = maxSum | (1 << i);
                ws = ws.get(1 - bit);
            } else {
                ws = ws.get(bit);
            }
        }
        
        return maxSum;
    }
}


class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[][] ans = new int[queries.length][3];
        
        for(int i=0;i<queries.length;i++) {
            ans[i][0] = queries[i][0];
            ans[i][1] = queries[i][1];
            ans[i][2] = i;
        }
        
        Arrays.sort(ans, (a,b) -> a[1] - b[1]);
        
        int[] result = new int[queries.length];
        
        Trie trie = new Trie();
        int idx = 0;
        
        Arrays.sort(nums);
        
        for(int i=0;i<ans.length;i++) {
            
            while(idx < nums.length && nums[idx] <= ans[i][1]) {
                trie.insert(nums[idx]);
                idx++;
            }
            
            if(idx == 0)
                result[ans[i][2]] = -1;
            else 
                result[ans[i][2]] = trie.getMax(ans[i][0]);
        }
        
        return result;
    }
}