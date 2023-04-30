class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        
        for(int i=0;i<colors.length;i++){
            if(!m.containsKey(colors[i]))
                m.put(colors[i], new ArrayList<>());
            
            m.get(colors[i]).add(i);
        }
        
        System.out.println(m);
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<queries.length;i++) {
            if(!m.containsKey(queries[i][1])) {
                result.add(-1);
                continue;
            }
            List<Integer> vals = m.get(queries[i][1]);
            int target = queries[i][0];
            
            int index = Collections.binarySearch(vals, target);
            if(index < 0) {
                 index = -1 * index - 1;
            
            if(index == vals.size()) {
                 result.add(Math.abs(vals.get(index-1) - target));
            }
            else if(index ==0) {
                 result.add(Math.abs(vals.get(0) - target));
            } else {
                 int one = Math.abs(vals.get(index) - target);
                 int two = Math.abs(vals.get(index-1) - target);
                result.add(Math.min(one,two));
            }
            }
            else {
                result.add(Math.abs(vals.get(index) - target));
            }
        }
        
        return result;
    }
}