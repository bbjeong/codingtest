import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        return bfs(maps, new boolean[n][m], 0, 0, n - 1, m - 1);
    }
    
    int bfs(int[][] maps, boolean[][] visited, int startX, int startY, int targetX, int targetY) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 1});
        visited[startX][startY] = true;

        int[] moveX = {-1, 1, 0, 0};
        int[] moveY = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] prev = queue.poll();
            int prevX = prev[0];
            int prevY = prev[1];
            int count = prev[2];

            if (prevX == targetX && prevY == targetY) {
                return count;
            }

            for (int i = 0; i < moveX.length; i++) {
                int x = prevX + moveX[i];
                int y = prevY + moveY[i];

                if (x >= 0 && x < maps.length && y >= 0 && y < maps[0].length) {
                    if (!visited[x][y] && maps[x][y] == 1) {
                        visited[x][y] = true;
                        queue.add(new int[]{x, y, count + 1});
                    }
                }
            }
        }
        return -1;
    }
}