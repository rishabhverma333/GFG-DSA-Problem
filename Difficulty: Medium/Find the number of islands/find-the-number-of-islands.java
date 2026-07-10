class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int countIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        Queue<Pair> q=new LinkedList<>();
        boolean[][] arr=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='L' && !arr[i][j]){
                    q.add(new Pair(i,j));
                    arr[i][j] = true;
                    dfs(grid,arr,i,j,n,m,q);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,boolean[][]arr,int r,int c,int er,int ec, Queue<Pair> q){
        if(r<0||c<0||r>=er||c>=ec) return;
        while(q.size()>0){
            Pair pop=q.remove();
            //down
            if(pop.row+1 < er &&grid[pop.row+1][pop.col]=='L' &&!arr[pop.row+1][pop.col]){
                arr[pop.row+1][pop.col] = true;
                q.add(new Pair(pop.row+1,pop.col));
            }
            //up
            if(pop.row-1>=0 &&grid[pop.row-1][pop.col]=='L' &&!arr[pop.row-1][pop.col]){
                arr[pop.row-1][pop.col] = true;
                q.add(new Pair(pop.row-1,pop.col));
            }
            //right
            if(pop.col+1<ec &&grid[pop.row][pop.col+1]=='L' &&!arr[pop.row][pop.col+1]){
                arr[pop.row][pop.col+1] = true;
                q.add(new Pair(pop.row,pop.col+1));
            }
            //left
            if(pop.col-1>=0 &&grid[pop.row][pop.col-1]=='L' &&!arr[pop.row][pop.col-1]){
                arr[pop.row][pop.col-1] = true;
                q.add(new Pair(pop.row,pop.col-1));
            }
            // up left
            if(pop.row-1>=0 && pop.col-1>=0&&grid[pop.row-1][pop.col-1]=='L' &&!arr[pop.row-1][pop.col-1]){
                arr[pop.row-1][pop.col-1] = true;
                q.add(new Pair(pop.row-1,pop.col-1));
            }
            // up right
            if(pop.row-1>=0 && pop.col+1<ec&&grid[pop.row-1][pop.col+1]=='L' &&!arr[pop.row-1][pop.col+1]){
                arr[pop.row-1][pop.col+1] = true;
                q.add(new Pair(pop.row-1,pop.col+1));
            }
            // down left
            if(pop.row+1<er && pop.col-1>=0&&grid[pop.row+1][pop.col-1]=='L' &&!arr[pop.row+1][pop.col-1]){
                arr[pop.row+1][pop.col-1] = true;
                q.add(new Pair(pop.row+1,pop.col-1));
            }
            // down right
            if(pop.row+1<er && pop.col+1<ec&&grid[pop.row+1][pop.col+1]=='L' &&!arr[pop.row+1][pop.col+1]){
                arr[pop.row+1][pop.col+1] = true;
                q.add(new Pair(pop.row+1,pop.col+1));
            }
        }
        return;
    }
}