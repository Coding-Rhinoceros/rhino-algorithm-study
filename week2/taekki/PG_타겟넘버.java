
public class PG_타겟넘버 {

	int answer = 0; // 타켓 만드는 방법의 수

	void dfs(int index, int sum, int[] numbers, int target) {
		index += 1;

		// 숫자를 다 사용할 경우 sum과 target 비교
		if (index == numbers.length) {
			if (sum == target) {
				answer++;

				// return;
			}
		} else {
			// 더한 경우 탐색
			dfs(index, sum + numbers[index], numbers, target);

			// 뺀 경우 탐색
			dfs(index, sum - numbers[index], numbers, target);
		}
	}

	public int solution(int[] numbers, int target) {
		dfs(-1, 0, numbers, target);

		return answer;
	}

}