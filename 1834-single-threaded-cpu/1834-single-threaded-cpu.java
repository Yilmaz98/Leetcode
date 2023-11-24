class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] result = new int[tasks.length];
        
        int[][] sortedTasks = new int[tasks.length][3];
        
        for(int i=0;i<tasks.length;i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        
        Arrays.sort(sortedTasks, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        int currentTime = 0;
        int idx = 0;
        int i = 0;
        
        while(idx < sortedTasks.length) {
             if(pq.isEmpty() && currentTime < sortedTasks[idx][0]) {
                 currentTime = sortedTasks[idx][0];
                 pq.add(sortedTasks[idx]);
                 idx++;
             }   

            while(idx < sortedTasks.length && currentTime >= sortedTasks[idx][0]) {
                pq.add(sortedTasks[idx]);
                idx++;
            }

            if(pq.isEmpty())
                break;
            int[] pickedTask = pq.poll();
            result[i++] = pickedTask[2];
            currentTime += pickedTask[1];   
        }
        
        while(!pq.isEmpty()) {
               int[] pickedTask = pq.poll();
            result[i++] = pickedTask[2]; 
        }
        
        return result;
    }
}