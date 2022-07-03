//2022.07.03.
package study;

public class S36_DevMatching {

	public int solution(int[] grade) {
		int answer = 0;
		for (int i = grade.length - 1; i > 0; i--)
			if (grade[i] < grade[i - 1]) {
				answer += (grade[i - 1] - grade[i]);
				grade[i - 1] -= (grade[i - 1] - grade[i]);
			}
		return answer;
	}

	public int[][] solution(int n, boolean horizontal) {
		int[][] answer = new int[n][n];
		answer[0][0] = 1;
		int x = 0, y = 0, count = 2, index = 1;
		while (index < n) {
			if (horizontal) {
				y++;
				while (x <= y) {
					answer[x][y] = count;
					count++;
					x++;
				}
				count--;
				x--;
				while (y >= 0) {
					answer[x][y] = count;
					count++;
					y--;
				}
				count--;
				y++;
				horizontal = false;
			} else if (!horizontal) {
				x++;
				while (y <= x) {
					answer[x][y] = count;
					count++;
					y++;
				}
				count--;
				y--;
				while (x >= 0) {
					answer[x][y] = count;
					count++;
					x--;
				}
				count--;
				x++;
				horizontal = true;
			}
			count++;
			index++;
		}
		return answer;
	}
}
