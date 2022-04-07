package study;
//2022.04.07.

import java.util.Scanner;

public class S04_snail {
	public static void main(String[] args) {
		// 다음과 같은 n*m 배열 구조를 출력하시오.
		// 입력이 3 4인 경우,
		/*
		 * 1  2  3  4
		 * 8  7  6  5
		 * 9  10 11 12
		 */
		// 입력이 4 5인 경우,
		/*
		 * 1  2  3  4  5
		 * 10 9  8  7  6
		 * 11 12 13 14 15
		 * 20 19 18 17 16
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("n m >>> ");
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] snail = new int[n][m];
		int cnt = 0; // snail 배열에 넣을 값
		for (int i = 0; i < n; i++) { // snail의 행
			for (int j = 0; j < m; j++) { // 행의 내용
				cnt++; // i행의 j를 추출할 때마다 1씩 더해줌
				snail[i][j] = cnt; // 1씩 올라간 cnt를 저장
			}
		}
		int tmp; // 1 ~ n*m으로 채운 snail을 정렬하기 위한 변수
		for (int i = 1; i < n; i += 2) { // 짝수 번째 행들을 추출
			for (int j = 0; j < m - 1; j++) { // 그 행들의 열을 추출
				for (int k = j + 1; k < m; k++) { // 그의 오른쪽 열을 추출
					if (snail[i][j] < snail[i][k]) { // 짝수 번째 행 안에서 오름차순으로 정렬
						tmp = snail[i][j];
						snail[i][j] = snail[i][k];
						snail[i][k] = tmp;
					}
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
