package study;
//2022.04.06.

import java.util.Scanner;

public class S03_snail {
	public static void main(String[] args) {
		// 다음과 같은 n*m 배열 구조를 출력하시오.
		// 입력이 3 4인 경우,
		/*
		 * 1  2  3  4
		 * 10 0  0  5
		 * 9  8  7  6
		 */
		// 입력이 4 5인 경우,
		/*
		 * 1  2  3  4  5
		 * 14 0  0  0  6
		 * 13 0  0  0  7
		 * 12 11 10 9  8
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("n m >>> ");
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] snail = new int[n][m]; // n*m의 배열
		for (int i = 0; i < n; i++) { // 배열의 행 추출
			for (int j = 0; j < m; j++) { // 배열의 열 추출
				if (i == 0) { // 윗변
					snail[i][j] = j + 1;
				} else if (j == m - 1) { // 오른쪽 변
					snail[i][j] = m + i;
				} else if (i == n - 1) { // 아랫변
					snail[i][j] = 2 * m + n - 2 - j;
				} else if (j == 0) { // 왼쪽 변
					snail[i][j] = 2 * (m + n) - 3 - i;
				}
			}
		}
		for (int[] i : snail) {
			for (int j : i) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
		sc.close();
	}
}
