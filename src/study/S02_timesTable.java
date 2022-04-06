package study;

import java.util.Scanner;

public class S02_timesTable {
	public static void main(String[] args) {
		// 시작 단과 마지막 단을 입력하면 그 구간의 구구단을 출력하는 프로그램을 작성하시오.
		// 입력: 2 3
		/*
		 * 2*1=2
		 * 2*2=4
		 * ...
		 * 2*9=18
		 * 3*1=3
		 * 3*2=6
		 * ...
		 * 3*9=27
		 */
		// 시작 단과 마지막 단 출력 후 다시 입력 받는다. 숫자 0 입력시 종료.

		// 입력 받기 위한 스캐너와 변수 생성
		Scanner sc = new Scanner(System.in);
		int first, last;
		// 출력 후 재입력 받기 위한 while
		while (true) {
			// 시작 단과 마지막 단 입력 받아 초기화
			System.out.println("시작 단과 마지막 단 입력, 0 입력 시 종료");
			first = sc.nextInt();
			last = sc.nextInt();
			// 0 입력시 종료
			if (first == 0 || last == 0) {
				System.out.println("구구단 끝");
				break;
			} else {
				// for 구구단
				for (int i = first; i <= last; i++) {
					for (int j = 1; j < 10; j++) {
						System.out.printf("%d*%d=%d\n", i, j, i * j);
					}
				}
			}
		}
		// 종료
		sc.close();
	}
}
