//2022.07.11.
package study;

import java.util.Arrays;

public class S38_Solution_Q1 {

	// Lv.2 - 땅따먹기
	// 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다.
	// 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다.
	// 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
	// 마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요.
	/* 예시
	 * land								answer
	 * [[1,2,3,5],[5,6,7,8],[4,3,2,1]]	16
	 */
	private int[][] sum;

	int solution(int[][] land) {
		int i = 0, lth = land.length;
		sum = new int[lth][4];
		for (int j = 0; j < 4; j++)
			sum[i][j] = land[i][j];
		sum(land, 1);
		return Arrays.stream(sum[lth - 1]).max().getAsInt();
	}

	private void sum(int[][] land, int i) {
		if (i != land.length) {
			int max = Arrays.stream(sum[i - 1]).max().getAsInt();
			for (int j = 0; j < 4; j++)
				if (sum[i - 1][j] == max) {
					sum[i - 1][j] = 0;
					int iki = Arrays.stream(sum[i - 1]).max().getAsInt();
					sum[i][j] = land[i][j] + iki;
					sum[i - 1][j] = max;
				} else
					sum[i][j] = land[i][j] + max;
			sum(land, i + 1);
		}
	}
}
