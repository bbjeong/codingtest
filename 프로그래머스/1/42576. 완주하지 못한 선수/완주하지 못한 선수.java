import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
    Map<String, Integer> participantMap = new HashMap<>();

    for (String s : participant) {
        participantMap.put(s, participantMap.getOrDefault(s, 0) + 1);
    }    
        
    for (String s : completion) {
        participantMap.put(s, participantMap.get(s) - 1);
    }
    
    String answer = null;
    for (String p : participantMap.keySet()) {
        
        int result = participantMap.getOrDefault(p, 0);
        if (result != 0) {
            answer = p;
            break;
        }
    }

      return answer;
    }
    
}