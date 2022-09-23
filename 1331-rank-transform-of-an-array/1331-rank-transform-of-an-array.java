class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> m = new TreeMap<>();
        
        for(int i=0;i<arr.length;i++) {
            if(!m.containsKey(arr[i]))
                m.put(arr[i], new ArrayList<>());
            m.get(arr[i]).add(i);
        }
        
        int[] result = new int[arr.length];
        
        int rank = 1;
        for(Integer i : m.keySet()) {
            for(int j : m.get(i)) {
                result[j] = rank;
            }
            rank++;
        }
        
        return result;   
    }
}