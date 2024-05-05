package killingcamp.큐스택그래프.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class keys_and_rooms {
    public static void main(String[] args) {


    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        // bfs 풀이
//        bfs(rooms, visited, 0);
        // dfs 풀이
        dfs(rooms, visited, 0);
        for(int i = 0; i < visited.length; i++) {
            if(visited[i]== false) {
                return false;
            }
        }
        return true;
//

    }
    public static void bfs(List<List<Integer>> rooms, boolean[] visited, int node) {
        Deque<Integer> q = new ArrayDeque<>();
        visited[node] = true;
        q.offer(node);

        while(!q.isEmpty()) {
            int curNode = q.poll();
            for(Integer nextNode: rooms.get(curNode)) {
                if(visited[nextNode] == false) {
                    q.offer(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }


    public static void dfs(List<List<Integer>> rooms,boolean[] visited,  int node) {
        visited[node] = true;
        for(Integer nextNode: rooms.get(node)) {
            if(visited[nextNode] == false) {
                dfs(rooms, visited, nextNode);
            }
        }


    }
}
