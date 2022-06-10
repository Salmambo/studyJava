//2022.06.10.
package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S27_Exchange {

	// 최근 구름커피에서는 고객이 모은 쿠폰을 상품으로 교환해주는 이벤트를 진행하고 있었고,
	// 이를 알게 된 정수는 자신은 몇 개의 상품을 얻을 수 있을지 궁금해졌다.
	// 하지만 너무나 많은 쿠폰을 보유하고 있는 정수는 자신이 얻을 수 있는 최대의 상품 수를 계산하기가 어려웠다.
	// 정수의 쿠폰으로 얻을 수 있는 상품의 수를 계산해주는 프로그램을 작성하시오.
	// 현재 정수는 N개의 시즌 한정 음료 쿠폰과 M개의 일반 음료 쿠폰을 가지고 있다.
	/* 그리고 구름커피에서는 다음과 같은 조합으로 12장의 쿠폰을 제시하면 이를 상품으로 교환해주고 있다.
	 * 하나의 상품으로 교환하기 위해서는 12장의 쿠폰이 필요하다.
	 * 이 쿠폰들 중 최소 5개는 시즌 한정 음료 쿠폰이어야 한다.
	 */
	/* 입력 형식
	 * 첫 줄에는 테스트케이스의 수를 나타내는 1 이상 10000 이하의 자연수 T가 입력으로 주어진다.
	 * 이후 총 T개의 테스트케이스에 대한 입력이 차례로 주어진다.
	 * 각 테스트케이스에 대한 입력은 한 줄에 주어진다. 두 개의 정수 N, M이 공백으로 구분되어 차례로 주어진다.
	 * - N은 정수가 보유한 시즌 한정 음료 쿠폰의 수를 나타낸다.
	 * - M은 정수가 보유한 일반 음료 쿠폰의 수를 나타낸다.
	 * - N과 M은 모두 64비트 부호형 정수형 범위 내에 존재하는 0 이상의 정수다.
	 */
	/* 출력 형식
	 * 각 테스트케이스에 대한 정답을 순서대로 한 줄씩 출력한다.
	 * - 정수가 보유한 쿠폰으로 교환할 수 있는 최대 상품의 수를 계산하여 출력하시오.
	 */
	/* 예시
	 * 입력(T)	입력(T개의 테스트케이스)						출력
	 * 4		12 0 / 10 14 / 4 20 / 5 2147483648		1 / 2 / 0 / 1
	 */
	public static void main(String[] args) throws Exception {
		/* 시간초과
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] temp = br.readLine().split(" ");
			long season = Long.parseLong(temp[0]);
			long total = season + Long.parseLong(temp[1]);
			int exchange = 0;
			while (season > 4 && total > 11) {
				season -= 5;
				total -= 12;
				exchange++;
			}
			System.out.println(exchange);
		} */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] temp = br.readLine().split(" ");
			long season = Long.parseLong(temp[0]);
			long total = season + Long.parseLong(temp[1]);
			// 시즌쿠폰과 일반쿠폰의 구분없이 총 교환가능한 사은품의 수는 (N+M)/12개 이다.
			// 하지만 위의 만들 수 있는 세트도 최대 n/5개뿐이 만들지 못한다.
			// 따라서 둘중 더 작은값을 출력해주면 된다.
			System.out.println((season / 5 < total / 12) ? season / 5 : total / 12);
		}
	}
}
