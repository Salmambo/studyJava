package study;

import java.util.Scanner;

public class S02_rectangle_slash {
	public static void main(String[] args) {
		// n*n사각형에서 k간격마다 빗금을 친 사각형을 출력하는 프로그램을 작성하시오.
		// 윗변을 기준으로 왼쪽에서부터 k간격마다 좌하향으로 빗금을 그으시오.
		/*	 n=10, k=3이면
		 *	 **********
		 *	 **  *  * *
		 *	 *  *  *  *
		 *	 * *  *  **
		 *	 **  *  * *
		 *	 *  *  *  *
		 *	 * *  *  **
		 *	 **  *  * *
		 *	 *  *  *  *
		 *	 **********
		 */

		// n과 k의 값 입력 받아 선언 및 초기화
		Scanner sc = new Scanner(System.in);
		System.out.println("n과 k 입력");
		int n = sc.nextInt();
		int k = sc.nextInt();
		// 모양 만들기
		for (int i = 0; i < n; i++) {
			// else if에서 별을 찍기 위해 j의 키값을 +1
			for (int j = 1; j < n + 1; j++) {
				// 테두리 별 찍기
				if (i == 0 || i == n - 1 || j == 1 || j == n) {
					System.out.print('*');
				}
				// k간격마다 빗금으로 별 찍기
				else if ((i + j) % k == 0) {
					System.out.print('*');
				}
				// 나머지 공백 찍기
				else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		// 스캐너 종료
		sc.close();
	}
}
