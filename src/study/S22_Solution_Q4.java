//2022.06.02.
package study;

import java.util.ArrayList;

public class S22_Solution_Q4 {

//	// Lv.1 - 소수 만들기
//	// 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
//	// 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때
//	// 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
//	// nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
//	// nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
//	/* 예시
//	 * nums			result
//	 * [1,2,3,4]	1
//	 * [1,2,7,6,4]	4
//	 */
//	public int solution(int[] nums) {
//		int answer = 0;
//		ArrayList<Integer> odd = new ArrayList<>();
//		ArrayList<Integer> even = new ArrayList<>();
//		for (int num : nums)
//			if (num % 2 == 0)
//				even.add(num);
//			else
//				odd.add(num);
//		for (int i = 0; i < odd.size(); i++)
//			for (int j = 0; j < even.size() - 1; j++)
//				for (int k = j + 1; k < even.size(); k++) {
//					int sum = odd.get(i) + even.get(j) + even.get(k);
//					for (int l = 2; l <= Math.sqrt(sum); l++) {
//						if (sum % l == 0)
//							break;
//						if (l == (int) Math.sqrt(sum))
//							answer++;
//					}
//				}
//		if (odd.size() > 2)
//			for (int i = 0; i < odd.size() - 2; i++)
//				for (int j = i + 1; j < odd.size() - 1; j++)
//					for (int k = j + 1; k < odd.size(); k++) {
//						int sum = odd.get(i) + odd.get(j) + odd.get(k);
//						for (int l = 2; l <= Math.sqrt(sum); l++) {
//							if (sum % l == 0)
//								break;
//							if (l == (int) Math.sqrt(sum))
//								answer++;
//						}
//					}
//		return answer;
//	}

	// Lv.1 - 내적
	// 길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다.
	// a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.
	// 이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)
	// a, b의 길이는 1 이상 1,000 이하입니다.
	// a, b의 모든 수는 -1,000 이상 1,000 이하입니다.
	/* 예시
	 * a			b				result
	 * [1,2,3,4]	[-3,-1,0,2]		3
	 * [-1,0,1]		[1,0,-1]		-2
	 */
	public int solution(int[] a, int[] b) {
		int answer = 0;
		for (int i = 0; i < a.length; i++)
			answer += (a[i] * b[i]);
		return answer;
	}

	// Lv.1 - 음양 더하기
	// 어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와
	// 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다.
	// 실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.
	// absolutes의 길이는 1 이상 1,000 이하입니다.
	// absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
	// signs의 길이는 absolutes의 길이와 같습니다.
	// signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.
	/* 예시
	 * absolutes	signs				result
	 * [4,7,12]		[true,false,true]	9
	 * [1,2,3]		[false,false,true]	0
	 */
	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < signs.length; i++)
			answer += (signs[i] ? absolutes[i] : (-1) * absolutes[i]);
		return answer;
	}

	// Lv.1 - 없는 숫자 더하기
	// 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
	// numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
	// 1 ≤ numbers의 길이 ≤ 9
	// 0 ≤ numbers의 모든 원소 ≤ 9
	// numbers의 모든 원소는 서로 다릅니다.
	/* 예시
	 * numbers				result
	 * [1,2,3,4,6,7,8,0]	14
	 * [5,8,4,0,6,7,9]		6
	 */
	public int solution(int[] numbers) {
		int answer = 45;
		for (int number : numbers)
			answer -= number;
		return answer;
	}
}
