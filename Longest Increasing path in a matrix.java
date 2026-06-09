class Solution {
    final int diff[][]={{0,-1},{0,1},{-1,0},{1,0}};
    public int dfs(int matrix[][],int dp[][],int r,int c,int row,int col){
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        int adjMax=0;
        for(int i=0;i<4;i++){
            int ar=row+diff[i][0],ac=col+diff[i][1];
            if(ar>=0 && ar<r && ac>=0 && ac<c && matrix[ar][ac]>matrix[row][col]){
                adjMax=Math.max(adjMax,dfs(matrix,dp,r,c,ar,ac));
            }
        }
        dp[row][col]=1+adjMax;
        return dp[row][col];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length; 
        int maxlen=1;
        int[][] dp=new int[r][c];
        for(int row=0;row<r;row++){
            for(int col=0;col<c;col++){
                if(dp[row][col]==0){
                    maxlen=Math.max(maxlen,dfs(matrix,dp,r,c,row,col));
                }
            }
        }
        return maxlen;
    }
}
