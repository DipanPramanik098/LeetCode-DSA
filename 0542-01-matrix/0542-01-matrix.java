class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int visited [] [] = new int[m][n];
        for(int []row: visited) {
            Arrays.fill(row, -1);
        }
        int ans [][] = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        // add initial zero's with distance 0
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j,0});
                    visited[i][j] = 1;
                    ans[i][j] = 0;
                }
            }
        }
        // 
        int [] row = {0, -1, 0, +1};
        int col[] = {-1, 0, +1, 0};
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            for(int i=0; i<4;i++){
                int nr = r + row[i];
                int nc = c + col[i];
                if(nr >=0 && nr < m && nc >=0 && nc<n && visited[nr][nc] != 1){
                    q.add(new int[]{nr, nc, d+1});
                    visited[nr][nc] = 1;
                    ans[nr][nc] = d+1;
                }
            }
        }
        return ans;
    }
}