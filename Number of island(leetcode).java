class Solution {
    final int diff[][]={{0,-1},{0,1},{-1,0},{1,0}};
    public void dfs(char grid[][],int r,int c,int i,int j){
        grid[i][j]='0';
        for(int l=0;l<4;l++)
        {
            int ar=i+diff[l][0],ac=j+diff[l][1];
            if(ar>=0 && ar<r && ac>=0 && ac<c && grid[ar][ac]=='1'){
                dfs(grid,r,c,ar,ac);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int island=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1')
                {
                    island++;
                    dfs(grid,r,c,i,j);
                }
            }
        }
        return island;     
    }
}
