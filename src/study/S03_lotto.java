package study;

import java.util.Arrays;
import java.util.Scanner;

public class S03_lotto {
	// 로또 게임
	// Scanner로 로또번호 6개 입력 받음(중복 번호, 1~45 범위 바깥이면 다시 입력하도록)
	// 랜덤 로또 당첨 번호 추출
	// 두 배열 정렬 후 출력하고
	// 당첨 여부 확인해서 몇 개 맞췄는지 출력
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 로또번호, 당첨번호 배열
		int[] select = new int[6];
		int[] lotto = new int[6];

		// select에 로또번호 저장
		for (int i = 0; i < 6; i++) {
			System.out.printf("로또번호(1~45) %d번째 숫자 입력 >>> ", i + 1);
			int input = sc.nextInt();

			// 로또번호 조건
			if (input < 1 || input > 45) {
				i--;
			} else {
				for (int j = 0; j < i; j++) {
					if (select[j] == input) {
						i--;
						break;
					}
				}
				select[i] = input;
			}
		}

		// lotto에 당첨번호 저장
		for (int i = 0; i < 6; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[j] == lotto[i]) {
					i--;
					break;
				}
			}
		}

		// 정렬
		int tmp;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				if (select[j] > select[j + 1]) {
					tmp = select[j];
					select[j] = select[j + 1];
					select[j + 1] = tmp;
				}
				if (lotto[j] > lotto[j + 1]) {
					tmp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = tmp;
				}
			}
		}

		// 두 배열 출력
		System.out.println("선택 번호: " + Arrays.toString(select));
		System.out.println("당첨 번호: " + Arrays.toString(lotto));

		// 두 배열 비교
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (select[j] == lotto[i]) {
					cnt++;
				}
			}
		}

		// 결과 출력
		if (cnt == 6) {
			System.out.printf("맞은 개수 - %d. => 당첨되었습니다.", cnt);
		} else {
			System.out.printf("맞은 개수 - %d. => 당첨되지 않았습니다.", cnt);
		}

		sc.close();
	}
}
