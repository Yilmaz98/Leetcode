class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        
        Set<String> dead = new HashSet<>();
        for(String s : deadends) {
            dead.add(s);
        }
        
        if(dead.contains("0000"))
            return -1;
        
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        
        int steps = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                String curr = q.poll();  
                
                if(curr.equals(target))
                    return steps;
                
                                      
                for(int j=0;j<curr.length();j++) {
                   StringBuilder plus = new StringBuilder(curr);
                    StringBuilder minus = new StringBuilder(curr);
                    
                    int ch  = curr.charAt(j) - '0';
                    
                    if(ch == 0) {
                        plus.setCharAt(j, '1');  
                        minus.setCharAt(j, '9'); 
                    }
                    else if(ch == 9) {
                       plus.setCharAt(j, '0');  
                       minus.setCharAt(j, '8');  
                    }
                    else {
                        int plusValue = ch + 1;
                        int minusValue = ch - 1;
                        plus.setCharAt(j, (char) (plusValue + '0'));
                        minus.setCharAt(j, (char) (minusValue + '0'));
                    }   
                    
                    if(!visited.contains(plus.toString()) && !dead.contains(plus.toString())) {
                         q.add(plus.toString());
                        visited.add(plus.toString());
                    }
                    

                       
                     if(!visited.contains(minus.toString())  && !dead.contains(minus.toString())) {
                        q.add(minus.toString()); 
                           visited.add(minus.toString());
                     }
                }
            }
            steps++;
        }
        
        return -1;
        
    }
}