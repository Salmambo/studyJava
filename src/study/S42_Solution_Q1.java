//2022.07.16.
package study;

public class S42_Solution_Q1 {

	// Lv.2 - 가장 큰 정사각형 찾기
	// 1와 0로 채워진 표(board)가 있습니다.
	// 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
	// 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요.
	// 단, 정사각형이란 축에 평행한 정사각형을 말합니다.
	/* 예시
	 * board										answer
	 * [[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]	9
	 * [[0,0,1,1],[1,1,1,1]]						4
	 */
	public int solution(int[][] board) {
		int answer = 1;
		if (allZero(board))
			return 0;
		for (int i = 1; i < board.length; i++)
			for (int j = 1; j < board[i].length; j++) {
				if (board[i][j] == 0)
					continue;
				board[i][j] = Math.min(Math.min(board[i - 1][j - 1], board[i - 1][j]), board[i][j - 1]) + 1;
				if (board[i][j] > answer)
					answer = board[i][j];
			}
		return (int) Math.pow(answer, 2);
	}

	private boolean allZero(int[][] board) {
		for (int[] i : board)
			for (int j : i)
				if (j == 1)
					return false;
		return true;
	}
}
