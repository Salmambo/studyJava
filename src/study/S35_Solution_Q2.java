//2022.07.01.
package study;

import java.util.ArrayList;

public class S35_Solution_Q2 {

	// Lv.2 - 숫자의 표현
	// 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다.
	// 자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
	/* 예시
	 * n	result
	 * 15	4
	 */
	private int answer = 1;

	public int solution(int n) {
		double max = Math.ceil((double) n / 2);
		for (int i = 1; i < max; i++)
			sum(i, max, n);
		return answer;
	}

	private void sum(int i, double max, int n) {
		int sum = 0;
		while (i <= max) {
			sum += i;
			if (sum == n) {
				answer++;
				break;
			} else if (sum > n)
				break;
			i++;
		}
	}
	/* "주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 약수의 홀수 개수와 같다"를 이용
	public int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i += 2)
			if (n % i == 0)
				answer++;
		return answer;
	} */

	// Lv.2 - 숫자 블록
	// 그렙시에는 0으로 된 도로에 숫자 블록을 설치하기로 하였습니다.
	// 블록의 번호가 n 일 때, 가장 처음 블록은 n * 2번째 위치에 설치합니다.
	// 그다음은 n * 3, 그다음은 n * 4, ...로 진행합니다.
	// 만약 기존에 블록이 깔려있는 자리라면 그 블록을빼고 새로운 블록으로 집어넣습니다.
	// 그렙시는 길이가 1,000,000,000인 도로에 1번 블록부터 시작하여 10,000,000번 블록까지 위의 규칙으로 모두 놓았습니다.
	// 구간을 나타내는 두 수 begin, end 가 매개변수로 주어 질 때,
	// 그 구간에 깔려 있는 블록의 숫자 배열(리스트)을 return하는 solution 함수를 완성해 주세요.
	/* 예시
	 * begin	end		result
	 * 1		10		[0, 1, 1, 2, 1, 3, 1, 4, 3, 5]
	 */
	private final int max = 10000000;

	public int[] solution(long begin, long end) {
		ArrayList<Integer> list = new ArrayList<>();
		for (long i = begin; i <= end; i++)
			if (i == 1)
				list.add(0);
			else
				list.add((int) divisor(i));
		return list.stream().mapToInt(i -> i).toArray();
	}

	private long divisor(long n) {
		for (long i = 2; i <= (long) Math.sqrt(n); i++)
			if (n % i == 0 && n / i <= max)
				return n / i;
		return 1;
	}
}
