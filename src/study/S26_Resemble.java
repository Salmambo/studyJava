//2022.06.09.
package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S26_Resemble {

	// 1부터 N까지의 정수가 한 번씩 등장하는 길이 N의 수열이 있다.
	// 여기서 당신은 연속된 K개의 정수를 골라서 한 곳에 잠시 모아둘 수 있다.
	// 시간이 지나면 당신이 고른 K개의 정수들은 K개 중 가장 작은 정수가 된다.
	// 이 시간은 고려하지 않는다.
	// 여기서 이 수열을 모두 같은 수로 만들고자 할 때 최소 몇 번 골라야 하는지 구하는 프로그램을 작성하시오.
	/* 입력 형식
	 * 첫 줄에 공백으로 구분된 두 정수 N, K가 차례로 주어진다.
	 * - N은 수열의 길이를 나타내는 2 이상 10만 이하의 자연수다.
	 * - K는 한 번에 연속적으로 골라야 하는 정수의 개수를 나타내는 2 이상 N 이하의 자연수다.
	 * 두 번째 줄에는 공백으로 구분된 N개의 정수가 주어진다.
	 * - 각 정수는 1부터 N까지의 정수 중 하나이며, 같은 정수가 두 번 이상 나타나지 않는다.
	 */
	/* 출력 형식
	 * 주어진 수열을 모두 같은 수로 만들고자 할 때 골라야 하는 최소 횟수를 출력한다.
	 */
	/* 예시
	 * 입력(N K)		입력(수열)				출력
	 * 4 3			2 3 1 4					2
	 * 8 3			7 3 1 8 4 6 2 5			4
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
//		String sequence = br.readLine(); // 입력받아야 되니 사용하란 소리겠지만 없이 하는 게 편하다.
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		int cnt = 1;
		for (int i = k; i < n; i += (k - 1))
			cnt++;
		System.out.println(cnt);
	}
}
