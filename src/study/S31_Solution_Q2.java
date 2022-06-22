//2022.06.22.
package study;

public class S31_Solution_Q2 {

	// Lv.2 - N개의 최소공배수
	// 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
	// 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
	// n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
	/* 예시
	 * arr			result
	 * [2,6,8,14]	168
	 * [1,2,3]		6
	 */
	private int gcd;

	public int solution(int[] arr) {
		int idx = 1, lth = arr.length, lcm = arr[0];
		while (idx < lth) {
			gcd(lcm, arr[idx]);
			lcm = lcm * arr[idx] / gcd;
			idx++;
		}
		return lcm;
	}

	private void gcd(int a, int b) {
		if (a > b) {
			int result = a % b;
			if (result == 0)
				gcd = b;
			else
				gcd(b, result);
		} else {
			int result = b % a;
			if (result == 0)
				gcd = a;
			else
				gcd(a, result);
		}
	}

	// Lv.2 - N-Queen
	// 가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다.
	// 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다.
	// 체스판의 가로 세로의 세로의 길이 n이 매개변수로 주어질 때,
	// n개의 퀸이 조건에 만족 하도록 배치할 수 있는 방법의 수를 return하는 solution함수를 완성해주세요.
	// 퀸(Queen)은 가로, 세로, 대각선으로 이동할 수 있습니다.
	// n은 12이하의 자연수 입니다.
	/* 예시
	 * n	result
	 * 4	2
	 */
	private int[] chess;
	private int answer = 0;

	public int solution(int n) {
		chess = new int[n];
		put(n, 0);
		return answer;
	}

	private void put(int n, int idx) {
		if (idx == n)
			answer++;
		else
			for (int i = 0; i < n; i++)
				if (check(i, idx)) {
					chess[idx] = i;
					put(n, idx + 1);
				}
	}

	private boolean check(int i, int idx) {
		for (int j = 0; j < idx; j++)
			if (chess[j] == i || idx - j == Math.abs(i - chess[j]))
				return false;
		return true;
	}
}
