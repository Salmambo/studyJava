//2022.04.25.
package study;

import java.util.Arrays;

public class S10_Solution_Q3 {

//	// Lv.1 - 평균 구하기
//	// 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
//	// arr은 길이 1 이상, 100 이하인 배열입니다.
//	// arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
//	/* 예시
//	 * arr			return
//	 * [1,2,3,4]	2.5
//	 * [5,5]		5
//	 */
//	public double solution(int[] arr) {
//		return (double) Arrays.stream(arr, 0, arr.length).sum() / arr.length;
//
//		// return Arrays.stream(arr).average().getAsDouble();
//		// 1. 어차피 배열 전체를 사용하기 때문에 시작 인덱스와 끝 인덱스 입력 불필요
//		// 2. average() 함수로 .sum() / arr.length 연산 가능
//		// 3. 이렇게 했을 시 (double) 형변환 불가 - .getAsDouble() 함수로 추출 필요
//	}

	// Lv.1 - 콜라츠 추측
	// 이 추측은, 주어진 수가 1이 될때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다.
	/* 작업은 다음과 같습니다.
	 * 1-1. 입력된 수가 짝수라면 2로 나눕니다.
	 * 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
	 * 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
	 */
	// 예를 들어, 입력된 수가 6이라면 6→3→10→5→16→8→4→2→1 이 되어 총 8번 만에 1이 됩니다.
	// 위 작업을 몇 번이나 반복해야하는지 반환하는 함수, solution을 완성해 주세요.
	// 단, 작업을 500번을 반복해도 1이 되지 않는다면 –1을 반환해 주세요.
	// 입력된 수, num은 1 이상 8000000 미만인 정수입니다.
	/* 예시
	 * n		result
	 * 6		8
	 * 16		4
	 * 626331	-1
	 */
	public int solution(int num) {
		int answer = 0;
		long number = num;
		for (int i = 0; i < 500; i++) {
			if (number == 1)
				break;
			answer++;
			// if (number == 1) return i; 시도횟수를 바로 리턴함으로써 answer 변수를 제거 가능
			if (number % 2 == 0)
				number /= 2;
			else
				number = (number * 3) + 1;
			// number = (number % 2 == 0) ? number / 2 : number * 3 + 1; 삼항식
		}
		if (answer == 500)
			answer = -1;
		return answer;
		// return -1; 시도횟수를 초과하여 for문 종료시 -1을 바로 리턴
	}

	// Lv.1 - 최대공약수와 최소공배수
	// 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
	// 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
	// 두 수는 1이상 1000000이하의 자연수입니다.
	/* 예시
	 * n	m		return
	 * 3	12		[3,12]
	 * 2	5		[1,10]
	 */
	public int[] solution(int n, int m) {
		int[] answer = new int[2];
		int min = (n < m) ? n : m;
		for (int i = min; i > 0; i--) {
			if (n % i == 0 && m % i == 0) {
				answer[0] = i;
				answer[1] = n * m / i;
				break;
			}
		}
		return answer;
	}

}
