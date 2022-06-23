//2022.06.23.
package study;

import java.util.ArrayList;

public class S32_Solution_Q3 {

	// Lv.2 - JadenCase 문자열 만들기
	// JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
	// 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다.
	// 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
	// s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
	// 숫자는 단어의 첫 문자로만 나옵니다.
	// 숫자로만 이루어진 단어는 없습니다.
	// 공백문자가 연속해서 나올 수 있습니다.
	/* 예시
	 * s						return
	 * "3people unFollowed me"	"3people Unfollowed Me"
	 * "for the last week"		"For The Last Week"
	 */
	public static String solution(String s) {
		String answer = "";
		for (int i = 0; i < s.length(); i++)
			if ((i == 0 || s.charAt(i - 1) == ' ') && (s.charAt(i) > 96 && s.charAt(i) < 123))
				answer += (char) (s.charAt(i) - 32);
			else if ((i != 0 && s.charAt(i - 1) != ' ') && (s.charAt(i) > 64 && s.charAt(i) < 91))
				answer += (char) (s.charAt(i) + 32);
			else
				answer += s.charAt(i);
		return answer;
		/* 코드 깔끔하게 - 효율 압도적으로 빠름
		String answer = "";
		String[] sp = s.toLowerCase().split(""); // 요소 하나마다(공백도) 쪼개서
		boolean flag = true; // 단어 첫 글자 판별
		for(String ss : sp) { 9.34 14.02
		    answer += flag ? ss.toUpperCase() : ss; // 첫 글자면 대문자로, 아니면 그대로
		    flag = ss.equals(" ") ? true : false; // 넣은 글자가 공백이면 true, 아니면 false
		}
		return answer; */
	}

	// Lv.2 - 행렬의 곱셈
	// 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
	/* 예시
	 * arr1									arr2								return
	 * [[1, 4], [3, 2], [4, 1]]				[[3, 3], [3, 3]]					[[15, 15], [15, 15], [15, 15]]
	 * [[2, 3, 2], [4, 2, 4], [3, 1, 4]]	[[5, 4, 3], [2, 4, 1], [3, 1, 1]]	[[22, 22, 11], [36, 28, 18], [29, 20, 14]]
	 */
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int x = arr1.length, y = arr2[0].length, z = arr2.length;
		int[][] answer = new int[x][y];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++)
				for (int k = 0; k < z; k++)
					answer[i][j] += arr1[i][k] * arr2[k][j];
		return answer;
	}

	// Lv.2 - 하노이의 탑
	// 하노이 탑(Tower of Hanoi)은 퍼즐의 일종입니다.
	// 세 개의 기둥과 이 기동에 꽂을 수 있는 크기가 다양한 원판들이 있고,
	// 퍼즐을 시작하기 전에는 한 기둥에 원판들이 작은 것이 위에 있도록 순서대로 쌓여 있습니다.
	/* 게임의 목적은 한 기둥에 꽂힌 원판들을 그 순서 그대로 다른 기둥으로 옮겨서 다시 쌓는 것입니다.
	 * 한 번에 하나의 원판만 옮길 수 있습니다.
	 * 큰 원판이 작은 원판 위에 있어서는 안됩니다.
	 */
	// 1번 기둥에 있는 원판의 개수 n이 매개변수로 주어질 때,
	// n개의 원판을 3번 원판으로 최소로 옮기는 방법을 return하는 solution를 완성해주세요.
	/* 예시
	 * n	result
	 * 2	[ [1,2], [1,3], [2,3] ]
	 */
	private ArrayList<int[]> list = new ArrayList<>();

	public int[][] solution(int n) {
		int[][] answer = new int[(int) Math.pow(2, n) - 1][2];
		hanoiTower(n, 1, 3, 2);
		for (int i = 0; i < answer.length; i++)
			answer[i] = list.get(i);
		return answer;
	}

	private void hanoiTower(int n, int from, int to, int waypoint) {
		if (n == 0)
			return;
		hanoiTower(n - 1, from, waypoint, to);
		list.add(new int[] { from, to });
		hanoiTower(n - 1, waypoint, to, from);
	}
}
