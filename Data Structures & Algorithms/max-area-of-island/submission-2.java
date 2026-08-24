class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                maxIsland = Math.max(traverse(grid, r, c), maxIsland);
            }
        }
        return maxIsland;
    }
    private int traverse(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }

        if (grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        
        return traverse(grid, r - 1, c) + traverse(grid, r + 1, c) + traverse(grid, r, c - 1)
            + traverse(grid, r, c + 1) + 1;
    }
}
