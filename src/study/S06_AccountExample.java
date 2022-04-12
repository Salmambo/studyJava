//2022.04.11.
package study;

import java.util.Scanner;

public class S06_AccountExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		S06_BankApplication bankApp = new S06_BankApplication(); // 메소드를 불러오기 위한 변수
		boolean run = true;

		while (run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.송금 | 6.종료");
			System.out.println("-------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();

			// 선택 번호에 따른 메소드 실행
			switch (selectNo) {
			case 1:
				bankApp.createAccount();
				break;
			case 2:
				bankApp.accountList();
				break;
			case 3:
				bankApp.deposit();
				break;
			case 4:
				bankApp.withdraw();
				break;
			case 5:
				bankApp.remit();
				break;
			default:
				System.out.println("1~5 중에서 입력하시오.");
				break;
			case 6:
				System.out.println("프로그램 종료");
				run = false;
			}
		}

		scanner.close();
	}
}
