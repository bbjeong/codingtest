import java.util.*;
import java.util.stream.*;

class Solution {
    
    public String solution(int[] numbers) {
        
        List<String> answers = Arrays.stream(numbers).mapToObj(Integer::toString)
                .collect(Collectors.toList());

        answers.sort((s1, s2) -> {
			String ab = s1 + s2;
			String ba = s2 + s1;

			return ba.compareTo(ab);
		});

        String a = answers.stream().collect(Collectors.joining());
		if (a.charAt(0) == '0') {
			return "0";
		}
        
        return a;
	}
}