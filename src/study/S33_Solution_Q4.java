//2022.06.24.
package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class S33_Solution_Q4 {

	// Lv.2 - 피보나치 수
	// 피보나치 수는 F(0)=0, F(1)=1일 때, 1 이상의 n에 대하여 F(n)=F(n-1)+F(n-2)가 적용되는 수 입니다.
	// 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를
	// 리턴하는 함수, solution을 완성해 주세요.
	/* 예시
	 * n	return
	 * 3	2
	 * 5	5
	 */
	public int solution(int n) {
		int[] f = new int[n + 1];
		f[1] = 1;
		for (int i = 2; i <= n; i++)
			// long으로도 범위를 초과하는 경우 발생
			// (A + B) % C = (A % C + B % C) % C
			f[i] = (f[i - 1] % 1234567 + f[i - 2] % 1234567) % 1234567;
		return f[n];
	}

	// Lv.2 - 최솟값 만들기
	// 길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
	// 배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다.
	// 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다.
	// 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다.
	// 단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.
	// 배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.
	/* 예시
	 * A			B			answer
	 * [1, 4, 2]	[5, 4, 4]	29
	 * [1,2]		[3,4]		10
	 */
	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int answer = 0, lth = A.length;
		for (int i = 0; i < lth; i++)
			answer += (A[i] * B[lth - i - 1]);
		return answer;
	}

	// Lv.2 - 최댓값과 최솟값
	// 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
	// str에 나타나는 숫자 중 최소값과 최대값을 찾아
	// 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
	/* 예시
	 * s				return
	 * "1 2 3 4"		"1 4"
	 * "-1 -2 -3 -4"	"-4 -1"
	 * "-1 -1"			"-1 -1"
	 */
	public String solution(String s) {
		int[] temp = Arrays.stream(s.split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
		Arrays.sort(temp);
		return String.valueOf(temp[0]) + " " + String.valueOf(temp[temp.length - 1]);
	}

	// Lv.2 - 주차 요금 계산
	// 주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다.
	// 어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
	// 00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다.
	// 누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구합니다.
	// 누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구합니다.
	// - 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
	// 주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다.
	// 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
	/* fees의 길이 = 4
	 * fees[0] = 기본 시간(분)
	 * fees[1] = 기본 요금(원)
	 * fees[2] = 단위 시간(분)
	 * fees[3] = 단위 요금(원)
	 */
	/* records의 각 원소는 "시각 차량번호 내역" 형식의 문자열입니다.
	 * 시각, 차량번호, 내역은 하나의 공백으로 구분되어 있습니다.
	 * 시각은 차량이 입차되거나 출차된 시각을 나타내며, HH:MM 형식의 길이 5인 문자열입니다.
	 * 차량번호는 자동차를 구분하기 위한, `0'~'9'로 구성된 길이 4인 문자열입니다.
	 * 내역은 길이 2 또는 3인 문자열로, IN 또는 OUT입니다. IN은 입차를, OUT은 출차를 의미합니다.
	 * records의 원소들은 시각을 기준으로 오름차순으로 정렬되어 주어집니다.
	 * 같은 시각에, 같은 차량번호의 내역이 2번 이상 나타내지 않습니다.
	 */
	/* 예시
	 * fees						records									result
	 * [180, 5000, 10, 600]		["05:34 5961 IN", "06:00 0000 IN",		[14600, 34400, 5000]
	 * 							"06:34 0000 OUT", "07:59 5961 OUT",
	 * 							"07:59 0148 IN", "18:59 0000 IN",
	 * 							"19:09 0148 OUT", "22:59 5961 IN",
	 * 							"23:00 5961 OUT"]
	 * [120, 0, 60, 591]		["16:00 3961 IN","16:00 0202 IN",		[0, 591]
	 * 							"18:00 3961 OUT","18:00 0202 OUT",
	 * 							"23:58 3961 IN"]
	 * [1, 461, 1, 10]			["00:00 1234 IN"]						[14841]
	 */
	public int[] solution(int[] fees, String[] records) {
		HashMap<String, Integer> result = new HashMap<>();
		TreeSet<String> carNo = new TreeSet<>();
		int time = 0, end = 1439, idx = 0;
		for (String record : records) {
			String[] temp = record.split(" ");
			time = (Integer.parseInt(temp[0].substring(0, 2)) * 60) + Integer.parseInt(temp[0].substring(3));
			carNo.add(temp[1]);
			if (temp[2].equals("IN"))
				result.put(temp[1], result.getOrDefault(temp[1], 0) - time);
			else
				result.put(temp[1], result.get(temp[1]) + time);
		}
		int[] answer = new int[carNo.size()];
		while (!carNo.isEmpty()) {
			time = result.get(carNo.pollFirst());
			if (time <= 0) {
				time += end;
				if (time <= fees[0])
					answer[idx] = fees[1];
				else
					answer[idx] = (int) (fees[1] + Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3]);
			} else if (time <= fees[0])
				answer[idx] = fees[1];
			else
				answer[idx] = (int) (fees[1] + Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3]);
			idx++;
		}
		return answer;
	}
}
