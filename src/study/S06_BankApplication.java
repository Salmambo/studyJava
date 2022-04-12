//2022.04.11.
package study;

import java.util.Scanner;

public class S06_BankApplication {
	private static Scanner scanner = new Scanner(System.in);
	private static S06_Account[] accountArray = new S06_Account[100];
	private static String ano;
	private static String owner;
	private static int balance;

	// 계좌생성하기
	public void createAccount() {
		System.out.println("---------");
		System.out.println("계좌생성");
		System.out.println("---------");

		System.out.print("계좌번호: ");
		ano = scanner.next();
		System.out.print("계좌주: ");
		owner = scanner.next();
		System.out.print("초기 입금액: ");
		balance = scanner.nextInt();
		for (int i = 0; i < accountArray.length; i++) {
			// 배열의 빈 칸에 세 가지 필드를 가진 account 저장
			if (accountArray[i] == null) {
				S06_Account account = new S06_Account(ano, owner, balance);
				accountArray[i] = account;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		}
	}

	// 계좌목록보기
	public void accountList() {
		System.out.println("---------");
		System.out.println("계좌목록");
		System.out.println("---------");

		for (S06_Account account : accountArray) {
			// 배열의 비어있지 않은 칸들에서 필드들을 출력
			if (account != null) {
				System.out.printf("계좌번호:%s\t계좌주:%s\t잔고:%d\n", account.getAno(), account.getOwner(),
						account.getBalance());
			} else {
				break;
			}
		}
	}

	// 예금하기
	public void deposit() {
		System.out.println("---------");
		System.out.println("예금");
		System.out.println("---------");

		System.out.print("계좌번호: ");
		ano = scanner.next();
		System.out.print("예금액: ");
		balance = scanner.nextInt();
		for (S06_Account account : accountArray) {
			// 입력한 계좌번호가 있는 칸의 balance 필드를 수정
			if (account.getAno().equals(ano)) {
				account.setBalance(account.getBalance() + balance);
				System.out.println("결과: 예금이 성공되었습니다.");
				break;
			}
		}
	}

	// 출금하기
	public void withdraw() {
		System.out.println("---------");
		System.out.println("출금");
		System.out.println("---------");

		System.out.print("계좌번호: ");
		ano = scanner.next();
		System.out.print("출금액: ");
		balance = scanner.nextInt();
		for (S06_Account account : accountArray) {
			// 입력한 계좌번호가 있는 칸의 balance 필드를 수정
			if (account.getAno().equals(ano)) {
				account.setBalance(account.getBalance() - balance);
				System.out.println("결과: 출금이 성공되었습니다.");
				break;
			}
		}
	}

	public void remit() {
		System.out.println("---------");
		System.out.println("송금");
		System.out.println("---------\n보내시는 분의 계좌번호, 받으실 분의 계좌번호가 필요합니다.");

		System.out.print("보내시는 분의 계좌번호: ");
		ano = scanner.next();
		System.out.print("받으실 분의 계좌번호: ");
		String acc = scanner.next();
		System.out.print("송금액: ");
		balance = scanner.nextInt();
		for (S06_Account account : accountArray) {
			// ano 계좌번호가 있는 칸의 balance를 감소
			if (account.getAno().equals(ano)) {
				account.setBalance(account.getBalance() - balance);
				break;
			}
		}
		for (S06_Account account : accountArray) {
			// acc 계좌번호가 있는 칸의 balance를 증가
			if (account.getAno().equals(acc)) {
				account.setBalance(account.getBalance() + balance);
				break;
			}
		}
		System.out.println("결과: 송금이 성공되었습니다.");
	}
}
