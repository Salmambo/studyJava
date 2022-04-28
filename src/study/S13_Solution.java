//2022.04.28.
package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S13_Solution {

//	// Lv.1 - 서울에서 김서방 찾기
//	// String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아,
//	// "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요.
//	// seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
//	// seoul은 길이 1 이상, 1000 이하인 배열입니다.
//	// seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
//	// "Kim"은 반드시 seoul 안에 포함되어 있습니다.
//	/* 예시
//	 * seoul			return
//	 * ["Jane","Kim"]	"김서방은 1에 있다"
//	 */
//	public String solution(String[] seoul) {
//		String answer = "";
//		for (int i = 0; i < seoul.length; i++) {
//			if (seoul[i].equals("Kim")) {
//				answer = "김서방은 " + i + "에 있다";
//			}
//		}
//		return answer;
//	}

//	// Lv.1 - 문자열 다루기 기본
//	// 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
//	// s는 길이 1 이상, 길이 8 이하인 문자열입니다.
//	/* 예시
//	 * s		return
//	 * "a234"	false
//	 * "1234"	true
//	 */
//	public boolean solution(String s) {
//		return ((s.length() == 4 || s.length() == 6) && s.matches("\\d*"));
//	}

//	// Lv.1 - 문자열 내림차순으로 배치하기
//	// 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
//	// s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
//	// str은 길이 1 이상인 문자열입니다.
//	/* s			return
//	 * "Zbcdefg"	"gfedcbZ
//	 */
//	public String solution(String s) {
//		char[] array = s.toCharArray();
//		char min = ' ';
//		for (int i = 0; i < array.length - 1; i++) {
//			for (int j = i + 1; j < array.length; j++) {
//				if (array[i] < array[j]) {
//					min = array[i];
//					array[i] = array[j];
//					array[j] = min;
//				}
//			}
//		}
//		return String.valueOf(array);
//	}

//	// Lv.1 - 문자열 내 p와 y의 개수
//	// 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
//	// s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
//	// 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.
//	// 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
//	// 문자열 s의 길이 : 50 이하의 자연수
//	// 문자열 s는 알파벳으로만 이루어져 있습니다.
//	/* 예시
//	 * s			answer
//	 * "pPoooyY"	true
//	 * "Pyy"		false
//	 */
//	boolean solution(String s) {
//		int p = 0, y = 0;
//		for (int i = 0; i < s.length(); i++) {
//			// p면 올리고 y면 내리는 식으로 변수를 하나만 쓰는 것도 가능
//			if (s.charAt(i) == 'p' || s.charAt(i) == 'P')
//				p++;
//			if (s.charAt(i) == 'y' || s.charAt(i) == 'Y')
//				y++;
//		}
//		return (p == y);
//		// 한 줄 가능
//		// s를 toUpperCase()나 toLowerCase() 한 뒤 filter로 p와 y를 특정 문자로 바꾸고 count()를 비교
//	}

//	// Lv.1 - 문자열 내 마음대로 정렬하기
//	// 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
//	// 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
//	// strings는 길이 1 이상, 50이하인 배열입니다.
//	// strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
//	// strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
//	// 모든 strings의 원소의 길이는 n보다 큽니다.
//	// 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
//	/* 예시
//	 * strings					n	return
//	 * ["sun","bed","car"]		1	["car","bed","sun"]
//	 * ["abce","abcd","cdx"]	2	["abcd","abce","cdx"]
//	 */
//	public String[] solution(String[] strings, int n) {
//		Arrays.sort(strings); // 먼저 사전순으로 정렬
//		while (true) { // 단어 속 문자 따라 돌고돌고돌고 더 이상 바뀌지 않을 때까지 0번 단어부터 처음부터 돌려
//			String tmp = ""; // while이 다시 돌 때마다 초기화
//			for (int i = 0; i < strings.length - 1; i++) { // 배열 속 단어 하나씩 꺼내어
//				// 꺼낸 단어 속 문자가 그 단어 다음 단어의 문자보다 클 때 자리교체
//				if (strings[i].charAt(n) > strings[i + 1].charAt(n)) {
//					tmp = strings[i];
//					strings[i] = strings[i + 1];
//					strings[i + 1] = tmp;
//				}
//			}
//			if (tmp.equals("")) // for문에서 자리교체가 단 한 번도 없으면 tmp는 null 그대로라서
//				break; // while 종료시켜
//		}
//		return strings;
//	}

//	// Lv.1 - 두 정수 사이의 합
//	// 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
//	// a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
//	// a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
//	// a와 b의 대소관계는 정해져있지 않습니다.
//	/* 예시
//	 * a	b	return
//	 * 3	5	12
//	 * 3	3	3
//	 * 5	3	12
//	 */
//	public long solution(int a, int b) {
//		long answer = 0;
//		if (a == b) // 무의미. a,b 같으면 어차피 for문 한 바퀴 돌고 끝
//			return a;
//		for (int i = Math.min(a, b); i <= Math.max(a, b); i++)
//			answer += i;
//		return answer;
//	}

//	// Lv.1 - 나누어 떨어지는 숫자 배열
//	// array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을
//	// 작성해주세요.
//	// divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
//	// arr은 자연수를 담은 배열입니다.
//	// 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
//	// divisor는 자연수입니다.
//	// array는 길이 1 이상인 배열입니다.
//	/* 예시
//	 * arr			divisor		return
//	 * [5,9,7,10]	5			[5,10]
//	 * [2,36,1,3]	1			[1,2,3,36]
//	 * [3,2,6]		10			[-1]
//	 */
//	public int[] solution(int[] arr, int divisor) {
//		List<Integer> list = new ArrayList<>();
//		Arrays.sort(arr);
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] % divisor == 0) {
//				list.add(arr[i]);
//			}
//		}
//		return (list.size() == 0) ? new int[] { -1 } : list.stream().mapToInt(i -> i).toArray();
//
//		/* List 안 쓰는 방법
//		int[] answer = Arrays.stream(arr).filter(i -> i % divisor == 0).toArray();
//		Arrays.sort(answer);
//		return (answer.length == 0) ? new int[] { -1 } : answer; */
//	}

//	// Lv.1 - 같은 숫자는 싫어
//	// 배열 arr가 주어집니다.
//	// 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
//	// 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
//	// 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.
//	// 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
//	// 배열 arr의 크기 : 1,000,000 이하의 자연수
//	// 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
//	/* 예시
//	 * arr				answer
//	 * [1,1,3,3,0,1,1]	[1,3,0,1]
//	 * [4,4,4,3,3]		[4,3]
//	 */
//	public int[] solution(int[] arr) {
//		List<Integer> list = new ArrayList<>();
//		list.add(arr[0]);
//		for (int i = 1; i < arr.length; i++)
//			if (arr[i] != list.get(list.lastIndexOf(arr[i - 1])))
//				list.add(arr[i]);
//		return list.stream().mapToInt(i -> i).toArray();
//	}

	// Lv.1 - [1차] 다트 게임
	// 다트 게임은 총 3번의 기회로 구성된다.
	// 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
	// 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고
	// 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
	// 옵션으로 스타상(*), 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
	// 아차상(#) 당첨 시 해당 점수는 마이너스된다.
	// 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다.
	// 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다.
	// 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다.
	// Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
	// 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
	// 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
	/* 예시
	 * dartResult	answer	설명
	 * 1S2D*3T		37		1^1 * 2 + 2^2 * 2 + 3^3
	 * 1D2S#10S		9		1^2 + 2^1 * (-1) + 10^1
	 * 1D2S0T		3		1^2 + 2^1 + 0^3
	 * 1S*2T*3S		23		1^1 * 2 * 2 + 2^3 * 2 + 3^1
	 * 1D#2S*3S		5		1^2 * (-1) * 2 + 2^1 * 2 + 3^1
	 * 1T2D3D#		-4		1^3 + 2^2 + 3^2 * (-1)
	 * 1D2S3T*		59		1^2 + 2^1 * 2 + 3^3 * 2
	 */
	public int solution(String dartResult) {
		int[] number = new int[3];
		String[] letter = new String[3];
		int answer = 0;
		// 숫자
		String[] temp = dartResult.split("\\D");
		int i = 0;
		for (String string : temp)
			if (!string.equals("")) {
				number[i] = Integer.parseInt(string);
				i++;
			}
		// 문자
		temp = dartResult.split("\\d");
		i = 0;
		for (String string : temp)
			if (!string.equals("")) {
				letter[i] = string;
				i++;
			}
		// 연산
		for (i = 0; i < 3; i++) {
			if (i > 0 && option(letter[i]) == 2)
				number[i - 1] *= 2;
			number[i] = (int) Math.pow(number[i], bonus(letter[i])) * option(letter[i]);
		}
		for (i = 0; i < 3; i++)
			answer += number[i];
		return answer;
	}

	private int bonus(String letter) {
		if (letter.contains("S"))
			return 1;
		else if (letter.contains("D"))
			return 2;
		else if (letter.contains("T"))
			return 3;
		return 0;
	}

	private int option(String letter) {
		if (letter.matches("^.[#]$"))
			return -1;
		else if (letter.matches("^.[*]$"))
			return 2;
		else if (letter.matches("^.$"))
			return 1;
		return 0;
	}
}
