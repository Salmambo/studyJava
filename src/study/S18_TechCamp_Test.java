//2022.05.05.
package study;

import java.util.Scanner;

public class S18_TechCamp_Test {

	// 1번
	// 직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다.
	// 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록
	// solution 함수를 완성해주세요.
	// 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.
	// v는 세 점의 좌표가 들어있는 2차원 배열입니다.
	// v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
	// 좌표값은 1 이상 10억 이하의 자연수입니다.
	// 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
	/* 예시
	 * v							result
	 * [[1, 4], [3, 4], [3, 10]]	[1, 10]
	 * [[1, 1], [2, 2], [1, 2]]		[2, 1]
	 */
	public int[] solution(int[][] v) {
		int[] answer = new int[2];

		int[] x = new int[3];
		int[] y = new int[3];
		for (int i = 0; i < v.length; i++) {
			x[i] = v[i][0];
			y[i] = v[i][1];
		}
		if (x[0] == x[1]) {
			answer[0] = x[2];
		} else if (x[0] == x[2]) {
			answer[0] = x[1];
		} else {
			answer[0] = x[0];
		}
		if (y[0] == y[1]) {
			answer[1] = y[2];
		} else if (y[0] == y[2]) {
			answer[1] = y[1];
		} else {
			answer[1] = y[0];
		}

		// x축 좌표와 y축 좌표를 따로 뽑아내서 계산할 필요 없다.
//		if (v[0][0] == v[1][0]) {
//			answer[0] = v[2][0];
//		} else if (v[0][0] == v[2][0]) {
//			answer[0] = v[1][0];
//		} else {
//			answer[0] = v[0][0];
//		}
//		if (v[0][1] == v[1][1]) {
//			answer[1] = v[2][1];
//		} else if (v[0][1] == v[2][1]) {
//			answer[1] = v[1][1];
//		} else {
//			answer[1] = v[0][1];
//		}

		// 비트연산자 ^(XOR)를 사용하면 위 모든 코드가 두 줄로 줄어든다.
//		answer[0] = v[0][0] ^ v[1][0] ^ v[2][0];
//		answer[1] = v[0][1] ^ v[1][1] ^ v[2][1];
		// XOR은 이진법으로 연산하며 두 수가 같으면 0(false)을, 다르면 1(true)을 반환한다.
		// 위 세 수 중 둘이 무조건 같으므로 0이 남고, 다른 하나의 수와 연산하면 그 수가 그대로 반환된다.

		return answer;
	}

	// 2번
	// 이 문제에는 표준 입력으로 정수 n이 주어집니다.
	// 별(*) 문자를 이용해 높이가 n인 삼각형을 출력해보세요.
	// n은 100 이하인 자연수입니다.
	/* 예시
	 * 3
	 * *
	 * **
	 * ***
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		char star = '*';
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < i + 1; j++)
				System.out.print(star);
			System.out.println();
		}
	}

	// 3번
	// 정수 n이 주어질때, 1부터 n까지의 정수를 순서대로 담은 배열을 리턴하도록 solution 함수를 작성했습니다.
	// 이때, 코드가 올바르게 동작할 수 있도록 빈칸을 알맞게 채워주세요.
	// 정수 n이 solution 함수의 매개변수로 주어집니다.
	// n은 1 이상 100,000이하인 정수입니다.
	// solution 함수는 1부터 n까지의 정수를 순서대로 담은 배열을 리턴합니다.
	/* 예시
	 * arr	return
	 * 3	[1,2,3]
	 * 5	[1,2,3,4,5]
	 */
	public int[] solution(int n) {
		int[] answer = new int[n];
		for (int i = 0; i < n; i++)
			answer[i] = i + 1;
		return answer;
	}

}
