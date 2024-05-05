package killingcamp.dfsbfs.example;

import java.util.ArrayDeque;
import java.util.Queue;

public class shortest_path_in_binary_matrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));

    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int ans = -1;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        if((grid[0][0] == 1) || (grid[rowLen-1][colLen-1] == 1) ) {
            return ans;
        }
        int[] dr = {1,-1,0,0,1,1,-1,-1};
        int[] dc = {0,0,1,-1,1,-1,1,-1};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,1});
        while(!q.isEmpty()) {
            int[] curNode = q.poll();
            int curRow = curNode[0];
            int curCol = curNode[1];
            int curLen = curNode[2];
            if((curRow == rowLen - 1) && (curCol == colLen - 1)) {
                return curLen;
            }
            for(int i = 0 ; i < 8; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if(isValid(nextRow, nextCol, rowLen, colLen)) {
                    if((grid[nextRow][nextCol] == 0) && (!visited[nextRow][nextCol])) {
                        q.offer(new int[] {nextRow, nextCol, curLen+1});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }

        return ans;
    }
    public static boolean isValid(int r, int c, int rowLen, int colLen){
        return ((0 <= r && r < rowLen) && ( 0 <= c && c < colLen));

    }

}
