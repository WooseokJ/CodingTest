package killingcamp.dfsbfs.example;

import java.util.ArrayDeque;
import java.util.Queue;

public class number_of_island {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numsIslands(grid));

    }

    public static int numsIslands(char[][] grid) {
        int ans = 0;
        int rowLen = grid.length;
        int cowLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][cowLen];

        for(int r= 0; r < rowLen; r++) {
            for(int c = 0; c < cowLen; c++) {
                if((grid[r][c] == '1') && (!visited[r][c])) {
//                    dfs(r,c,grid, visited);
                    bfs(r,c,grid, visited);
                    ans++;

                }
            }
        }
        return ans;

    }

    public static void dfs(int r, int c, char[][] grid, boolean[][] visited) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        visited[r][c] = true;

        for(int i = 0 ;i < 4; i++) {
            int nextRow = r + dr[i];
            int nextCol = c + dc[i];
            if(isValid(nextRow, nextCol, rowLen, colLen)) {
                if((grid[nextRow][nextCol] == '1') && (!visited[nextRow][nextCol])) {
                    dfs(nextRow, nextCol, grid, visited);
                }
            }
        }
    }

    public static boolean isValid(int r, int c, int rowLen, int cowLen) {
        return ((0 <= r && r < rowLen) && (0 <= c && c < cowLen));
    }


    public static void bfs(int r, int c, char[][] grid, boolean[][] visited) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        visited[r][c] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r,c});

        while(!q.isEmpty()) {
            int[] curNode = q.poll();
            int curRow = curNode[0];
            int curCol = curNode[1];

            for(int i = 0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if(isValid(nextRow, nextCol, rowLen, colLen)) {
                    if((grid[nextRow][nextCol] == '1' ) && (!visited[nextRow][nextCol])) {
                        visited[nextRow][nextCol] = true;
                        q.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }


    }
}
