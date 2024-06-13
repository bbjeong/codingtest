import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        int graphSize = words.length + 1;
        int[][] graphs = new int[graphSize][];

        graphs[0] = makeChild(words, begin);
        for (int i = 0; i < words.length; i++) {
            graphs[i + 1] = makeChild(words, words[i]);
        }
        
        return bfs(graphs, words, target);
    }
    
    private int[] makeChild(String[] words, String begin) {
        List<Integer> results = new ArrayList<>();

        for (int j = 0; j < words.length; j++) {
            String w = words[j];
            int matchCount = 0;
            for (int i = 0; i < w.length(); i++) {
                if (w.charAt(i) == begin.charAt(i)) {
                    matchCount++;
                }
            }
            if (matchCount == w.length() - 1) {
                results.add(j + 1);
            }
        }

        int[] resultArray = results.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(resultArray);

        return resultArray;
    }
    
    private int bfs(int[][] graphs, String[] words, String target) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graphs.length];
        int[] distance = new int[graphs.length];

        Arrays.fill(distance, -1);

        int start = 0;
        distance[start] = 0;
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            
            int[] child = graphs[parent];
            for (int c : child) {
                if (!visited[c]) {
                    queue.add(c);
                    visited[c] = true;
                    distance[c] = distance[parent] + 1;
                    if (target.equals(words[c - 1])) {
                        return distance[c];
                    }
                }
            }
        }

        return 0;
    }
}