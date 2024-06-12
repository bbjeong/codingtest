import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> answers = new HashMap<>();
        for (String[] c : clothes) {
            answers.compute(c[1], (k, v) -> v == null ? 1 : v + 1);
        }

        int answer = 1;
        List<Integer> list = new ArrayList<>(answers.values());
        for (Integer i : list) {
            answer *= (i + 1); // 경우의 수 + 아무것도 선택안한 케이스(+1)
        }

        return answer - 1; // 모두 선택 안한 케이스 제외
    }
}