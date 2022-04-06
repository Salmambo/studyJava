package study;
//2022.03.31.

import java.io.IOException;
import java.util.Scanner;

public class S01_convertor {
	public static void main(String[] args) throws IOException {
		// 2개의 거리를 입력받아 두 거리의 차이를 System에 출력하시오. - 소수점 셋째 자리까지
		// 1ft = 3.281m로 변환된다.
		// 거리를 입력받기 전에 입력받을 단위를 선택 후 입력받는다.
		// 조건: 거리를 입력하기 전에 입력할 단위를 먼저 선택한다.
		System.out.print("m->ft: 1, ft->m: 2    선택 >>> ");

		// 입력받은 값을 받고
		int num = System.in.read() - '0';
		// 엔터키 값 없애고
		System.in.skip(2);
		// 숫자 두 개 받으려면 Scanner
		Scanner sc = new Scanner(System.in);
		// 앞서 받은 값에 따라 if문 진행
		if (num == 1) {
			System.out.println("m수를 두 개 입력하시오.(띄어쓰기로 두 개를 구분) >>> ");
			// 입력받은 숫자 두 개를 각각 변수로
			float m1 = sc.nextFloat();
			float m2 = sc.nextFloat();
			// 위 둘을 연산하기 위한 변수 및 if문
			float meter = 0.0f;
			if (m1 > m2) {
				meter = m1 - m2;
			} else {
				meter = m2 - m1;
			}
			// 미터를 피트로
			float feet = meter * 3.281f;
			System.out.printf("%.3f ft", feet);
		} else if (num == 2) {
			System.out.println("ft수를 두 개 입력하시오.(띄어쓰기로 두 개를 구분) >>> ");
			// 입력받은 숫자 두 개를 각각 변수로
			float f1 = sc.nextFloat();
			float f2 = sc.nextFloat();
			// 위 둘을 연산하기 위한 변수 및 if문
			float feet = 0.0f;
			if (f1 > f2) {
				feet = f1 - f2;
			} else {
				feet = f2 - f1;
			}
			// 피트를 미터로
			float meter = feet / 3.281f;
			System.out.printf("%.3f m", meter);
		}
		// Scanner 종료
		sc.close();
	}
}
