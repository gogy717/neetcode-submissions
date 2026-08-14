class Solution {
    public boolean exist(char[][] board, String word) {

        // 每个位置都可能是起点
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                StringBuilder path = new StringBuilder();

                if (backtrack(board, word, row, col, path)) {
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
        StringBuilder path
    ) {
        // 已经找到完整 word
        if (path.toString().equals(word)) {
            return true;
        }

        // 越界
        if (
            row < 0 ||
            col < 0 ||
            row >= board.length ||
            col >= board[0].length
        ) {
            return false;
        }

        // path 已经和 word 一样长，但还没有匹配成功
        if (path.length() >= word.length()) {
            return false;
        }

        // 当前应该匹配 word 的第几个字符
        int index = path.length();

        // 当前格子不匹配
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // 选择当前字符
        char temp = board[row][col];
        path.append(temp);

        // 标记当前格子已经使用
        board[row][col] = '#';

        // 向四个方向继续搜索
        boolean found =
            backtrack(board, word, row + 1, col, path) ||
            backtrack(board, word, row - 1, col, path) ||
            backtrack(board, word, row, col + 1, path) ||
            backtrack(board, word, row, col - 1, path);

        // backtracking：恢复状态
        board[row][col] = temp;
        path.deleteCharAt(path.length() - 1);

        return found;
    }
}
