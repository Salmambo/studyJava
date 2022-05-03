//2022.05.03.
package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class S16_Solution_Q2 {

	// Lv.1 - 체육복
	// 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.
	// 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
	// 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
	// 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
	// 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
	// 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
	// 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
	// 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
	// 전체 학생의 수는 2명 이상 30명 이하입니다.
	// 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
	// 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
	// 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
	// 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
	// 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며,
	// 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
	/* 예시
	 * n	lost	reserve		return
	 * 5	[2,4]	[1,3,5]		5
	 * 5	[2,4]	[3]			4
	 */
	public int solution(int n, int[] lost, int[] reserve) {
		HashMap<Integer, Integer> back = new HashMap<>(); // 뒤 번호 먼저 빌려줄 경우
		HashMap<Integer, Integer> front = new HashMap<>(); // 앞 번호 먼저 빌려줄 경우
		// 전체 학생 수
		for (int i = 1; i <= n; i++) {
			back.put(i, 1);
			front.put(i, 1);
		}
		// 체육복 분실
		for (int i : lost) {
			back.put(i, back.get(i) - 1);
			front.put(i, front.get(i) - 1);
		}
		// 여벌 체육복
		for (int i : reserve) {
			back.put(i, back.get(i) + 1);
			front.put(i, front.get(i) + 1);
		}
		// 뒤 번호 먼저 분배
		for (int i = 1; i < n; i++)
			// i번에게 여벌이 있고 뒤 번호가 분실했을 경우
			if (back.get(i) == 2 && back.get(i + 1) == 0) {
				back.put(i, 1);
				back.put(i + 1, 1);
			}
		for (int i = n; i > 1; i--)
			// i번에게 여벌이 있고 앞 번호가 분실했을 경우
			if (back.get(i) == 2 && back.get(i - 1) == 0) {
				back.put(i, 1);
				back.put(i - 1, 1);
			}
		// 앞 번호 먼저 분배
		for (int i = n; i > 1; i--)
			// i번에게 여벌이 있고 앞 번호가 분실했을 경우
			if (front.get(i) == 2 && front.get(i - 1) == 0) {
				front.put(i, 1);
				front.put(i - 1, 1);
			}
		for (int i = 1; i < n; i++)
			// i번에게 여벌이 있고 뒤 번호가 분실했을 경우
			if (front.get(i) == 2 && front.get(i + 1) == 0) {
				front.put(i, 1);
				front.put(i + 1, 1);
			}
		// 최댓값
		int answerB = 0, answerF = 0;
		for (int i = 1; i <= n; i++) {
			if (back.get(i) > 0)
				answerB++;
			if (front.get(i) > 0)
				answerF++;
		}
		return (answerB > answerF) ? answerB : answerF;
	}

	// Lv.1 - 모의고사
	/* 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
	 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	 */
	// 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
	// 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	// 시험은 최대 10,000 문제로 구성되어있습니다.
	// 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
	// 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
	/* 예시
	 *  answers			return
	 *  [1,2,3,4,5]		[1]
	 *  [1,3,2,4,2]		[1,2,3]
	 */
	public int[] solution(int[] answers) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[] cnt = new int[3];
		for (int i = 0; i < answers.length; i++) {
			if (a[i % 5] == answers[i])
				cnt[0]++;
			if (b[i % 8] == answers[i])
				cnt[1]++;
			if (c[i % 10] == answers[i])
				cnt[2]++;
		}
		int max = Arrays.stream(cnt).max().getAsInt();
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < 3; i++)
			if (cnt[i] == max)
				answer.add(i + 1);
		return answer.stream().mapToInt(i -> i).toArray();
	}
}
