import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       
        int[] remain = new int[progresses.length];
		for (int i = 0; i < progresses.length; i++) {
			remain[i] = 100 - progresses[i];
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < remain.length; i++) {
			queue.add(remain[i]);
		}

		List<Integer> answers = new ArrayList<>();

		int[] currentSpeed = speeds.clone();
		int speedIdx = 0;
		int count = 0;
		while (!queue.isEmpty()) {

			while (!queue.isEmpty() && queue.peek() > currentSpeed[speedIdx]) {
				for (int i = 0; i < currentSpeed.length; i++) {
					currentSpeed[i] = currentSpeed[i] + speeds[i];
				}
			}

			while(!queue.isEmpty() && queue.peek() <= currentSpeed[speedIdx]) {
				queue.poll();
				speedIdx++;
				count++;
			}

			if (count > 0) {
				answers.add(count);
				count = 0;
			}
		}

		return answers.stream().mapToInt(Integer::intValue).toArray();
    }
}