class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        
        List<int[]> ans = new ArrayList<>();
        
        while(i < firstList.length && j < secondList.length) {
            if(firstList[i][1] >= secondList[j][0]) {
                int lo = Math.max(firstList[i][0], secondList[j][0]);
                int hi = Math.min(firstList[i][1], secondList[j][1]);
                if(lo <= hi)
                    ans.add(new int[] {lo, hi});
            }
             if(firstList[i][1] < secondList[j][1]) {
            i++;
        } else {
            j++;
        }
        }
        
        int[][] res = new int[ans.size()][2];
        
        for(i=0;i<ans.size();i++) {
            
            res[i] = ans.get(i);
        }
       
        return res;
    }
}