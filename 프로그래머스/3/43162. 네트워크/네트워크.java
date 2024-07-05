import java.util.concurrent.atomic.*;
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(computers, i, visited);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int[][] computers, int start, boolean[] visited) {

        visited[start] = true;

        for (int i = 0; i < computers[start].length; i++) {
            if (i != start && computers[start][i] == 1 && !visited[i]) {
                dfs(computers, i, visited);
            }
        }
    }
}