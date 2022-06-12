//2022.06.12.
package study;

public class S29_TWorX {

	// 1번
	// 1부터 n까지의 정수들이 중복없이 섞여있는 크기가 n인 배열 p가 주어집니다.
	// 당신은 다음과 같은 알고리즘을 거쳐서 배열 p를 오름차순으로 정렬해야 합니다.
	/* 1. 배열 인덱스를 나타내는 정수 i를 초기값 0으로 설정합니다.
	 * - 즉, p[i]는 배열의 i번째 원소를 나타냅니다.
	 * 2. p[i], p[i+1], ... p[n-1] 중에서 가장 작은 숫자를 찾습니다.
	 * - 여기서 찾은 숫자를 p[j]라고 합니다.
	 * 3. 만약 i랑 j가 다르다면 p[i]와 p[j]의 값을 서로 바꿉니다.
	 * 4. i에 1을 더합니다.
	 * - i가 n보다 작다면 위 2번 단계로 돌아갑니다.
	 * - i가 n이라면 알고리즘을 종료합니다.
	 */
	// 각 위치에 대해서 해당 위치의 값이 몇 번 바뀌었는지를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
	/* 예시
	 * p					result
	 * [2,5,3,1,4]			[1,1,0,3,1]
	 * [2,3,4,5,6,1]		[1,1,1,1,1,5]
	 * [1,2,3,4,5,6,7,8,9]	[0,0,0,0,0,0,0,0,0]
	 */
	public int[] solution(int[] p) {
		int n = p.length;
		int[] answer = new int[n];
		int i = 0, j = 0, min = 0;
		while (i < n - 1) {
			j = i;
			min = p[i];
			for (int k = i + 1; k < n; k++)
				if (min > p[k]) {
					min = p[k];
					j = k;
				}
			if (p[i] != p[j]) {
				p[j] = p[i];
				p[i] = min;
				answer[i]++;
				answer[j]++;
			}
			i++;
		}
		return answer;
	}

	// 2번
	/* T 멤버십 등급 기준은 다음과 같습니다.
	 * 연간 납부 금액					가입 기간
	 * 						2년 미만	2년 이상 5년 미만	5년 이상
	 * 90만 원 이상			GOLD	VIP				VIP
	 * 60만 원 이상 90만 원 미만	GOLD	GOLD			VIP
	 * 48만 원 이상 60만 원 미만	SILVER	GOLD			GOLD
	 * 36만 원 이상 48만 원 미만	SILVER	SILVER			GOLD
	 * 36만 원 미만			SILVER	SILVER			SILVER
	 */
	// 연간 납부금액은 이번 달을 포함한 최근 12개월간의 납부금액의 총합을 의미합니다.
	// 고객들의 가입기간을 담은 1차원 정수 배열 periods,
	// 고객들의 납부 내열을 담은 2차원 정수 배열 payments와
	// 고객들의 납부 예정 금액을 담은 1차원 정수 배열 estimates가 주어집니다.
	// 이때 이번 달에는 VIP가 아니지만 다음 달에 VIP가 되는 고객의 수와
	// 이번 달에는 VIP지만 다음 달에는 VIP가 아니게 되는 고객의 수를
	// 정수 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	public int[] solution(int[] periods, int[][] payments, int[] estimates) {
		int[] answer = new int[2];
		for (int i = 0; i < periods.length; i++) {
			if (periods[i] < 23) {
				continue;
			} else if (periods[i] == 23) {
				if (sum(payments, i) - payments[i][0] + estimates[i] >= 900000) {
					answer[0]++;
				}
			} else if (periods[i] < 59) {
				long sum = sum(payments, i);
				if (sum < 900000 && sum - payments[i][0] + estimates[i] >= 900000) {
					answer[0]++;
				} else if (sum >= 900000 && sum - payments[i][0] + estimates[i] < 900000) {
					answer[1]++;
				}
			} else if (periods[i] == 59) {
				long sum = sum(payments, i);
				if (sum >= 600000 && sum < 900000 && sum - payments[i][0] + estimates[i] >= 600000) {
					answer[0]++;
				} else if (sum >= 900000 && sum - payments[i][0] + estimates[i] < 600000) {
					answer[1]++;
				}
			} else if (periods[i] > 59) {
				long sum = sum(payments, i);
				if (sum < 600000 && sum - payments[i][0] + estimates[i] >= 600000) {
					answer[0]++;
				} else if (sum >= 600000 && sum - payments[i][0] + estimates[i] < 600000) {
					answer[1]++;
				}
			}
		}
		return answer;
	}

	private long sum(int[][] payments, int i) {
		long sum = 0;
		for (int j : payments[i])
			sum += j;
		return sum;
	}

	// 3번
	// A통신사에서 제공하는 1~m번으로 분류되는 휴대폰 요금제와 1~n번으로 분류되는 부가서비스가 있습니다.
	// 요금제 번호가 높아질수록 제공하는 데이터가 많아지고, 부가서비스도 추가되며, 아래의 표가 그 예시입니다.
	/* 요금제		제공 데이터	제공 부가서비스		추가된 부가서비스
	 * 1번		100			1				1
	 * 2번		200			1,3				3
	 * 3번		300			1,2,3,5			2,5
	 */
	// A통신사에 신규 가입하려는 고객들이 이용하려는 데이터와 부가서비스를 알고 있을 때,
	// 각 고객마다 이용하려는 데이터 이상을 제공하고, 이용하려는 부가서비스를 모두 포함하는
	// 가장 작은 요금제의 번호 목록을 구하려 합니다. 조건을 만족하는 요금제가 없으면 목록에 0을 담습니다.
	// 부가서비스의 수를 나타내는 정수 n,
	// 요금제 정보를 담은 1차원 문자열 배열 plans와
	// 고객이 용하려는 서비스의 정보를 담은 1차원 문자열 배열 clients가 주어집니다.
	// 이때 clients에 주어진 순서대로 고객이 이용하려는 서비스를 제공할 수 있는 가장 작은 요금제 번호를 담은 목록을
	// 정수 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
	/* 예시
	 * n	plans							clients										result
	 * 5	["100 1 3","500 4","2000 5"]	["300 3 5","1500 1","100 1 3","50 1 2"]		[3,3,1,0]
	 * 4	["38 2 3","394 1 4"]			["10 2 3","300 1 2 3 4","500 1"]			[1,2,0]
	 */
	public int[] solution(int n, String[] plans, String[] clients) {
		int[] answer = new int[clients.length];
		for (int pl = 0; pl < plans.length - 1; pl++) {
			String temp = "";
			String[] plan = plans[pl].split(" ");
			for (int i = 1; i < plan.length; i++)
				temp += " " + plan[i];
			plans[pl + 1] += temp;
		}
		for (int cl = 0; cl < clients.length; cl++) {
			boolean has = false;
			String[] client = clients[cl].split(" ");
			int data = Integer.parseInt(client[0]);
			for (int pl = 0; pl < plans.length; pl++) {
				String[] plan = plans[pl].split(" ");
				if (Integer.parseInt(plan[0]) < data)
					continue;
				else
					for (int i = 1; i < client.length; i++) {
						for (int j = 1; j < plan.length; j++)
							if (client[i].equals(plan[j])) {
								has = true;
								break;
							} else
								has = false;
						if (!has)
							break;
					}
				if (has) {
					answer[cl] = pl + 1;
					break;
				}
			}
		}
		return answer;
	}
}
