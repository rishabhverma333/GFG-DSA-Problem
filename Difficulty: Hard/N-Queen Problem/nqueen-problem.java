class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] board = new int[n][n];
        solve(0, board, ans);
        return ans;
    }
    public void solve(int row, int[][] board, ArrayList<ArrayList<Integer>> ans) {
        int n = board.length;
        if (row == n) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        list.add(j + 1); // 1-based column index
                        break;
                    }
                }
            }
            ans.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 1;
                solve(row + 1, board, ans);
                // Backtracking
                board[row][col] = 0;
            }
        }
    }

    public boolean isSafe(int row, int col, int[][] board) {
        int n = board.length;
        // Check same column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1)
                return false;
        }
        // Check left diagonal
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1)
                return false;
            i--;
            j--;
        }
        // Check right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {
            if (board[i][j] == 1)
                return false;
            i--;
            j++;
        }
        return true;
    }
}