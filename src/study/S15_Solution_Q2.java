//2022.05.02.
package study;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class S15_Solution_Q2 {

	// Lv.1 - 실패율
	// 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
	// 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
	// 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
	// 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
	// stages의 길이는 1 이상 200,000 이하이다.
	// stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
	// 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
	// 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
	// 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
	// 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
	/* 예시
	 * N	stages						result
	 * 5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
	 * 4	[4,4,4,4,4]					[4,1,2,3]
	 */
	public int[] solution(int N, int[] stages) {
		TreeMap<Integer, Double> rate = new TreeMap<>(); // 스테이지와 실패율을 묶기 위한 트리맵
		int stage = 1;
		int temp = 0; // 유저 수를 세기 위한 변수
		while (stage <= N) { // 모든 스테이지를 거치면 종료
			int tmp = 0;
			for (int i = 0; i < stages.length; i++) // stages 검색
				if (stages[i] == stage) // 스테이지에 머물러 있는 유저 수만큼 tmp 증가
					tmp++;
			// 실패율 계산하여 저장
			// 고레벨 스테이지에 유저가 하나도 없으면 실패율 계산식의 분모가 0이 되므로 이를 방지하기 위해 삼항식 작성
			rate.put(stage, (stages.length - temp != 0) ? (double) tmp / (stages.length - temp) : 0);
			temp += tmp; // 계산한 유저 수를 전체 수에서 빼주기 위함
			stage++;
		}
		int[] answer = new int[N];
		temp = 0; // answer의 인덱스로 쓰기 위해 초기화
		while (!rate.isEmpty()) { // 맵이 비면 종료
			// 실패율이 높은 스테이지부터 저장
			answer[temp] = rate.entrySet().stream().max(Entry.comparingByValue()).get().getKey();
			rate.remove(answer[temp]); // 저장한 스테이지를 맵에서 삭제
			temp++;
		}
		return answer;
	}

	// Lv.1 - 폰켓몬
	// 홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
	// 홍 박사님 연구실의 폰켓몬은 종류에 따라 번호를 붙여 구분합니다.
	// 예를 들어 연구실에 총 4마리의 폰켓몬이 있고, 각 폰켓몬의 종류 번호가 [3번, 1번, 2번, 3번]이라면
	// 3번 폰켓몬 두 마리, 1번 폰켓몬 한 마리, 2번 폰켓몬 한 마리가 있음을 나타냅니다.
	/* 이때, 4마리의 폰켓몬 중 2마리를 고르는 방법은 다음과 같이 6가지가 있습니다.
	 * 첫 번째(3번), 두 번째(1번) 폰켓몬을 선택
	 * 첫 번째(3번), 세 번째(2번) 폰켓몬을 선택
	 * 첫 번째(3번), 네 번째(3번) 폰켓몬을 선택
	 * 두 번째(1번), 세 번째(2번) 폰켓몬을 선택
	 * 두 번째(1번), 네 번째(3번) 폰켓몬을 선택
	 * 세 번째(2번), 네 번째(3번) 폰켓몬을 선택
	 */
	// 위 예시에서 가질 수 있는 폰켓몬 종류 수의 최댓값은 2가 됩니다.
	// 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다.
	// N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때,
	// N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아,
	// 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
	// nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
	// nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
	// 폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
	// 가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도,
	// 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.
	/* 예시
	 * nums				result
	 * [3,1,2,3]		2
	 * [3,3,3,2,2,4]	3
	 * [3,3,3,2,2,2]	2
	 */
	public int solution(int[] nums) {
		TreeSet<Integer> set = new TreeSet<>(); // 정렬할 필요가 없기에 HashSet 사용하면 효율 증가
		for (int num : nums)
			set.add(num);
		return (set.size() > nums.length / 2) ? nums.length / 2 : set.size();
	}
}
