//2022.07.18.
package study;

import java.util.ArrayList;
import java.util.List;

public class S44_Solution_Q2 {

	// Lv.2 - 방문 길이
	/* 게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다.
	 * U: 위쪽으로 한 칸 가기
	 * D: 아래쪽으로 한 칸 가기
	 * R: 오른쪽으로 한 칸 가기
	 * L: 왼쪽으로 한 칸 가기
	 */
	// 캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 좌표평면의 경계는
	// 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.
	// 이때, 우리는 게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이를 구하려고 합니다.
	// 단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.
	// 명령어가 매개변수 dirs로 주어질 때,
	// 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return 하는 solution 함수를 완성해 주세요.
	/* 예시
	 * dirs			answer
	 * "ULURRDLLU"	7
	 * "LULLLLLLU"	7
	 */
	public int solution(String dirs) {
		int answer = 0;
		int[] location = new int[2];
		List<String> storage = new ArrayList<>();
		String temp = "";
		for (char dir : dirs.toCharArray())
			switch (dir) {
			case 'U':
				if (location[1] != 5) {
					temp = String.valueOf(location[1]) + String.valueOf(location[0]);
					location[1]++;
					temp += String.valueOf(location[1]) + String.valueOf(location[0]);
					if (!storage.contains(temp)) {
						storage.add(temp);
						answer++;
					}
				}
				break;
			case 'D':
				if (location[1] != -5) {
					temp = String.valueOf(location[1]) + String.valueOf(location[0]);
					location[1]--;
					temp = String.valueOf(location[1]) + String.valueOf(location[0]) + temp;
					if (!storage.contains(temp)) {
						storage.add(temp);
						answer++;
					}
				}
				break;
			case 'R':
				if (location[0] != 5) {
					temp = String.valueOf(location[1]) + String.valueOf(location[0]);
					location[0]++;
					temp += String.valueOf(location[1]) + String.valueOf(location[0]);
					if (!storage.contains(temp)) {
						storage.add(temp);
						answer++;
					}
				}
				break;
			default:
				if (location[0] != -5) {
					temp = String.valueOf(location[1]) + String.valueOf(location[0]);
					location[0]--;
					temp = String.valueOf(location[1]) + String.valueOf(location[0]) + temp;
					if (!storage.contains(temp)) {
						storage.add(temp);
						answer++;
					}
				}
			}
		return answer;
	}

	// Lv.2 - 스킬트리
	// 선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
	// 예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때,
	// 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
	// 위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다.
	// 선행 스킬 순서 skill과 유저들이 만든 스킬트리를 담은 배열 skill_trees가 매개변수로 주어질 때,
	// 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
	// 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
	// 스킬 순서와 스킬트리는 문자열로 표기합니다. 예를 들어, C → B → D 라면 "CBD"로 표기합니다.
	// 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
	// skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
	/* 예시
	 * skill	skill_trees							return
	 * "CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
	 */
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for (String tree : skill_trees) {
			int i = 0, lth = tree.length();
			for (int j = 0; j < lth; j++) {
				int idx = skill.indexOf(tree.charAt(j));
				if (idx == i)
					i++;
				else if (idx != -1)
					break;
				if (j == lth - 1)
					answer++;
			}
		}
		return answer;
	}
}
