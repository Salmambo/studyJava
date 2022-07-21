//2022.07.20.
package study;

public class S45_Solution_Q1 {

	// Lv.2 - 쿼드압축 후 개수 세기
	// 0과 1로 이루어진 2^n x 2^n 크기의 2차원 정수 배열 arr이 있습니다.
	// 당신은 이 arr을 쿼드 트리와 같은 방식으로 압축하고자 합니다.
	/* 당신이 압축하고자 하는 특정 영역을 S라고 정의합니다.
	 * 만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축시킵니다.
	 * 그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역으로 쪼갠 뒤, 각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.
	 */
	// 위와 같은 방식으로 arr을 압축했을 때, 배열에 최종적으로 남는 0의 개수와 1의 개수를
	// 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
	// arr의 행의 개수는 1 이상 1024 이하이며, 2의 거듭 제곱수 형태를 하고 있습니다.
	/* 예시
	 * arr											result
	 * [[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]	[4,9]
	 * [[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],		[10,15]
	 * [0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],
	 * [0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],
	 * [0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]
	 */
	private int[] answer = new int[2];

	public int[] solution(int[][] arr) {
		check(arr);
		return answer;
	}

	private void check(int[][] arr) {
		boolean check = false;
		int first = arr[0][0];
		for (int[] a : arr) {
			for (int i : a)
				if (i != first) {
					check = true;
					break;
				}
			if (check)
				break;
		}
		if (check)
			divide(arr);
		else if (first == 1)
			answer[1]++;
		else
			answer[0]++;
	}

	private void divide(int[][] arr) {
		int lth = arr.length / 2;
		int[][] arr1 = new int[lth][lth];
		int[][] arr2 = new int[lth][lth];
		int[][] arr3 = new int[lth][lth];
		int[][] arr4 = new int[lth][lth];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i < lth && j < lth) {
					arr1[i][j] = arr[i][j];
				} else if (i < lth && j >= lth) {
					arr2[i][j - lth] = arr[i][j];
				} else if (i >= lth && j < lth) {
					arr3[i - lth][j] = arr[i][j];
				} else {
					arr4[i - lth][j - lth] = arr[i][j];
				}
			}
		}
		check(arr1);
		check(arr2);
		check(arr3);
		check(arr4);
	}
}
