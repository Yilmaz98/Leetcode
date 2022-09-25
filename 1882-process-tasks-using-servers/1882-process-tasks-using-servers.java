class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Server> freeServers = new PriorityQueue<>(
            (a, b) -> a.weight == b.weight ? a.index - b.index : a.weight - b.weight);
        PriorityQueue<Server> usedServers = new PriorityQueue<>((a, b) -> a.avail - b.avail);
        
        for (int i = 0; i < servers.length; i++) {
            freeServers.offer(new Server(i, servers[i]));
        }
        int[] res = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            //if there is any server completed at time i
            while (!usedServers.isEmpty() && usedServers.peek().avail <= i) {
                freeServers.offer(usedServers.poll());
            }
            
            //if no free servers, find servers for next available time
            if (freeServers.isEmpty()) {
                int minAvail = usedServers.peek().avail;
                while (!usedServers.isEmpty() && usedServers.peek().avail == minAvail) {
                    freeServers.offer(usedServers.poll());
                }
            }
            
            //use first server from freeServer
            Server server = freeServers.poll();
            res[i] = server.index;
            server.avail = Math.max(i, server.avail) + tasks[i];
            usedServers.offer(server);
        }
        return res;
    }
    
    public class Server {
        int index;
        int weight;
        int avail;
        public Server(int index, int weight) {
            this.index = index;
            this.weight = weight;
            this.avail = 0;
        }
    }
}