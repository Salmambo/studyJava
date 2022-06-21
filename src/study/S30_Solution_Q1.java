//2022.06.21.
package study;

public class S30_Solution_Q1 {

	// Lv.2 - 양궁대회
	// 라이언은 저번 카카오배 양궁대회 우승자이고 이번 대회에도 결승전까지 올라왔습니다. 결승전 상대는 어피치입니다.
	// 카카오배 양궁대회 운영위원회는 한 선수의 연속 우승보다는 다양한 선수들이 양궁대회에서 우승하기를 원합니다.
	/* 따라서, 양궁대회 운영위원회는 결승전 규칙을 전 대회 우승자인 라이언에게 불리하게 다음과 같이 정했습니다.
	 * 어피치가 화살 n발을 다 쏜 후에 라이언이 화살 n발을 쏩니다.
	 * 점수를 계산합니다.
	 * - 가장 작은 원의 과녁 점수는 10점이고 가장 큰 원의 바깥쪽은 과녁 점수가 0점입니다.
	 * - k점을 어피치가 a발을 맞혔고 라이언이 b발을 맞혔을 경우 더 많은 화살을 k점에 맞힌 선수가 k 점을 가져갑니다.
	 *   단, a = b일 경우는 어피치가 k점을 가져갑니다.
	 *   k점을 여러 발 맞혀도 k점 보다 많은 점수를 가져가는 게 아니고 k점만 가져가는 것을 유의하세요.
	 * - 모든 과녁 점수에 대하여 각 선수의 최종 점수를 계산합니다.
	 * 최종 점수가 더 높은 선수를 우승자로 결정합니다. 단, 최종 점수가 같을 경우 어피치를 우승자로 결정합니다.
	 */
	// 라이언은 어피치를 가장 큰 점수 차이로 이기기 위해서 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지를 구하려고 합니다.
	// 어피치가 맞힌 과녁 점수의 개수를 10점부터 0점까지 순서대로 담은 정수 배열 info,
	// 화살의 개수를 담은 자연수 n이 매개변수로 주어집니다.
	// 라이언이 가장 큰 점수 차이로 우승하기 위해 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지를
	// 10점부터 0점까지 순서대로 정수 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
	// 만약, 라이언이 우승할 수 없는 경우(무조건 지거나 비기는 경우)는 [-1]을 return 해주세요.
	// 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.
	// 가장 낮은 점수를 맞힌 개수가 같을 경우 계속해서 그다음으로 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.
	/* 예시
	 * n	info						result
	 * 5	[2,1,1,1,0,0,0,0,0,0,0]		[0,2,2,0,1,0,0,0,0,0,0]
	 * 1	[1,0,0,0,0,0,0,0,0,0,0]		[-1]
	 * 9	[0,0,1,2,0,1,1,1,1,1,1]		[1,1,2,0,1,2,2,0,0,0,0]
	 * 10	[0,0,0,0,0,0,0,0,3,4,3]		[1,1,1,1,1,1,1,1,0,0,2]
	 */
	int[] answer = new int[11];
	int total = 0, max = 0;
	int[] temp, combi;

	public int[] solution(int n, int[] info) {
		combi = new int[n];
		for (int i = 0; i < 11; i++)
			if (info[i] > 0)
				total += (10 - i);
		combi(n, 0, 0, info);
		return (max == 0) ? new int[] { -1 } : answer;
	}

	private void combi(int n, int r, int start, int[] info) {
		if (r == n) {
			temp = new int[11];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < 11; j++)
					if (10 - combi[i] == j) {
						temp[j]++;
						break;
					}
			check(info);
		} else
			for (int i = start; i < 11; i++) {
				combi[r] = 10 - i;
				combi(n, r + 1, i, info);
			}
	}

	private void check(int[] info) {
		int ryan = 0;
		int apeach = total;
		for (int i = 0; i < 11; i++)
			if (temp[i] > info[i]) {
				ryan += (10 - i);
				if (info[i] > 0)
					apeach -= (10 - i);
			}
		if (ryan - apeach > max) {
			max = ryan - apeach;
			answer = temp.clone();
		} else if (ryan - apeach == max)
			for (int i = 10; i >= 0; i--)
				if (temp[i] > answer[i]) {
					answer = temp.clone();
					break;
				} else if (temp[i] < answer[i])
					break;
	}
}
