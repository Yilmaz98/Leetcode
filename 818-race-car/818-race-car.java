class Solution {
    class CarAttributes {
        int position;
        int speed;
        CarAttributes(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
    
    public int getMinimumAttributes(int target) {
        Queue<CarAttributes> q = new LinkedList<>();
        q.add(new CarAttributes(0,1));
        Set<String> visited = new HashSet<>();
        visited.add(String.valueOf(0) + "," + String.valueOf(1));
        int minAttributes = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
            
            CarAttributes curr = q.poll();
                
                int z = curr.position;
           // System.out.println(visited);
                if(curr.position == target)
                    return minAttributes;
                
            //A
       
            int nextPosition = curr.position + curr.speed;
            int nextSpeed = curr.speed * 2;
            String next = String.valueOf(nextPosition) + "," + String.valueOf(nextSpeed);
            if(!visited.contains(next) && Math.abs(target - nextPosition) < target) {
                visited.add(next) ;
               q.add(new CarAttributes(nextPosition,nextSpeed));  
            }
           
            
            
            // R
            nextSpeed = curr.speed  >= 0 ? -1 : 1;
            next = String.valueOf(z) + "," + String.valueOf(nextSpeed);
             if(!visited.contains(next) && Math.abs(target - z) < target) {
                 visited.add(next);
                 q.add(new CarAttributes(z, nextSpeed));
             }
            
            }
            minAttributes++;
            
        }
        
        return minAttributes;
    }
    
    public int racecar(int target) {
        return getMinimumAttributes(target);
    }
}