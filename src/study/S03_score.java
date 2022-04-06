package study;
//2022.04.06.

import java.util.Scanner;

public class S03_score {
	public static void main(String[] args) {
		// 학생 수와 각 학생들의 점수를 입력받아서, 최고 점수 및 평균 점수를 구하시오.
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				System.out.print("학생수> ");
				studentNum = scanner.nextInt();
				scores = new int[studentNum]; // 선언했던 scores를 학생수만큼의 배열로 초기화
			} else if (selectNo == 2) {
				for (int i = 0; i < studentNum; i++) {
					System.out.print("scores[" + i + "]> ");
					scores[i] = scanner.nextInt(); // 배열의 i번 값마다 입력값 저장
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < studentNum; i++) { // 배열의 내용을 출력
					System.out.printf("scores[%d]: %d\n", i, scores[i]);
				}
			} else if (selectNo == 4) {
				int max = 0, sum = 0;
				double avg = 0.0;
				for (int i = 0; i < studentNum; i++) {
					if (scores[i] > max) { // 최고 점수
						max = scores[i];
					}
					sum += scores[i]; // 평균을 위한 총합
				}
				avg = (double) sum / studentNum; // 평균 점수
				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수: " + avg);
			} else if (selectNo == 5) {
				run = false;
			}
		}

		System.out.println("프로그램 종료");

		scanner.close();
	}
}
