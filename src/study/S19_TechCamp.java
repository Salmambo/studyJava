//2022.05.08.
package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class S19_TechCamp {

	// 1번
	// 어떤 공장에서는 단기 알바생들에게 각자 다른 방식으로 임금을 지급하고 있습니다.
	/* 각 알바생이 지급받는 임금은 다음과 같은 요소에 의해 결정됩니다.
	 * 임금 지급 간격: 공장에서 임금을 지급하는 간격(일수)입니다.
	 * 1회 임금 비용: 한번에 지급받는 임금의 금액입니다.
	 */
	/* 임금 지급 간격이 2일이고 1회 임금 비용이 150 달러인 알바생이 지급받는 금액은 다음 표와 같습니다.
	 * 일차	지급 금액	누적 지급 금액
	 * 1	0		0
	 * 2	150		150
	 * 3	0		150
	 * 4	150		300
	 * ...	...		...
	 */
	// 당신은 이 공장의 관리자로, 공장을 특정 일수만큼만 가동한 뒤 중지하려고 합니다.
	// 노동법을 준수하기 위해서, 마지막으로 임금을 지급받고(혹은 한번도 임금을 지급받지 않은 상태에서)
	// 하루라도 일했던 사람들한테는 공장 가동을 중지할 때 1회 임금 비용만큼의 임금을 더 지급하기로 했습니다.
	// 알바생들의 임금 정보를 나타내는 2차원 배열 salaries와 공장을 가동할 일수 days가 매개변수로 주어집니다.
	// 모든 알바생들에게 지급할 총 임금(USD)을 return 하도록 solution 함수를 완성해주세요.
	// salaries의 행의 길이는 1 이상 100 이하입니다.
	// salaries의 각 행은 [interval, single] 2개의 정수로 이루어져 있으며, 이는 각 알바생의 임금 지급 간격(일)과 1회
	// 임금 비용(USD)을 의미합니다.
	// interval은 1 이상 365 이하입니다.
	// single은 1 이상 1,000 이하입니다.
	// days는 1 이상 3,650 이하입니다.
	/* 예시
	 * salaries								days	result
	 * [[2,100],[3,120],[4,180],[7,250]]	6		1150
	 * [[2,1],[3,2],[4,3],[5,4]]			1		10
	 * [[1,1000],[1,1000]]					3650	7300000
	 */
	public int solution(int[][] salaries, int days) {
		int answer = 0;
		for (int i = 1; i <= days; i++)
			for (int[] salary : salaries) {
				if (i % salary[0] == 0)
					answer += salary[1];
				else if (i == days)
					answer += salary[1];
			}
		return answer;
	}

	// 2번
	// 두 문제로 치러진 코딩 테스트의 점수가 주어질 때, 순위를 정하려고 합니다.
	/* 순위를 정하는 기준은 아래와 같습니다.
	 * 총점이 높은 응시자의 순위가 앞섭니다. 총점이 같으면 2.를 따릅니다.
	 * 어려운 문제에서 더 높은 점수를 받은 응시자의 순위가 앞섭니다.
	 * 어려운 문제란, 문제별로 응시자의 총점을 구했을 때, 점수가 더 낮은 문제를 의미합니다.
	 * 어려운 문제의 점수도 같거나, 어려운 문제가 존재하지 않는다면(문제별 응시자의 총점이 같다면) 아래를 따릅니다.
	 * ID 번호가 빠른 응시자의 순위가 앞섭니다.
	 */
	/* 아래는 8명의 응시자 성적으로 순위를 매긴 예시입니다.
	 * 응시자 ID		1번 문제 점수	2번 문제 점수	총점		순위
	 * 1			85			90			175		4
	 * 2			65			67			132		8
	 * 3			88			87			175		2
	 * 4			88			87			175		3
	 * 5			73			81			154		6
	 * 6			65			89			154		7
	 * 7			99			100			199		1
	 * 8			80			94			174		5
	 * 문제별 총점		643			695	
	 */
	// 1번 문제의 총점(643)이 2번 문제의 총점(695) 보다 더 낮으므로, 1번 문제가 어려운 문제입니다.
	// 7번 응시자의 총점이 199점으로 가장 높으므로, 1등입니다.
	// 1, 3, 4번 응시자의 총점이 175점으로 동일합니다.
	// 1번 응시자는 어려운 1번 문제의 점수가 가장 낮으므로(85점) 4등으로 결정됩니다.
	// 3, 4번 응시자는 1번 문제의 점수도 같으므로, ID 번호로 비교를 합니다.
	// ID 번호가 빠른 3번 응시자가 2등, 4번 응시자가 3등으로 결정됩니다.
	// 5, 6번 응시자의 총점이 154점으로 동일합니다.
	// 5번 응시자의 1번 문제 점수가(73점) 6번 응시자보다 높으므로, 5번 응시자가 6등, 6번 응시자가 7등으로 결정됩니다.
	/* 아래는 3명의 응시자 성적으로 순위를 매긴 또 다른 예시입니다.
	 * 응시자 ID		1번 문제 점수	2번 문제 점수	총점		순위
	 * 1			85			90			175		2
	 * 2			91			87			178		1
	 * 3			88			87			175		3
	 * 문제별 총점		264			264
	 */
	// 1, 2번 문제의 총점이 264점으로 동일합니다. 즉, 어려운 문제는 존재하지 않습니다.
	// 따라서 총점이 같은 1, 3번 응시자의 순위를 정할 때, ID 번호가 빠른 1번 응시자가 2등으로 결정됩니다.
	// 응시자들의 성적이 담겨있는 2차원 정수 배열 scores가 매개변수로 주어집니다.
	// 이때, 1번 응시자의 순위부터 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
	// scores의 길이(=응시자의 수)는 1 이상 100,000 이하입니다.
	// scores에는 1번 응시자의 성적부터 차례대로 담겨 있습니다.
	// scores의 원소는 [a, b] 형태입니다.
	// a는 1번 문제의 점수로, 0 이상 100 이하인 정수입니다.
	// b는 2번 문제의 점수로, 0 이상 100 이하인 정수입니다.
	/* 예시
	 * scores																				result
	 * [[85, 90], [65, 67], [88, 87], [88, 87], [73, 81], [65, 89],[99, 100], [80, 94]]		[4, 8, 2, 3, 6, 7, 1, 5]
	 * [[85, 90], [91, 87], [88, 87]]														[2, 1, 3]
	 */
	public int[] solution(int[][] scores) {
		int[] answer = new int[scores.length];
		int num1 = 0, num2 = 0;
		int[] sum = new int[scores.length];
		int rank = 0;
		for (int i = 0; i < scores.length; i++) {
			num1 += scores[i][0];
			num2 += scores[i][1];
			sum[i] = scores[i][0] + scores[i][1];
		}
		if (num1 == num2)
			while (rank < scores.length) {
				int max = Arrays.stream(sum).max().getAsInt();
				for (int i = 0; i < sum.length; i++)
					if (sum[i] == max) {
						answer[i] = rank + 1;
						sum[i] = 0;
						rank++;
					}
			}
		else if (num1 < num2)
			while (rank < scores.length) {
				int max = Arrays.stream(sum).max().getAsInt();
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = 0; i < sum.length; i++)
					if (sum[i] == max)
						list.add(scores[i][0]);
				if (list.size() == 1) {
					for (int i = 0; i < sum.length; i++)
						if (sum[i] == max) {
							answer[i] = rank + 1;
							sum[i] = 0;
							rank++;
							break;
						}
				} else {
					Collections.sort(list);
					while (!list.isEmpty())
						for (int i = 0; i < sum.length; i++)
							if (sum[i] == max && scores[i][0] == list.get(list.size() - 1)) {
								answer[i] = rank + 1;
								sum[i] = 0;
								list.remove(list.size() - 1);
								rank++;
								break;
							}
				}
			}
		else
			while (rank < scores.length) {
				int max = Arrays.stream(sum).max().getAsInt();
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = 0; i < sum.length; i++)
					if (sum[i] == max)
						list.add(scores[i][1]);
				if (list.size() == 1) {
					for (int i = 0; i < sum.length; i++)
						if (sum[i] == max) {
							answer[i] = rank + 1;
							sum[i] = 0;
							rank++;
							break;
						}
				} else {
					Collections.sort(list);
					while (!list.isEmpty())
						for (int i = 0; i < sum.length; i++)
							if (sum[i] == max && scores[i][1] == list.get(list.size() - 1)) {
								answer[i] = rank + 1;
								sum[i] = 0;
								list.remove(list.size() - 1);
								rank++;
								break;
							}
				}
			}
		return answer;
	}

	// 3번
	// 각 칸이 1 x 1 크기 정사각형인 N x N 크기 보드에 다양한 색상의 블록들이 놓여있습니다.
	// 블록은 1 x 1 크기 정사각형을 연결한 모양이며, 보드의 각 칸과 블록을 구성하는 정사각형 조각이 정확히 일치하도록 놓여있습니다.
	// block_board_1.png는 보드의 상태를 나타낸 예시입니다.
	// 이 보드에서 가로 혹은 세로 방향으로 한 줄을 선택한 후 해당 줄에 놓인 모든 블록을 없애려 합니다.
	// 이때, 선택한 줄을 지나는 블록은 연결된 부분까지 모두 없어져야 합니다.
	/* 다음은 붉은 화살표로 표시된 세로 방향 줄(2번 열)을 지나는 블록들을 제거한 예시입니다.
	 * block_board_2.png에서는 블록 4개를 제거해서 빈칸이 총 19개 생겼습니다.
	 * 그러나 만약 block_board_3.png와 같이 붉은 화살표로 표시된 가로 방향 줄(4번 행)을 지나는 블록들을 제거한다면 
	 * 빈칸이 총 20개 생기며, 이보다 빈칸이 더 많이 생기도록 한 줄을 제거하는 방법은 없습니다.
	 */
	// 현재 보드의 상태가 문자열 배열 형태로 담긴 board가 매개변수로 주어질 때,
	// 빈칸이 최대한 많이 생기도록 한 줄을 선택해서 제거할 경우,
	// 그때의 빈칸 개수를 return 하도록 solution 함수를 완성해주세요.
	// board의 길이는 3 이상 50 이하입니다.
	// board의 각 문자열 길이는 board의 길이와 같습니다.
	// 각 문자열은 보드의 한 행(가로 줄)을 의미합니다.
	// 문자열은 알파벳 대문자로만 이루어져 있습니다.
	// 같은 알파벳은 같은 색상을 의미합니다.
	// 상, 하, 좌, 우 방향으로 연결된 같은 알파벳은 같은 블록을 구성합니다.
	/* 예시
	 * board													result
	 * ["ABBBBC","AABAAC","BCDDAC","DCCDDE","DCCEDE","DDEEEB"]	20
	 * ["DDCCC","DBBBC","DBABC","DBBBC","DDCCC"]				25
	 */
	public int solution(String[] board) {
		int answer = 0;
		return answer;
	}

	// 4번
	/* 다음과 같이 숫자를 알파벳 대소문자, 숫자, 기호를 조합해서 표현할 수 있습니다.
	 * 숫자	기호
	 * 0	O(알파벳 대문자 오), ()
	 * 1	I(알파벳 대문자 아이)
	 * 2	Z, S, 7_
	 * 3	E, B
	 * 4	A
	 * 5	Z, S
	 * 6	b, G
	 * 7	T, Y
	 * 8	B, E3
	 * 9	g, q
	 */
	/* 이때, 숫자로 이루어진 문자열을 표현하는 방법은 다음과 같습니다.
	 * 각 숫자는 정해진 방식에 따라 비슷한 모양의 다른 기호로 치환해서 적습니다.
	 * 이때, 다른 기호로 치환하지 않고 그대로 적어도 됩니다.
	 * 한 숫자가 서로 다른 기호로 치환될 수 있습니다.
	 * 단, 서로 다른 숫자가 같은 기호로 치환되지는 않습니다.
	 */
	/* 예를 들어 숫자 "2455373"의 경우 다음과 같은 방식으로 치환됩니다.
	 * "ZASSETE", "S4Z537B", "7_ASZEYB", ...
	 * 다음은 "2455373"을 치환한 결과가 아닙니다.
	 * "ZAZZ373"
	 * 첫 번째 숫자 2와 세 번째 숫자 5가 같은 기호 'Z'로 치환되어 3번 규칙에 맞기 않기 때문입니다.
	 * 따라서 위 문자열의 경우 원래 문자열은 "2422373" 또는 "5455373"입니다.
	 */
	/* 또 다른 예시로 숫자 "225"의 경우 다음과 같이 치환할 수 있습니다.
	 * "ZZ5", "ZZS", "SSZ", "Z7_S", "S7_Z", "SZ5" ...
	 * 그러나 "225"를 "ZSZ" 나 "SSS"와 같이 치환할 수는 없습니다.
	 */
	// 문자열들이 담긴 배열 numstrs와 숫자로된 단어들이 담긴 배열 words가 매개변수로 주어질 때,
	// 각 단어가 포함된 문자열은 몇개인지 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
	// numstrs의 길이는 1 이상 100 이하입니다.
	// numstrs의 각 원소는 길이가 1 이상 100 이하인 문자열입니다.
	// numstrs의 문자열은 알파벳 대소문자와 숫자, 특수 문자 (, ), _로만 이루어져 있습니다.
	// 규칙에 맞게 치환한 문자열만 입력으로 주어집니다.
	// words의 길이는 1 이상 10 이하입니다.
	// words의 원소는 길이가 1 이상 8 이하인 문자열입니다.
	// words의 문자열은 숫자로만 이루어져 있습니다.
	// 숫자 문자열은 0으로 시작할 수 있습니다.
	// 매칭된 부분 문자열을 제외한 나머지 문자열들이 올바르게 치환된 문자열이 아니어도 괜찮습니다.
	// 예를 들어 "B7_"에서, "37"를 검색한 경우, "B7"가 "37"를 치환한 문자열로 검색되고 "_"는 매칭되는 문자가 없지만 무시해도
	// 됩니다.
	/* 예시
	 * numstrs								words								result
	 * ["ZASSETE", "S4Z537B", "7_ASZEYB"]	["2455373", "425", "373", "378"]	[3, 2, 3, 2]
	 * ["ZAZZ373"]							["2422373", "5455373", "2455373"]	[1, 1, 0]
	 */
	public int[] solution(String[] numstrs, String[] words) {
		int[] answer = {};
		return answer;
	}
}
