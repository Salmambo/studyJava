//2022.04.21.
package study;

import java.util.Scanner;

public class S08_Solution {

//  // Lv.1 - 직사각형 별찍기
//	// 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
//	// 별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
//	// n과 m은 각각 1000 이하인 자연수입니다.
//	/* 예시
//	 * 5,3
//	 * *****
//	 * *****
//	 * *****
//	 */
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		while (true) {
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//
////			System.out.println(a + b);
//
//			if (a > 0 && a < 1001 && b > 0 && b < 1001) {
//				for (int i = 0; i < b; i++) {
//					for (int j = 0; j < a; j++) {
//						System.out.print("*");
//					}
//					System.out.println();
//				}
//				break;
//			}
//		}
//		sc.close();
//	}

	// Lv1 - x만큼 간격이 있는 n개의 숫자
	// 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음
	// 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
	// x는 -10_000_000 이상, 10_000_000 이하인 정수입니다.
	// n은 1000 이하인 자연수입니다.
	/* 예시
	 * x	n	answer
	 * 2	5	[2,4,6,8,10]
	 * 4	3	[4,8,12]
	 * -4	2	[-4,-8]
	 */
	public long[] solution(int x, int n) {
		if (x < -10_000_000 || x > 10_000_000 || n > 1000 || n < 0)
			return null;
		long[] answer = new long[n];
		for (int i = 0; i < n; i++) {
			answer[i] = (long) x * (i + 1); // 자동형변환이지만 프로그래머스는 강제변환해야 정답 인정
		}
		return answer;
	}
}
