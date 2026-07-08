class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;
        if (maze[0][0] == 0 || maze[n-1][n-1] == 0)
            return ans;
        boolean[][] visit = new boolean[n][n];
        paths(0, 0, maze, visit, "", ans);
        return ans;
    }
    public void paths(int r, int c,int[][] maze,boolean[][] visit,String s,ArrayList<String> ans) {
        int n = visit.length;
        if (r >= n || c >= n || r < 0 || c < 0 ||maze[r][c] == 0 || visit[r][c]) return;
        if (r == n - 1 && c == n - 1) {
            ans.add(s);
            return;
        }
        //if true the coll no go this place
        visit[r][c] = true;
        paths(r + 1, c, maze, visit, s + "D", ans);
        paths(r, c - 1, maze, visit, s + "L", ans);
        paths(r, c + 1, maze, visit, s + "R", ans);
        paths(r - 1, c, maze, visit, s + "U", ans);

       // Backtracking
        visit[r][c] = false;
    }
}