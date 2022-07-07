//2022.07.07.
package study;

public class S37_Solution_Q2 {

	// Lv.2 - k진수에서 소수 개수 구하기
	// 양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때,
	// 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.
	/* 0P0처럼 소수 양쪽에 0이 있는 경우
	 * P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
	 * 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
	 * P처럼 소수 양쪽에 아무것도 없는 경우
	 * 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
	 */
	// 정수 n과 k가 매개변수로 주어집니다.
	// n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를
	// return 하도록 solution 함수를 완성해 주세요.
	/* 예시
	 * n		k	result
	 * 437674	3	3
	 * 110011	10	2
	 */
	public int solution(int n, int k) {
		int answer = 0;
//		String notation = "";
//		while (n != 0) {
//			notation = n % k + notation;
//			n /= k;
//		}
//		String[] primes = notation.split("0");
		// 한 줄로 줄이는 방법 +압도적인 효율성
		String[] primes = Integer.toString(n, k).split("0");

		for (String prime : primes) {
			if (prime.isEmpty() || prime.equals("1"))
				continue;
			if (prime.equals("2"))
				answer++;
			else if (prime(Long.parseLong(prime)))
				answer++;
		}
		return answer;
	}

	private boolean prime(long prime) {
		for (int i = 2; i <= Math.sqrt(prime); i++)
			if (prime % i == 0)
				return false;
		return true;
	}

	// Lv.2 - 멀리 뛰기
	// 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다.
	// 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내,
	// 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요.
	/* 예시
	 * n	result
	 * 4	5
	 * 3	3
	 */
	public long solution(int n) {
		// 1=1, 2=2, 3=3, 4=5, 5=8, 6=13 ... f(n) = f(n-1) + f(n-2)
		long[] f = new long[n + 1];
		f[0] = f[1] = 1;
		for (int i = 2; i <= n; i++)
			// (A + B) % C = (A % C + B % C) % C
			f[i] = (f[i - 1] % 1234567 + f[i - 2] % 1234567) % 1234567;
		return f[n];
	}
}
