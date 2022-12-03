class Solution {
    public class Node {
        char c;
        int n;
        
        Node() {
            
        }
        
        Node(char c, int n) {
            this.c = c;
            this.n = n;
        }
    }
    
    public String frequencySort(String s) {
        Map<Character, Integer> m = new HashMap<>();
        
        for(int i=0;i<s.length();i++) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i),0)+1);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)-> b.n - a.n);
        
        for(Character i: m.keySet()) {
            pq.add(new Node(i,m.get(i)));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int freq = curr.n;
            while(freq-->0)
                sb.append(curr.c);
        }
        
        return sb.toString();
    }
}