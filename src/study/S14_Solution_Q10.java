//2022.04.29.
package study;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class S14_Solution_Q10 {

//	// Lv.1 - 가운데 글자 가져오기
//	// 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
//	// 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
//	// s는 길이가 1 이상, 100이하인 스트링입니다.
//	/* 예시
//	 * s		return
//	 * "abcde"	"c"
//	 * "qwer"	"we"
//	 */
//	public String solution(String s) {
//		float length = s.length() / 2.0f;
//		return s.substring(Math.round(length - 1), (int) length + 1);
//	}

//	// Lv.1 - 비밀지도
//	// 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
//	// 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
//	// 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
//	// 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
//	// "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
//	// 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때
//	// 얻어지는 이진수에 해당하는 값의 배열이다.
//	// 1 ≦ n ≦ 16
//	// arr1, arr2는 길이 n인 정수 배열로 주어진다.
//	// 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2n - 1을 만족한다.
//	/* 예시
//	 * n	arr1				arr2				출력
//	 * 5	[9,20,28,18,11]		[30,1,21,17,28]		["#####","# # #","### #","#  ##","#####"]
//	 * 6	[46,33,33,22,31,50]	[27,56,19,14,14,10]	["######","### #","## ##"," #### "," #####","### # "]
//	 */
//	public String[] solution(int n, int[] arr1, int[] arr2) {
//		String[] answer = new String[n];
//		for (int i = 0; i < n; i++) {
//			answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
//			while (answer[i].length() != n) { // if-for문 쓰면 조건만족 전에 멈춤
//				answer[i] = "0" + answer[i];
//			}
//			answer[i] = answer[i].replace('0', ' ').replace('1', '#');
//		}
//		return answer;
//	}

//	// Lv.1 - 부족한 금액 계산하기
//	// 놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다.
//	// 즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
//	// 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를
//	// return 하도록 solution 함수를 완성하세요.
//	// 단, 금액이 부족하지 않으면 0을 return 하세요.
//	// 놀이기구의 이용료 price : 1 ≤ price ≤ 2,500, price는 자연수
//	// 처음 가지고 있던 금액 money : 1 ≤ money ≤ 1,000,000,000, money는 자연수
//	// 놀이기구의 이용 횟수 count : 1 ≤ count ≤ 2,500, count는 자연수
//	/* 예시
//	 * price	money	count	result
//	 * 3		20		4		10
//	 */
//	public long solution(int price, int money, int count) {
//		long answer = money;
//		for (int i = 1; i <= count; i++)
//			answer -= price * i;
//		return (answer >= 0) ? 0 : Math.abs(answer);
//	}

//	// Lv.1 - 나머지가 1이 되는 수 찾기
//	// 자연수 n이 매개변수로 주어집니다.
//	// n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요.
//	// 답이 항상 존재함은 증명될 수 있습니다.
//	// 3 ≤ n ≤ 1,000,000
//	/* 예시
//	 * n	result
//	 * 10	3
//	 * 12	11
//	 */
//	public int solution(int n) {
//		for (int i = 1; i < n; i++)
//			if (n % i == 1)
//				return i;
//		return 0;
//	}

//	// Lv.1 - 최소직사각형
//	/* 아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.
//	 * 명함 번호	가로 길이	  세로 길이
//	 * 1		60		 50
//	 * 2		30		 70
//	 * 3		60		 30
//	 * 4		80		 40
//	 */
//	// 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면
//	// 모든 명함들을 수납할 수 있습니다. 하지만 2번 명함을 가로로 눕혀 수납한다면
//	// 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다.
//	// 이때의 지갑 크기는 4000(=80 x 50)입니다.
//	// 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
//	// 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
//	// sizes의 길이는 1 이상 10,000 이하입니다.
//	// sizes의 원소는 [w, h] 형식입니다.
//	// w는 명함의 가로 길이를 나타냅니다.
//	// h는 명함의 세로 길이를 나타냅니다.
//	// w와 h는 1 이상 1,000 이하인 자연수입니다.
//	/* 예시
//	 * sizes											result
//	 * [[60, 50], [30, 70], [60, 30], [80, 40]]			4000
//	 * [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
//	 * [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
//	 */
//	public int solution(int[][] sizes) {
//		int[] big = new int[sizes.length]; // [w, h] 중 큰 수를 담을 배열
//		int[] small = new int[sizes.length]; // [w, h] 중 작은 수를 담을 배열
//		int index = 0; // 배열에 쓸 인덱스 번호
//		// 두 배열에 쪼개 넣기
//		for (int[] size : sizes) {
//			// w가 h보다 클 경우와 아닐 경우
//			if (size[0] > size[1]) {
//				big[index] = size[0];
//				small[index] = size[1];
//				index++;
//			} else {
//				big[index] = size[1];
//				small[index] = size[0];
//				index++;
//			}
//		}
//		// big에서 가장 큰 수와 small에서 가장 큰 수를 곱해서 반환
//		return Arrays.stream(big).max().getAsInt() * Arrays.stream(small).max().getAsInt();
//	}

//	// Lv.1 - 2016년
//	// 2016년 1월 1일은 금요일입니다.
//	// 2016년 a월 b일은 무슨 요일일까요?
//	// 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
//	// 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다.
//	// 2016년은 윤년입니다.
//	// 2016년 a월 b일은 실제로 있는 날입니다.(13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
//	/* 예시
//	 * a	b	result
//	 * 5	24	"TUE"
//	 */
//	public String solution(int a, int b) {
//		return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
//	}

//	// Lv.1 - 두 개 뽑아서 더하기
//	// 정수 배열 numbers가 주어집니다.
//	// numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
//	// 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
//	// numbers의 길이는 2 이상 100 이하입니다.
//	// numbers의 모든 수는 0 이상 100 이하입니다.
//	/* 예시
//	 * numbers		result
//	 * [2,1,3,4,1]	[2,3,4,5,6,7]
//	 * [5,0,2,7]	[2,5,7,9,12]
//	 */
//	public int[] solution(int[] numbers) {
////		List<Integer> list = new ArrayList<>();
////		int index = 0;
////		while (index != numbers.length - 1) {
////			for (int i = index + 1; i < numbers.length; i++) {
////				if (!list.contains(numbers[index] + numbers[i]))
////					list.add(numbers[index] + numbers[i]);
////			}
////			index++;
////		}
////		Collections.sort(list);
////		return list.stream().mapToInt(i -> i).toArray();
//
//		// ArrayList 대신 TreeSet을 사용하면
//		// 알아서 중복을 걸러줘서 코드가 짧아지고
//		// 정렬도 해줘서 import가 줄어들고
//		// 그만큼 효율성도 올라간다.
//		Set<Integer> set = new TreeSet<>();
//		for (int i = 0; i < numbers.length - 1; i++)
//			for (int j = i + 1; j < numbers.length; j++)
//				set.add(numbers[i] + numbers[j]);
//		return set.stream().mapToInt(i -> i).toArray();
//	}

//	// Lv.1 - 예산
//	// 부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때,
//	// 최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.
//	// d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하입니다.
//	// d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1 이상 100,000 이하의 자연수입니다.
//	// budget은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수입니다.
//	/* 예시
//	 * d			budget	result
//	 * [1,3,2,5,4]	9		3
//	 * [2,2,3,3]	10		4
//	 */
//	public int solution(int[] d, int budget) {
//		int answer = 0;
//		Arrays.sort(d);
//		for (int i : d) {
//			budget -= i;
//			if (budget < 0)
//				break;
//			answer++;
//		}
//		return answer;
//	}

//	// Lv.1 - 3진법 뒤집기
//	// 자연수 n이 매개변수로 주어집니다.
//	// n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
//	// n은 1 이상 100,000,000 이하인 자연수입니다.
//	/* 예시
//	 * n	result
//	 * 45	7
//	 * 125	229
//	 */
//	public int solution(int n) {
//		int answer = 0;
//		String trit = "";
//		while (n != 0) {
//			trit = trit + String.valueOf(n % 3); // String.valueOf 안 적어도 됨
//			n /= 3;
//		}
//		// return Integer.parseInt(trit, 3);
//		// parseInt(a, b) - a(문자열이면 그 내용)를 b진법으로 해석
//		// 위가 짧지만 아래가 더 효율이 좋음
//		for (int i = 0; i < trit.length(); i++)
//			answer += (trit.charAt(i) - '0') * Math.pow(3, trit.length() - 1 - i);
//		return answer;
//	}

	// Lv.1 - 약수의 개수와 덧셈
	// 두 정수 left와 right가 매개변수로 주어집니다.
	// left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
	// 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
	// 1 ≤ left ≤ right ≤ 1,000
	/* 예시
	 * left	right	result
	 * 13	17		43
	 * 24	27		52
	 */
	public int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i <= right; i++)
			// 조건을 i % Math.sqrt(i) == 0 으로만 해도 충분
			answer += (i == Math.pow((int) Math.sqrt(i), 2)) ? -i : i;
		return answer;
	}
}
