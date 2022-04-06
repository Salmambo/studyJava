package study;
//2022.04.04.

import java.util.Scanner;

public class S02_rectangle {
	public static void main(String[] args) {
		// 길이 n이 입력되면 다음과 같은 사각형을 출력한다.
		/* n이 5일 때
		 * *****
		 * *   *
		 * *   *
		 * *   *
		 * *****
		 */

		// 길이 n 입력 받고
		Scanner sc = new Scanner(System.in);
		System.out.println("길이 n 입력 >>> ");
		int n = sc.nextInt();
		// 입력될 문자 생성
		char ast = '*';
		char ann = ' ';
		// *로 만들 모양 만들기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 가운데 비우기
				if (i > 0 && i < n - 1) {
					if (j > 0 && j < n - 1) {
						System.out.print(ann);
					} else {
						System.out.print(ast);
					}
				} else {
					System.out.print(ast);
				}
			}
			System.out.println();
		}
		// 종료
		sc.close();
	}
}
