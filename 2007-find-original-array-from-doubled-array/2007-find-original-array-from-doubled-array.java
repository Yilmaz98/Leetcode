class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2!=0)
            return new int[0];
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i=0;i<changed.length;i++) {
            m.put(changed[i], m.getOrDefault(changed[i],0) + 1);
        }
        
        //System.out.println(m);
        
        Arrays.sort(changed);
        
        int ans[] = new int[changed.length/2];
        int idx = 0;
        
        for(int i=0;i<changed.length;i++) {
            if(m.containsKey(changed[i]) && m.containsKey(changed[i] * 2))          {
                if(changed[i] == 0) {
                    if(m.get(changed[i]) < 2)
                        return new int[0];
                }
                
                m.put(changed[i], m.get(changed[i]) - 1);                                   m.put(changed[i] * 2, m.get(changed[i] * 2) - 1);
                
                if(m.get(changed[i]) == 0)
                    m.remove(changed[i]);
                
                if(m.containsKey(changed[i]*2) && m.get(changed[i] * 2) == 0)
                    m.remove(changed[i] * 2);
                
                ans[idx++] = changed[i];
            }    
        }
        
        for(int i=0;i<ans.length;i++) {
            System.out.println(ans[i] + " ");
        }
        
        return idx == changed.length/2 ? ans : new int[0];
    }
}