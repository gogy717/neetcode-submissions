class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // 每个位置都可以作为起点
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtrack(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(
        char[][] board,
        String word,
        int row,
        int col,
        int index
    ) {
        // 已经匹配完 word 的所有字符
        if (index == word.length()) {
            return true;
        }

        // 越界
        if (
            row < 0 ||
            row >= board.length ||
            col < 0 ||
            col >= board[0].length
        ) {
            return false;
        }

        // 当前字符不匹配
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // 临时标记当前格子已经使用
        char temp = board[row][col];
        board[row][col] = '#';

        // 往四个方向继续寻找下一个字符
        boolean found =
            backtrack(board, word, row + 1, col, index + 1) ||
            backtrack(board, word, row - 1, col, index + 1) ||
            backtrack(board, word, row, col + 1, index + 1) ||
            backtrack(board, word, row, col - 1, index + 1);

        // 回溯：恢复当前格子
        board[row][col] = temp;

        return found;
    }
}