//2022.06.30.
package study;

import java.util.ArrayList;

public class S34_Solution_Q1 {

	// Lv.2 - 줄 서는 방법
	// n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다.
	// 사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때,
	// k번째 방법을 return하는 solution 함수를 완성해주세요.
	/* 예시
	 * n	k	result
	 * 3	5	[3,1,2]
	 */
	public int[] solution(int n, long k) {
		int[] answer = new int[n];
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++)
			list.add(i);
		int i = 0;
		while (n > 0) {
			long f = factorial(n);
			answer[i] = list.remove((int) ((k - 1) / f));
			k = k % f;
			i++;
			if (k == 0) {
				for (int j = list.size() - 1; j >= 0; j--) {
					answer[i] = list.get(j);
					i++;
				}
				break;
			}
			n--;
		}
		return answer;
	}

	private long factorial(int n) {
		long f = 1;
		for (int i = 2; i < n; i++)
			f *= i;
		return f;
	}
}
