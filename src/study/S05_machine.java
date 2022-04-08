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
	int a, b; // 식별번호, 가스보유량

	// main
	public static void main(String[] args) {

		// 입체기동장치 개수 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("입체기동장치의 개수 n을 입력하시오.");
		int n = sc.nextInt();
		S05_machine[] machines = new S05_machine[n]; // 입체기동장치 배열

		// 각 입체기동장치에 식별번호 및 가스보유량 부여
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
		int tmpNum, tmpGas; // 정렬을 위한 임시변수
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (machines[i].a > machines[j].a) { // 식별번호 오름차순 정렬
					tmpNum = machines[i].a;
					machines[i].a = machines[j].a;
					machines[j].a = tmpNum;
					tmpGas = machines[i].b; // 가스보유량을 묶어서 이동
					machines[i].b = machines[j].b;
					machines[j].b = tmpGas;
				}
			}
		}
		System.out.println("식별번호\t:\t가스보유량");
		for (int i = 0; i < n; i++) {
			System.out.println(machines[i].a + "\t:\t" + machines[i].b);
		}
		sc.close();
	}
}
