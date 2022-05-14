//2022.05.14.
package study;

public class S20_TechCamp_N3 {

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
		char mark = ' '; // 제거될 블록의 기준이 될 변수
		int leng = board.length;
		char[][] array = new char[leng][leng]; // 블록이 제거된 상태를 담을 배열
		// board[x].charAt(y)
		for (int y = 0; y < leng; y++) {// 세로줄
			// array 초기화
			for (int i = 0; i < leng; i++)
				for (int j = 0; j < leng; j++)
					array[i][j] = board[i].charAt(j);
			// mark 초기화 및 array 수정
			for (int x = 0; x < leng; x++) {
				mark = board[x].charAt(y);
				array[x][y] = '0';
				if (y != 0)
					array = left(mark, array, x, y, leng); // 줄 좌로 탐색
				if (y != leng)
					array = right(mark, array, x, y, leng); // 줄 좌로 탐색
			}
			// array 속 0을 세서 최댓값 추출
			int cnt = 0; // 0의 개수를 저장할 변수
			for (char[] arr : array)
				for (char ch : arr)
					if (ch == '0')
						cnt++;
			if (cnt > answer)
				answer = cnt;
		}
		for (int x = 0; x < leng; x++) {// 가로줄
			// array 초기화
			for (int i = 0; i < leng; i++)
				for (int j = 0; j < leng; j++)
					array[i][j] = board[i].charAt(j);
			// mark 초기화 및 array 수정
			for (int y = 0; y < leng; y++) {
				mark = board[x].charAt(y);
				array[x][y] = '0';
				if (x != 0)
					array = up(mark, array, x, y, leng); // 줄 위로 탐색
				if (x != leng)
					array = down(mark, array, x, y, leng); // 줄 아래로 탐색
			}
			// array 속 0을 세서 최댓값 추출
			int cnt = 0; // 0의 개수를 저장할 변수
			for (char[] arr : array)
				for (char ch : arr)
					if (ch == '0')
						cnt++;
			if (cnt > answer)
				answer = cnt;
		}
		return answer;
	}

	private char[][] left(char mark, char[][] array, int x, int y, int leng) {
		for (int j = y - 1; j >= 0; j--) {
			if (array[x][j] == mark) {
				array[x][j] = '0';
				for (int i = x + 1; i < leng; i++)
					if (array[i][j] == mark) {
						array[i][j] = '0';
						array = left(mark, array, i, j, leng);
					} else
						break;
				for (int i = x - 1; i >= 0; i--)
					if (array[i][j] == mark) {
						array[i][j] = '0';
						array = left(mark, array, i, j, leng);
					} else
						break;
			} else
				break;
		}
		return array;
	}

	private char[][] right(char mark, char[][] array, int x, int y, int leng) {
		for (int j = y + 1; j < leng; j++) {
			if (array[x][j] == mark) {
				array[x][j] = '0';
				for (int i = x + 1; i < leng; i++)
					if (array[i][j] == mark) {
						array[i][j] = '0';
						array = right(mark, array, i, j, leng);
					} else
						break;
				for (int i = x - 1; i >= 0; i--)
					if (array[i][j] == mark) {
						array[i][j] = '0';
						array = right(mark, array, i, j, leng);
					} else
						break;
			} else
				break;
		}
		return array;
	}

	private char[][] up(char mark, char[][] array, int x, int y, int leng) {
		for (int i = x - 1; i >= 0; i--)
			if (array[i][y] == mark) {
				array[i][y] = '0';
				for (int j = y + 1; j < leng; j++)
					if (array[i][j] == mark) {
						array[i][j] = '0';
						array = up(mark, array, i, j, leng);
					} else
						break;
				for (int j = y - 1; j >= 0; j--)
					if (array[i][j] == mark) {
						array[i][j] = '0';
						array = up(mark, array, i, j, leng);
					} else
						break;
			} else
				break;
		return array;
	}

	private char[][] down(char mark, char[][] array, int x, int y, int leng) {
		for (int i = x + 1; i < leng; i++)
			if (array[i][y] == mark) {
				array[i][y] = '0';
				for (int j = y + 1; j < leng; j++)
					if (array[i][j] == mark) {
						array[i][j] = '0';
						array = down(mark, array, i, j, leng);
					} else
						break;
				for (int j = y - 1; j >= 0; j--)
					if (array[i][j] == mark) {
						array[i][j] = '0';
						array = down(mark, array, i, j, leng);
					} else
						break;
			} else
				break;
		return array;
	}
}
