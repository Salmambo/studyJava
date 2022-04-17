//2022.04.17~2022.04.
package study;

import java.util.Scanner;

public class S07_bankProjcet_example {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean run = true;

//		while (run) {
//			double balance = Math.round((Math.random() * 10000 + 500) / 1000) * 1000;
//			System.out.println(balance);
//			if (balance >= 10000)
//				run = false;
//		}

//		System.out.println("계좌주명");
//		String owner = scanner.nextLine().replace(" ", "");
//		System.out.print(owner);

		System.out.print("계좌 비밀번호로 사용할 6자리 숫자를 입력해주십시오. >> ");
		while (run) {
			String tmp = scanner.nextLine();
			System.out.println(tmp);
			if (tmp.matches("^[0-9]*$")) {
				int setPassword = Integer.parseInt(tmp);
				if ((int) (Math.log10(setPassword) + 1) == 6) {
					run = false;
				} else {
					System.out.println("숫자 6개를 입력해주십시오. >> ");
				}
			} else {
				System.out.println("숫자만 입력해주십시오. >> ");
			}
		}

		scanner.close();
	}
}
