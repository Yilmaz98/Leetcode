class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
         TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < position.length; i++) {
            map.put(target - position[i], speed[i]);
        }
        double cur = 0.0;
        int count = 0;
        for (int item : map.keySet()) {
            double time = (double) item / map.get(item);
            if (time > cur) {
                cur = time;
                count++;
            }
        }
        return count;
    }
}