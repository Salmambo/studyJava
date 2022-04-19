//2022.04.17~2022.04.19
package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S07_bankProjcet_example {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		List<Object> accounts = new ArrayList<Object>();

//		while (run) {
//			double balance = Math.round((Math.random() * 10000 + 500) / 1000) * 1000;
//			System.out.println(balance);
//			if (balance >= 10000)
//				run = false;
//		}

//		System.out.println("계좌주명");
//		String owner = scanner.nextLine().replace(" ", "");
//		System.out.print(owner);

//		System.out.print("계좌 비밀번호로 사용할 6자리 숫자를 입력해주십시오. >> ");
//		while (run) {
//			String tmp = scanner.nextLine();
//			System.out.println(tmp);
//			if (tmp.matches("^[0-9]*$")) {
//				int setPassword = Integer.parseInt(tmp);
//				if ((int) (Math.log10(setPassword) + 1) == 6) {
//					run = false;
//				} else {
//					System.out.println("숫자 6개를 입력해주십시오. >> ");
//				}
//			} else {
//				System.out.println("숫자만 입력해주십시오. >> ");
//			}
//		}

//		System.out.println("계좌번호");
//		String num = scanner.nextLine().replaceAll(" |-", "");
//		num = num.substring(0, 3) + "-" +num.substring(3, 6) + "-" + num.substring(6);
//		System.out.println(num);

//		System.out.print("개설을 희망하시는 고객님의 성함을 입력해주십시오. >> ");
//		String owner = scanner.nextLine().replace(" ", "");
//		System.out.print("계좌 비밀번호로 사용할 6자리 숫자를 입력해주십시오. >> ");
//		String tmp = scanner.nextLine();
//		int setPassword = Integer.parseInt(tmp);
//		accounts.add(owner);
//		accounts.add(setPassword);
//		for(Object account : accounts) {
//			System.out.println(account);
//		}
//		System.out.println(accounts);

		System.out.println(accounts.size());
		List<Object> account = new ArrayList<Object>(3);
		System.out.println(account.size());
		accounts.add("오브젝트");
		account.add(1);
		System.out.println(accounts.size());
		System.out.println(account.size());
		account.add(2);
		account.add(3);
		account.add(4);
		System.out.println(account.size());
		System.out.println(account);
		int count = 0;
		while (accounts.size() < 10) {
			count++;
			accounts.add(count);
		}
		System.out.println(accounts);

		scanner.close();
	}
}
