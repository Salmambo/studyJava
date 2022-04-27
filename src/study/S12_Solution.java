//2022.04.27.
package study;

import java.util.ArrayList;
import java.util.List;

public class S12_Solution {

//	// Lv.1 - 자연수 뒤집어 배열로 만들기
//	// 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
//	// n은 10,000,000,000이하인 자연수입니다.
//	/* 예시
//	 * n		return
//	 * 12345	[5,4,3,2,1]
//	 */
//	public int[] solution(long n) {
//		int[] answer = new int[String.valueOf(n).length()];
//		int i = 0;
//		while (n != 0) {
//			answer[i] = (int) (n % 10);
//			n /= 10;
//			i++;
//		}
//		return answer;
//	}

//	// Lv.1 - 자릿수 더하기
//	// 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
//	// N의 범위 : 100,000,000 이하의 자연수
//	/* 예시
//	 * N	answer
//	 * 123	6
//	 * 987	24
//	 */
//	public int solution(int n) {
//		return String.valueOf(n).chars().map(ch -> ch - '0').sum();
//	}

//	// Lv.1 - 이상한 문자 만들기
//	// 문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
//	// 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
//	// 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
//	// 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
//	// 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
//	/* 예시
//	 * s					return
//	 * "try hello world"	"TrY HeLlO WoRlD"
//	 */
//	public String solution(String s) {
//		String answer = "";
//		String[] string = s.split("");
//		int index = 0;
//		for (int i = 0; i < string.length; i++) {
//			if (string[i].equals(" ")) {
//				answer += string[i];
//				index = i + 1;
//				continue;
//			}
//			if ((i - index) % 2 == 0)
//				answer += string[i].toUpperCase();
//			else
//				answer += string[i].toLowerCase();
//		}
//		return answer;
//	}

//	// Lv.1 약수의 합
//	// 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
//	// n은 0 이상 3000이하인 정수입니다.
//	/* 예시
//	 * n	return
//	 * 12	28
//	 * 5	6
//	 */
//	public int solution(int n) {
//		int answer = 0;
//		for (int i = 1; i <= n; i++) {
//			if (n % i == 0)
//				answer += i;
//		}
//		return answer;
//	}

//	// Lv.1 - 시저 암호
//	// 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
//	// 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다.
//	// "z"는 1만큼 밀면 "a"가 됩니다.
//	// 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
//	// 공백은 아무리 밀어도 공백입니다.
//	// s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
//	// s의 길이는 8000이하입니다.
//	// n은 1 이상, 25이하인 자연수입니다.
//	/* 예시
//	 * s		n	result
//	 * "AB"		1	"BC"
//	 * "z"		1	"a"
//	 * "a B z"	4	"e F d"
//	 */
//	public String solution(String s, int n) {
//		String answer = "";
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) == ' ') {
//				answer += (char) (s.charAt(i));
//			} else if (s.charAt(i) > 96 && s.charAt(i) < 123) {
//				answer += (s.charAt(i) + n > 122) ? (char) (s.charAt(i) + n - 26) : (char) (s.charAt(i) + n);
//			} else {
//				answer += (s.charAt(i) + n > 90) ? (char) (s.charAt(i) + n - 26) : (char) (s.charAt(i) + n);
//			}
//		}
//		return answer;
//	}

//	// Lv.1 - 문자열을 정수로 바꾸기
//	// 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
//	// s의 길이는 1 이상 5이하입니다.
//	// s의 맨앞에는 부호(+, -)가 올 수 있습니다.
//	// s는 부호와 숫자로만 이루어져있습니다.
//	// s는 "0"으로 시작하지 않습니다.
//	/* 예시
//	 * str		return
//	 * 1234		1234
//	 * -1234	-1234
//	 */
//	public int solution(String s) {
//		return Integer.parseInt(s);
//	}

//	// Lv.1 - 수박수박수박수박수박수?
//	// 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
//	// n은 길이 10,000이하인 자연수입니다.
//	/* 예시
//	 * n	return
//	 * 3	"수박수"
//	 * 4	"수박수박"
//	 */
//	public String solution(int n) {
//		String answer = "";
//		for (int i = 0; i < n; i++) {
//			answer += (i % 2 == 0) ? "수" : "박";
//		}
//		return answer;
//	}

	// Lv.1 - 소수 찾기
	// 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
	// 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다. (1은 소수가 아닙니다.)
	// n은 2이상 1000000이하의 자연수입니다.
	/* 예시
	 * n	result
	 * 10	4
	 * 5	3
	 */
	public int solution(int n) {
		/* 시간초과
		int answer = 0;
		int[] array = new int[n + 1];
		for (int i = 2; i <= n; i++)
			array[i] = i;
		for (int i = 2; i <= n; i++) {
			if (array[i] == 0)
				continue;
			for (int j = i * i; j <= n; j += i)
				array[j] = 0;
		}
		for (int prime : array) {
			if (prime != 0)
				answer++;
		}
		return answer; */

		/* 시간초과
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= n; i++)
			list.add(i);
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (list.contains(i) == false)
				continue;
			for (int j = i * i; j <= n; j += i) {
				if (list.contains(j))
					list.remove(list.indexOf(j));
			}
		}
		return list.size(); */

		/* 시간초과 (효율성 테스트)
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			boolean prime = true;
			for (int j = 0; j < list.size(); j++) {
				if (i % list.get(j) == 0) {
					prime = false;
					break;
				}
			}
			if (prime)
				list.add(i);
		}
		return list.size(); */

		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (i > 2 && i % 2 == 0)
				continue;
			boolean prime = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					prime = false;
					break;
				}
			}
			if (prime)
				list.add(i);
		}
		return list.size();
	}
}
