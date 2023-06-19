class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(!m.containsKey(i+j))
                    m.put(i+j, new ArrayList<>());
                
                m.get(i+j).add(mat[i][j]);
            }
        }
        
        int[] result = new int[mat.length * mat[0].length];
        int i = 0;
        boolean downToTop = true;
        for(List<Integer> val : m.values()) {
            if(downToTop) {
              for(int j = val.size() - 1;j>=0;j--) {
                  result[i++] = val.get(j);
              }
                downToTop = false;
            } else {
                for(Integer v : val) {
                    result[i++] = v;
                }
                downToTop = true;
            }
           
        }
        
        return result;
    }
}