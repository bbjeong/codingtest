import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[][] tickets) {
        
        List<String> answers = new ArrayList<>();
		boolean[] visited = new boolean[tickets.length];

		dfs(tickets, answers, "ICN", "ICN", visited, 0);

		Collections.sort(answers);
		return answers.get(0).split(" ");
    }
    
    public static void dfs(String[][] tickets, List<String> output, String start, String route, boolean[] visited, int count) {
		if (count == tickets.length) {
			output.add(route);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (start.equals(tickets[i][0]) && !visited[i]) {
				visited[i] = true;
				dfs(tickets, output, tickets[i][1], route + " " + tickets[i][1], visited, count + 1);
				visited[i] = false;
			}
		}
	}
    
}