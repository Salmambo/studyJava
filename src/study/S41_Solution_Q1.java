//2022.07.15.
package study;

import java.util.ArrayList;
import java.util.List;

public class S41_Solution_Q1 {

	// Lv.2 - 압축
	// 어피치는 여러 압축 알고리즘 중에서 성능이 좋고 구현이 간단한 LZW(Lempel–Ziv–Welch) 압축을 구현하기로 했다.
	// LZW 압축은 1983년 발표된 알고리즘으로, 이미지 파일 포맷인 GIF 등 다양한 응용에서 사용되었다.
	/* LZW 압축은 다음 과정을 거친다.
	 * 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
	 * 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
	 * w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
	 * 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
	 * 단계 2로 돌아간다.
	 */
	// 입력으로 영문 대문자로만 이뤄진 문자열 msg가 주어진다.
	// 주어진 문자열을 압축한 후의 사전 색인 번호를 배열로 출력하라.
	/* 예시
	 * msg							answer
	 * KAKAO						[11, 1, 27, 15]
	 * TOBEORNOTTOBEORTOBEORNOT		[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
	 * ABABABABABABABAB				[1, 2, 27, 29, 28, 31, 30]
	 */
	public int[] solution(String msg) {
		List<Integer> answer = new ArrayList<>();
		List<String> list = new ArrayList<>();
		int lth = msg.length();
		for (int i = 0; i < 26; i++)
			list.add(String.valueOf((char) (65 + i)));
		for (int i = 0; i < lth; i++)
			for (int j = i + 1; j < lth + 1; j++) {
				String temp = (j == lth) ? msg.substring(i) : msg.substring(i, j);
				if (!list.contains(temp)) {
					list.add(temp);
					answer.add(list.indexOf(msg.substring(i, j - 1)) + 1);
					i = j - 2;
					break;
				} else if (j == lth) {
					answer.add(list.indexOf(msg.substring(i)) + 1);
					return answer.stream().mapToInt(n -> n).toArray();
				}
			}
		return answer.stream().mapToInt(n -> n).toArray();
	}
}
