import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // map의 크기를 2배 -> 경계/모서리쪽에 점이 겹칠 경우 경로의 착오가 발생할 수 있음
        // 제한도 2배로 늘려줘야 런타임 에러 발생하지 않음 (101 -> 102)
		int[][] graphs = new int[102][102];
		for(int i=0;i<rectangle.length;i++) {
			int lx = rectangle[i][0];
			int ly = rectangle[i][1];
			int rx = rectangle[i][2];
			int ry = rectangle[i][3];
			fill(graphs, 2*lx, 2*ly, 2*rx, 2*ry);
		}
        
		for(int i=0;i<rectangle.length;i++) {
			int lx = rectangle[i][0];
			int ly = rectangle[i][1];
			int rx = rectangle[i][2];
			int ry = rectangle[i][3];
			line(graphs, 2*lx, 2*ly, 2*rx, 2*ry);
		}
        
		boolean[][] visited = new boolean[102][102];
		return bfs(graphs, visited, 2*characterX, 2*characterY, 2*itemX, 2*itemY);
    }
    
    int bfs(int[][] graphs, boolean[][] visited, int startX, int startY, int targetX, int targetY) {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{startX, startY, 0});
		visited[startX][startY] = true;

		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		while (!queue.isEmpty()) {
			int[] prev = queue.poll();
			int prevX = prev[0];
			int prevY = prev[1];
			int count = prev[2];

			if (prevX == targetX && prevY == targetY) {
				return count/2;
			}

			for (int i = 0; i < moveX.length; i++) {
				int x = prevX + moveX[i];
				int y = prevY + moveY[i];

				if (x >= 1 && x <= graphs.length && y >= 1 && y <= graphs[0].length) {
					if (!visited[x][y] && graphs[x][y] == 1) {
						visited[x][y] = true;
						queue.add(new int[]{x, y, count + 1});
					}
				}
			}
		}
		return 0;
	}


	void fill(int[][] visited, int x1, int y1, int x2, int y2){
		for (int i = x1; i <= x2; i++) {
			visited[i][y1] = 1;
			visited[i][y2] = 1;
		}
		for (int i = y1; i <= y2; i++) {
			visited[x1][i] = 1;
			visited[x2][i] = 1;
		}
	}
    
	void line(int[][] visited, int x1, int y1, int x2, int y2) {
		for (int i = x1+1; i < x2; i++) {
			for (int j = y1+1; j < y2; j++) {
				visited[i][j] = 2;
			}
		}
	}
}