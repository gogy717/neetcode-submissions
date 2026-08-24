class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    traverse(grid, r, c);
                    result++;
                }
            }
        }
        return result;
    }

    private void traverse(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }
        if (grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0'; // mark visited permanently, don't restore it
        traverse(grid, r + 1, c);
        traverse(grid, r, c + 1);
        traverse(grid, r - 1, c);
        traverse(grid, r, c - 1);
    }
}