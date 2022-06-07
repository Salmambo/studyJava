//2022.06.07.
package study;

import java.util.HashMap;

public class S24_Solution_Q4 {

	// Lv.1 - 키패드 누르기
	// 스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀 있습니다.
	// <kakao_phone1.png>
	// 이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
	// 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며,
	/* 엄지손가락을 사용하는 규칙은 다음과 같습니다.
	 * 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
	 * 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
	 * 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
	 * 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
	 * 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
	 */
	// 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
	// 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를
	// 완성해주세요.
	// numbers 배열의 크기는 1 이상 1,000 이하입니다.
	// numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
	// hand는 "left" 또는 "right" 입니다.
	// "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
	// 왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
	/* 예시
	 * numbers								hand		result
	 * [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"		"LRLLLRLLRRL"
	 * [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"		"LRLLRRLLLRR"
	 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]		"right"		"LLRLLRLLRL"
	 */
	public String solution(int[] numbers, String hand) {
		String answer = "";
		String left = "*";
		String right = "#";
		HashMap<String, String> keypad = new HashMap<>();
		keypad.put("1", "00");
		keypad.put("2", "01");
		keypad.put("3", "02");
		keypad.put("4", "10");
		keypad.put("5", "11");
		keypad.put("6", "12");
		keypad.put("7", "20");
		keypad.put("8", "21");
		keypad.put("9", "22");
		keypad.put("*", "30");
		keypad.put("0", "31");
		keypad.put("#", "32");
		for (int number : numbers)
			if (number == 1 || number == 4 || number == 7) {
				answer += "L";
				left = String.valueOf(number);
			} else if (number == 3 || number == 6 || number == 9) {
				answer += "R";
				right = String.valueOf(number);
			} else {
				int l = Math.abs(keypad.get(String.valueOf(number)).charAt(0) - keypad.get(left).charAt(0))
						+ Math.abs(keypad.get(String.valueOf(number)).charAt(1) - keypad.get(left).charAt(1));
				int r = Math.abs(keypad.get(String.valueOf(number)).charAt(0) - keypad.get(right).charAt(0))
						+ Math.abs(keypad.get(String.valueOf(number)).charAt(1) - keypad.get(right).charAt(1));
				if (l > r) {
					answer += "R";
					right = String.valueOf(number);
				} else if (l < r) {
					answer += "L";
					left = String.valueOf(number);
				} else {
					if (hand.equals("left")) {
						answer += "L";
						left = String.valueOf(number);
					} else {
						answer += "R";
						right = String.valueOf(number);
					}
				}
			}
		return answer;
	}

//	// Lv.1 - 숫자 문자열과 영단어
//	// 네오와 프로도가 숫자놀이를 하고 있습니다.
//	// 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
//	/* 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
//	 * 1478 → "one4seveneight"
//	 * 234567 → "23four5six7"
//	 * 10203 → "1zerotwozero3"
//	 */
//	// 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
//	// s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
//	/* 참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.
//	 * 숫자	영단어
//	 * 0	zero
//	 * 1	one
//	 * 2	two
//	 * 3	three
//	 * 4	four
//	 * 5	five
//	 * 6	six
//	 * 7	seven
//	 * 8	eight
//	 * 9	nine
//	 */
//	// 1 ≤ s의 길이 ≤ 50
//	// s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
//	// return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.
//	/* 예시
//	 * s					result
//	 * "one4seveneight"		1478
//	 * "23four5six7"		234567
//	 * "2three45sixseven"	234567
//	 * "123"				123
//	 */
//	public int solution(String s) {
//		return Integer.parseInt(s.replaceAll("one", "1").replaceAll("two", "2").replaceAll("three", "3")
//				.replaceAll("four", "4").replaceAll("five", "5").replaceAll("six", "6").replaceAll("seven", "7")
//				.replaceAll("eight", "8").replaceAll("nine", "9").replaceAll("zero", "0"));
//	}

	// Lv.1 - 신규 아이디 추천
	// 카카오에 입사한 신입 개발자 네오는 "카카오계정개발팀"에 배치되어,
	// 카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 담당하게 되었습니다.
	// "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때,
	// 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
	/* 다음은 카카오 아이디의 규칙입니다.
	 * 아이디의 길이는 3자 이상 15자 이하여야 합니다.
	 * 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
	 * 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
	 */
	// "네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해
	// 신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞는 지 검사하고
	// 규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.
	/* 신규 유저가 입력한 아이디가 new_id 라고 한다면,
	 * new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
	 * new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
	 * new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	 * new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
	 * new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
	 * new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	 * 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
	 * new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	 */
	// 신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때,
	// "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.
	// new_id는 길이 1 이상 1,000 이하인 문자열입니다.
	// new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
	// new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.
	/* 예시
	 * no	new_id							result
	 * 예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
	 * 예2	"z-+.^."						"z--"
	 * 예3	"=.="							"aaa"
	 * 예4	"123_.def"						"123_.def"
	 * 예5	"abcdefghijklmn.p"				"abcdefghijklmn"
	 */
	public String solution(String new_id) {
		String answer = new_id.toLowerCase().replaceAll("[^\\w|_|.|-]", "").replaceAll("[.]+", ".");
		if (answer.startsWith("."))
			answer = answer.substring(1);
		if (answer.endsWith("."))
			answer = answer.substring(0, answer.length() - 1);
		if (answer.isEmpty())
			answer = "a";
		if (answer.length() > 15)
			answer = answer.substring(0, 15);
		if (answer.endsWith("."))
			answer = answer.substring(0, answer.length() - 1);
		while (answer.length() < 3)
			answer += answer.charAt(answer.length() - 1);
		return answer;
	}

	// Lv.1 - 로또의 최고 순위와 최저 순위
	// 로또 6/45(이하 '로또'로 표기)는 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다.
	// 아래는 로또의 순위를 정하는 방식입니다.
	/* 순위		당첨 내용
	 * 1		6개 번호가 모두 일치
	 * 2		5개 번호가 일치
	 * 3		4개 번호가 일치
	 * 4		3개 번호가 일치
	 * 5		2개 번호가 일치
	 * 6(낙첨)	그 외
	 */
	// 로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다.
	// 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다.
	// 당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.
	// 민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다.
	// 이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
	// lottos는 길이 6인 정수 배열입니다.
	// lottos의 모든 원소는 0 이상 45 이하인 정수입니다.
	// 0은 알아볼 수 없는 숫자를 의미합니다.
	// 0을 제외한 다른 숫자들은 lottos에 2개 이상 담겨있지 않습니다.
	// lottos의 원소들은 정렬되어 있지 않을 수도 있습니다.
	// win_nums은 길이 6인 정수 배열입니다.
	// win_nums의 모든 원소는 1 이상 45 이하인 정수입니다.
	// win_nums에는 같은 숫자가 2개 이상 담겨있지 않습니다.
	// win_nums의 원소들은 정렬되어 있지 않을 수도 있습니다.
	/* 예시
	 * lottos					win_nums					result
	 * [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]		[3, 5]
	 * [0, 0, 0, 0, 0, 0]		[38, 19, 20, 40, 15, 25]	[1, 6]
	 * [45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]		[1, 1]
	 */
	public int[] solution(int[] lottos, int[] win_nums) {
		int zero = 0, match = 0;
		for (int lotto : lottos) {
			if (lotto == 0) {
				zero++;
				continue;
			}
			for (int win_num : win_nums)
				if (lotto == win_num) {
					match++;
					break;
				}
		}
		return new int[] { rank(match + zero), rank(match) };
	}

	private int rank(int i) {
		switch (i) {
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default:
			return 6;
		}
	}
}
