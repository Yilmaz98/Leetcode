class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> result = new ArrayList<>();
        
        Stack<Integer> st = new Stack<>();
        
        st.push(asteroids[0]);
        
        for(int i=1;i<asteroids.length;i++) {
            int curr = asteroids[i];
             int prev;
            if(!st.isEmpty())
                prev = st.peek();
            else
                prev = curr;
            
            
            if(prev > 0 && curr < 0) {
                //isCollision
                while(!st.isEmpty()) {
                    if(Math.abs(curr) > prev) {
                        st.pop();
                        st.push(curr);
                    }
                    else if(Math.abs(curr) == prev) {
                        st.pop();
                        break;
                    }     
                    else
                        break;
                    
                    if(st.isEmpty())
                        break;
                    
                    curr = st.pop();
                    if(st.isEmpty()) {
                        st.push(curr);
                        break;
                    }
                    prev = st.peek();
                    if((curr > 0 && prev > 0) || (curr< 0 && prev<0)) {
                        st.push(curr);
                        break;
                    }
                }
            } else {
                st.push(asteroids[i]);   
            }
        }
        
        while(!st.isEmpty()) {
            result.add(st.pop());
        }
        
        Collections.reverse(result);
        
        return result.stream().mapToInt(i->i).toArray();
    }
}