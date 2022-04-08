//2022.04.08.
package study;

import java.util.Scanner;

public class S05_machine {
	// 첫째 줄에 입체기동장치의 개수 n이 입력된다. (1 <= n <= 100)
	// 둘째 줄부터 n+1번째 줄까지 각 줄에 입체기동장치의 식별번호 a와 가스 보유량 b가 주어진다.
	// a는 중복될 수 없지만 b는 중복될 수 있다. (1 <= a <= 100), (0 <= b <= 10000)
	// 식별번호가 한 번 정해지면 그 입체기동장치의 가스 보유량은 정렬되더라도 변하지 않아야 한다.
	// 첫째 줄부터 n번째 줄까지 각 줄에 식별번호를 오름차순으로 정렬해 가스 보유량과 같이 출력한다.

	// field
	static S05_machine[] machines; // 입체기동장치 배열 생성
	int a, b; // 식별번호, 가스보유량

	// method
	static S05_machine[] input(int n) {
		machines = new S05_machine[n]; // 입체기동장치 배열 초기화
		for (int i = 0; i < n; i++) {
			S05_machine machine = new S05_machine(); // 배열의 행에 들어갈 각 입체기동장치
			machine.a = (int) (Math.random() * 99) + 2; // 1 <= a <= 100
			machine.b = (int) (Math.random() * 10000) + 1; // 0 <= b <= 10000
			machines[i] = machine; // 행마다 입체기동장치 하나씩 저장
			for (int j = 0; j < i; j++) { // 식별번호 중복 검사
				if (machines[j].a == machines[i].a) {
					i--;
					break;
				}
			}
		}
		return machines;
	}

	static void sort() {
		S05_machine tmp = new S05_machine(); // machine을 넣을 임시변수
		for (int i = 0; i < machines.length - 1; i++) {
			for (int j = i + 1; j < machines.length; j++) {
				if (machines[i].a > machines[j].a) { // 식별번호에 따른 오름차순 정렬
					tmp = machines[i];
					machines[i] = machines[j];
					machines[j] = tmp;
				}
			}
		}
	}

	static void show() {
		for (int i = 0; i < machines.length; i++) { // 행(machine)마다 출력
			System.out.println(machines[i]);
		}
	}

	@Override // show()가 주소가 아닌 내용을 토해내게 함
	public String toString() {
		return "[식별번호=" + a + ", 가스보유량=" + b + "]";
	}

	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입체기동장치 개수 입력
		int n;
		while (true) {
			System.out.println("입체기동장치의 개수 n을 입력하시오.");
			n = sc.nextInt();
			if (n < 1 || n > 100) {
				System.out.println("1~100 중에서 입력하시오.");
			} else {
				break;
			}
		}

		// 각 입체기동장치에 식별번호 및 가스보유량 부여
		input(n);

		// 정렬
		sort();

		// 출력
		show();

		sc.close();
	}
}
