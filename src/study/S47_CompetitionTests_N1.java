//2022.07.29. ~ 2022.07.30.
package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S47_CompetitionTests_N1 {

	// Q1
	// 두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0<=k<=9)들을 이용하여 만들 수 있는 가장 큰 정수를
	// 두 수의 짝꿍이라 합니다(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).
	// X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다.
	// X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
	// 두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
	/* 예시
	 * X		Y			result
	 * "100"	"2345"		"-1"
	 * "100"	"203045"	"0"
	 * "100"	"123450"	"10"
	 * "12321"	"42531"		"321"
	 * "5525"	"1255"		"552"
	 */
	/* 73.7점, 11~15케이스 시간초과
	public String solution(String X, String Y) {
		String answer = "";
		char[] xs = X.toCharArray(), ys = Y.toCharArray();
		for (int i = 9; i >= 0; i--) {
			int kx = 0, ky = 0;
			for (char x : xs)
				if (x - '0' == i)
					kx++;
			for (char y : ys)
				if (y - '0' == i)
					ky++;
			for (int k = Math.min(kx, ky); k > 0; k--)
				answer += i;
		}
		return answer.isEmpty() ? "-1" : answer.charAt(0) == '0' ? "0" : answer;
	}*/
	/* 위보다 더 빠르긴 한데 훨씬 더 빠르게......
	public String solution(String X, String Y) {
		String answer = "";
		String[] xs = X.charAt(0) == '-' ? X.replaceFirst("-", "").split("") : X.split(""),
				ys = Y.charAt(0) == '-' ? Y.replaceFirst("-", "").split("") : Y.split("");
		if (xs.length < ys.length) {
			Arrays.sort(xs);
			for (int x = xs.length - 1; x >= 0; x--)
				for (int y = ys.length - 1; y >= 0; y--)
					if (xs[x].equals(ys[y])) {
						answer += xs[x];
						ys[y] = "";
						break;
					}
		} else {
			Arrays.sort(ys);
			for (int y = ys.length - 1; y >= 0; y--)
				for (int x = xs.length - 1; x >= 0; x--)
					if (ys[y].equals(xs[x])) {
						answer += ys[y];
						xs[x] = "";
						break;
					}
		}
		return answer.length() == 0 ? "-1" : answer.startsWith("0") ? "0" : answer;
	}*/
	// 조금 더 빠르긴 한데 여전히 시간초과
	public String solution(String X, String Y) {
		String answer = "";
		String[] xs = X.split(""), ys = Y.split("");
		Arrays.sort(xs);
		Arrays.sort(ys);
		int x = xs.length - 1, y = ys.length - 1;
		if (x < y) {
			while (x >= 0 && y >= 0) {
				int i = xs[x].compareTo(ys[y]);
				if (i == 0) {
					answer += xs[x];
					x--;
					y--;
				} else if (i > 0) {
					x--;
				} else {
					y--;
				}
			}
		} else {
			while (x >= 0 && y >= 0) {
				int i = ys[y].compareTo(xs[x]);
				if (i == 0) {
					answer += ys[y];
					x--;
					y--;
				} else if (i > 0) {
					y--;
				} else {
					x--;
				}
			}
		}
		return answer.length() == 0 ? "-1" : answer.startsWith("0") ? "0" : answer;
	}

	// Q2
	// XYZ 마트는 일정한 금액을 지불하면 10일 동안 회원 자격을 부여합니다.
	// XYZ 마트에서는 회원을 대상으로 매일 한 가지 제품을 할인하는 행사를 합니다.
	// 할인하는 제품은 하루에 하나씩만 구매할 수 있습니다.
	// 알뜰한 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입하려 합니다.
	// 정현이가 원하는 제품을 나타내는 문자열 배열 want와 정현이가 원하는 제품의 수량을 나타내는 정수 배열 number,
	// XYZ 마트에서 할인하는 제품을 나타내는 문자열 배열 discount가 주어졌을 때,
	// 회원등록시 정현이가 원하는 제품을 모두 할인받을 수 있는 회원등록 날짜의 총 일수를 return하는 solution 함수를 완성하시오.
	// 가능한 날이 없으면 0을 return합니다.
	// number[i]는 want[i]의 수량을 의미하며, number의 원소의 합은 10입니다.
	// want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열입니다.
	/* 예시
	 * want							number		discount				result
	 * ["banana", "apple", "rice",	[3, 2, 2,	["chicken", "apple",	3
	 * "pork", "pot"]				2, 1]		"apple", "banana",
	 * 											"rice", "apple",
	 * 											"pork", "banana",
	 * 											"pork", "rice",
	 * 											"pot", "banana",
	 * 											"apple", "banana"]
	 * ["apple"]					[10]		["banana", "banana",	10
	 * 											"banana", "banana",
	 * 											"banana", "banana",
	 * 											"banana", "banana",
	 * 											"banana", "banana"]
	 */
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		for (int i = 0; i < discount.length - 9; i++)
			answer += purchase(want, number, discount, i);
		return answer;
	}

	private int purchase(String[] want, int[] number, String[] discount, int first) {
		Map<String, Integer> list = new HashMap<>();
		for (int i = first; i < 10 + first; i++)
			list.put(discount[i], list.getOrDefault(discount[i], 0) - 1);
		for (int i = 0; i < number.length; i++)
			if (list.getOrDefault(want[i], 0) + number[i] > 0)
				return 0;
		return 1;
	}

	// Q3
	// 1번 상자부터 n번 상자까지 번호가 증가하는 순서대로 컨테이너 벨트에 일렬로 놓여 영재에게 전달됩니다.
	// 컨테이너 벨트는 한 방향으로만 진행이 가능해서 벨트에 놓인 순서대로(1번 상자부터) 상자를 내릴 수 있습니다.
	// 하지만 컨테이너 벨트에 놓인 순서대로 택배상자를 내려 바로 트럭에 싣게 되면
	// 택배 기사님이 배달하는 순서와 택배상자가 실려 있는 순서가 맞지 않아 배달에 차질이 생깁니다.
	// 따라서 택배 기사님이 미리 알려준 순서에 맞게 영재가 택배상자를 실어야 합니다.
	// 만약 컨테이너 벨트의 맨 앞에 놓인 상자가 현재 트럭에 실어야 하는 순서가 아니라면
	// 그 상자를 트럭에 실을 순서가 될 때까지 잠시 다른 곳에 보관해야 합니다.
	// 하지만 고객의 물건을 함부로 땅에 둘 수 없어 보조 컨테이너 벨트를 추가로 설치하였습니다.
	// 보조 컨테이너 벨트는 앞뒤로 이동이 가능하지만 입구 외에 다른 면이 막혀 있어서 맨 앞의 상자만 뺄 수 있습니다.
	// 즉, 가장 마지막에 보조 컨테이너 벨트에 보관한 상자부터 꺼내게 됩니다.
	// 보조 컨테이너 벨트를 이용해도 기사님이 원하는 순서대로 상자를 싣지 못한다면, 더 이상 상자를 싣지 않습니다.
	// 택배 기사님이 원하는 상자 순서를 나타내는 정수 배열 order가 주어졌을 때,
	// 영재가 몇 개의 상자를 실을 수 있는지 return하는 solution 함수를 완성하세요.
	/* order				result
	 * [4, 3, 1, 2, 5]		2
	 * [5, 4, 3, 2, 1]		5
	 */
	public int solution(int[] order) {
		int answer = 0, box = 1;
		List<Integer> belt = new ArrayList<>();
		for (int i = 0; i < order.length; i++) {
			while (box < order[i]) {
				belt.add(box);
				box++;
			}
			if (box == order[i]) {
				answer++;
				box++;
			} else if (belt.remove(belt.size() - 1) == order[i])
				answer++;
			else
				break;
		}
		return answer;
	}

	// Q4
	// 한수는 직사각형 모양의 공간에 놓인 동전들을 뒤집는 놀이를 하고 있습니다.
	// 모든 동전들은 앞과 뒤가 구분되어 있으며, 동전을 뒤집기 위해서는 같은 줄에 있는 모든 동전을 뒤집어야 합니다.
	// 동전들의 초기 상태와 목표 상태가 주어졌을 때, 초기 상태에서 최소 몇 번의 동전을 뒤집어야 되는지 알아봅시다.
	// 직사각형 모양의 공간에 놓인 동전들의 초기 상태를 나타내는 2차원 정수 배열 beginning,
	// 목표 상태를 나타내는 target이 주어졌을 때, 초기 상태에서 목표 상태로 만들기 위해
	// 필요한 동전 뒤집기 횟수의 최솟값을 return하는 solution 함수를 완성하세요.
	// 단, 목표 상태를 만들지 못하는 경우에는 -1을 return합니다.
	// beginning[i][j]와 target[i][j]는 i+1행 j+1열의 동전의 상태를 나타내며, 0 또는 1의 값으로 주어집니다.
	// 0은 동전의 앞면을, 1은 동전의 뒷면을 의미합니다.
	/* 예시
	 * beginning							target								result
	 * [[0, 1, 0, 0, 0], [1, 0, 1, 0, 1],	[[0, 0, 0, 1, 1], [0, 0, 0, 0, 1],	5
	 * [0, 1, 1, 1, 0], [1, 0, 1, 1, 0],	[0, 0, 1, 0, 1], [0, 0, 0, 1, 0],
	 * [0, 1, 0, 1, 0]]						[0, 0, 0, 0, 1]]
	 * [[0, 0, 0], [0, 0, 0], [0, 0, 0]]	[[1, 0, 1], [0, 0, 0], [0, 0, 0]]	-1
	 */
	public int solution(int[][] beginning, int[][] target) {
		int answer = 0;
		return answer;
	}
}
