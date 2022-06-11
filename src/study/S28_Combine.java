//2022.06.11.
package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S28_Combine {

	// 0부터 N-1까지의 정수가 하나씩 적힌 N장의 카드가 있다.
	// 이 중 K장의 카드를 뽑아 조합을 구성해야 한다. (같은 카드를 여러 번 뽑을 수 없다.)
	// 이때 뽑은 카드들의 적힌 숫자를 모두 더한 값이 N으로 나눠 떨어지도록 해야 한다.
	// 가능한 조합이 몇 가지인지 출력하는 프로그램을 작성하시오.
	/* 입력 형식
	 * 첫 번째 줄에 두 개의 정수 N, K가 공백으로 구분되어 주어진다.
	 * - N은 1 이상 1000 이하의 정수다.
	 * - K는 1 이상 47 이하의 정수다.
	 */
	/* 출력 형식
	 * 올바른 카드 조합의 총 가짓수를 출력한다.
	 * - 단 경우에 따라 숫자가 매우 커질 수 있으므로 1,000,000,007로 나눈 나머지를 출력한다.
	 */
	/* 예시
	 * 입력(N K)		출력
	 * 7 4			5
	 * 10 3			12
	 */
	private static long result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		long[] select = new long[k];
		combine(select, n, k, 0, 0);
		System.out.println(result % 1_000_000_007);
	}

	private static void combine(long[] select, int n, int k, int index, long value) {
		if (index == k) {
			long sum = 0;
			for (long i : select)
				sum += i;
			if (sum % n == 0)
				result++;
		} else if (value != n) {
			select[index] = value;
			combine(select, n, k, index + 1, value + 1);
			combine(select, n, k, index, value + 1);
		}
	}
}
