/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    public void cleanRoom(Robot robot) {
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};    // 0 is up, 1 is right, 2 is down, 3 is left.
    dfs(robot, 0, 0, 0, dirs, new HashSet<>());                      // We assume the robot is initially facing up.
}

private void dfs(Robot robot, int row, int col, int dir, int[][] dirs, Set<String> seen) {
    seen.add(row + "," + col);
    robot.clean();
    // Only recurse on neighbouring unseen 1's.
    for (int i = 0; i < 4; ++i) {
        int newDir = (dir + i)%4;
        System.out.println(newDir);
        int newRow = row + dirs[newDir][0], newCol = col + dirs[newDir][1];
        if (!seen.contains(newRow + "," + newCol) && robot.move()) {
            dfs(robot, newRow, newCol, newDir, dirs, seen);
            
            // Backtrack. Go back to the initial position (row, col, dir) before the recursive call.
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }
        robot.turnRight();  
    }
}
}