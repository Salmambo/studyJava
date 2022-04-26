//2022.04.26.
package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class S11_Solution {

//	// Lv.1 - 짝수와 홀수
//	// 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
//	// num은 int 범위의 정수입니다.
//	// 0은 짝수입니다.
//	/* 예시
//	 * num	return
//	 * 3	"Odd"
//	 * 4	"Even"
//	 */
//	public String solution(int num) {
//		return (num % 2 == 0) ? "Even" : "Odd";
//	}

//	// Lv.1 - 제일 작은 수 제거하기
//	// 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
//	// 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
//	// arr은 길이 1 이상인 배열입니다.
//	// 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
//	/* 예시
//	 * arr			return
//	 * [4,3,2,1]	[4,3,2]
//	 * [10]			[-1]
//	 */
//	public int[] solution(int[] arr) {
////		if (arr.length == 1) {
////			arr[0] = -1;
////			return arr;
////		}
////		int min = arr[0];
////		for (int i = 1; i < arr.length; i++) {
////			if (min > arr[i])
////				min = arr[i];
////		}
////		int[] answer = new int[arr.length - 1];
////		int i = 0;
////		for (int j = 0; j < arr.length; j++) {
////			if (arr[j] != min) {
////				answer[i] = arr[j];
////				i++;
////			}
////		}
////		return answer;
//
//		// 스트림
//		if (arr.length == 1)
//			return new int[] { -1 }; // -1이 든 새로운 배열을 리턴
//		int min = Arrays.stream(arr).min().getAsInt();
//		return Arrays.stream(arr).filter(i -> i != min).toArray();
//		// filter(람다식): 스트림 arr의 내용 i들이 min과 같지 않도록 수정
//	}

//	// Lv.1 - 정수 제곱근 판별
//	// 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
//	// n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
//	// n은 1이상, 50000000000000 이하인 양의 정수입니다.
//	/* 예시
//	 * n	return
//	 * 121	144
//	 * 3	-1
//	 */
//	public long solution(long n) {
//		long x = (long) Math.sqrt(n); // sqrt(): 제곱근
//		if (x * x == n)
//			return (x + 1) * (x + 1);
//		else
//			return -1;
//	}

	// Lv.1 - 정수 내림차순으로 배치하기
	// 함수 solution은 정수 n을 매개변수로 입력받습니다.
	// n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
	// n은 1이상 8000000000 이하인 자연수입니다.
	/* 예시
	 * n		return
	 * 118372	873211
	 */
	public long solution(long n) {
		List<Long> list = new ArrayList<>();
		while (n != 0) {
			list.add(n % 10);
			n /= 10;
		}
		list.sort(Comparator.reverseOrder());
		for (int i = 0; i < list.size() - 1; i++) {
			list.set(i, list.get(i) * (int) Math.pow(10, (list.size() - i - 1)));
		}
		long answer = 0;
		for (long i : list) {
			answer += i;
		}
		return answer;
	}
}
