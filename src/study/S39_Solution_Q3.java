//2022.07.12.
package study;

import java.util.Stack;

public class S39_Solution_Q3 {

	// Lv.2 - 다음 큰 숫자
	/* 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
	 * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
	 * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
	 * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
	 */
	// 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
	/* 예시
	 * n	result
	 * 78	83
	 * 15	23
	 */
	public int solution(int n) {
		String binary = Integer.toBinaryString(n);
		int answer = 0, count = count(binary);
		while (true) {
			n++;
			binary = Integer.toBinaryString(n);
			if (count == count(binary)) {
				answer = n;
				break;
			}
		}
		return answer;
	}

	private int count(String binary) {
		int count = 0;
		for (int i = 0; i < binary.length(); i++)
			if (binary.charAt(i) == '1')
				count++;
		return count;
	}
	/* bitCount() 활용 - 변수 binary 및 함수 count() 필요 없어짐
	public int solution(int n) {
		int answer = 0, count = Integer.bitCount(n);
		while (true) {
			n++;
			if (count == Integer.bitCount(n)) {
				answer = n;
				break;
			}
		}
		return answer;
	}*/

	// Lv.2 - n진수 게임
	/* 이 게임은 여러 사람이 둥글게 앉아서 숫자를 하나씩 차례대로 말하는 게임인데, 규칙은 다음과 같다.
	 * 숫자를 0부터 시작해서 차례대로 말한다. 첫 번째 사람은 0, 두 번째 사람은 1, … 열 번째 사람은 9를 말한다.
	 * 10 이상의 숫자부터는 한 자리씩 끊어서 말한다.
	 * 즉 열한 번째 사람은 10의 첫 자리인 1, 열두 번째 사람은 둘째 자리인 0을 말한다.
	 */
	// 이진수로 진행하는 게임에 익숙해져 질려가던 사람들은 좀 더 난이도를 높이기 위해
	// 이진법에서 십육진법까지 모든 진법으로 게임을 진행해보기로 했다.
	/* 입력 형식
	 * 진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.
	 * 2 ≦ n ≦ 16
	 * 0 ＜ t ≦ 1000
	 * 2 ≦ m ≦ 100
	 * 1 ≦ p ≦ m
	 */
	/* 출력 형식
	 * 튜브가 말해야 하는 숫자 t개를 공백 없이 차례대로 나타낸 문자열. 단, 10~15는 각각 대문자 A~F로 출력한다.
	 */
	/* 예시
	 * n	t	 m	  p		result
	 * 2	4	 2	  1		"0111"
	 * 16	16	 2	  1		"02468ACE11111111"
	 * 16	16	 2	  2		"13579BDF01234567"
	 */
	public String solution(int n, int t, int m, int p) {
		String answers = "", answer = "";
		for (int i = 0; answers.length() < t * m; i++)
			answers += Integer.toString(i, n);
		for (int i = p - 1; i < t * m; i += m)
			answer += answers.charAt(i);
		return answer.toUpperCase();
	}

	// Lv.2 - 올바른 괄호
	// 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다.
	// '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고,
	// 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
	/* 예시
	 * s		answer
	 * "()()"	true
	 * "(())()"	true
	 * ")()("	false
	 * "(()("	false
	 */
	/* 효율성 테스트 실패
	boolean solution(String s) {
		while (!s.isEmpty()) {
			if (s.startsWith(")") || s.endsWith("("))
				return false;
			s = s.replaceAll("[(][)]", "");
		}
		return true;
	}*/
	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '(')
				stack.push('(');
			else if (stack.empty())
				return false;
			else
				stack.pop();
		return stack.empty();
	}
	/* import 없이 3배 빠른 효율성
	boolean solution(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '(')
				count++;
			else if (count == 0)
				return false;
			else
				count--;
		return count == 0;
	}*/
}
