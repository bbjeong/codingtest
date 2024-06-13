import java.util.*;
import java.util.stream.*;
import java.util.concurrent.atomic.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            int idx = i;
            m.compute(genres[i], (x, y) -> y == null ? plays[idx] : y + plays[idx]);
        }
        
        // map 으로 변환
        AtomicInteger genresIdx = new AtomicInteger();
        Map<Integer, String> genresMap = Arrays.stream(genres).collect(Collectors.toMap(x -> genresIdx.getAndIncrement(), y -> y));

        // map 으로 변환
        AtomicInteger playsIdx = new AtomicInteger();
        Map<Integer, Integer> playsMap = Arrays.stream(plays).boxed().collect(Collectors.toMap(x -> playsIdx.getAndIncrement(), y -> y));

        List<String> ranks = m.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue())
                        .map(e -> e.getKey()).collect(Collectors.toList()); // 합산 값 내림차순으로 정렬

        List<Integer> answers = new ArrayList<>();

        for (String r : ranks) {
            List<Integer> indexes = genresMap.entrySet()
                    .stream().filter(e -> e.getValue().equals(r)).map(e -> e.getKey()).collect(Collectors.toList());

            int count = indexes.size() >= 2 ? 2 : indexes.size();
            List<Integer> topList = playsMap.entrySet().stream()
                    .filter(e -> indexes.contains(e.getKey()))
                    .sorted((o1, o2) -> o2.getValue() - o1.getValue()).limit(count).map(Map.Entry::getKey).collect(Collectors.toList());

            answers.addAll(topList);
        }

        return answers.stream().mapToInt(Integer::intValue).toArray();
        
    }
}