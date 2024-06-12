import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[][] clothes) {
        
        return Arrays.stream(clothes)
                .collect(Collectors.groupingBy(c -> c[1], Collectors.counting()))
                .values()
                .stream().reduce(1L, (a, b) -> a * (b + 1)) // 경우의 수 + 아무것도 선택안한 케이스(+1)
                .intValue() - 1; // 모두 선택 안한 케이스 제외
    }
}