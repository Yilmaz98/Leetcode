class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
          int m = maze.length;
    int n = maze[0].length;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[m][n];
    queue.offer(start);
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      if (cur[0] == destination[0] && cur[1] == destination[1]) {
        return true;
      }
      if (visited[cur[0]][cur[1]])
        continue;
      visited[cur[0]][cur[1]] = true;
      int[][] move = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
      for (int[] mo : move) {
        int x = cur[0], y = cur[1];
        while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
          x += mo[0];
          y += mo[1];
        }
        // Back to validate point.
        x -= mo[0];
        y -= mo[1];
        // Adding new start point.
        queue.offer(new int[] {x, y});
      }
    }
    return false;
    }
}