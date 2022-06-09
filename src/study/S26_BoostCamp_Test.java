//2022.06.09.
package study;

import java.util.ArrayList;
import java.util.Arrays;

public class S26_BoostCamp_Test {

	// 자연수가 들어있는 배열 arr가 매개변수로 주어집니다.
	// 배열 arr안의 숫자들 중에서 앞에 있는 숫자들부터 뒤에 중복되어 나타나는 숫자들 중복 횟수를 계산해서
	// 배열로 return 하도록 solution 함수를 완성해주세요.
	// 만약 중복되는 숫자가 없다면 배열에 -1을 채워서 return 하세요.
	// 배열 arr의 길이는 1 이상 100 이하의 자연수입니다.
	// 배열 arr의 원소는 1 이상 100 이하의 자연수입니다.
	/* 예시
	 * arr							return
	 * [1, 2, 3, 3, 3, 3, 4, 4]		[4, 2]
	 * [3, 2, 4, 4, 2, 5, 2, 5, 5]	[3, 2, 3]
	 * [3, 5, 7, 9, 1]				[-1]
	 */
	public static int[] solution(int[] arr) {
		int[] tmp = Arrays.stream(arr).distinct().toArray();
		if (tmp.length == arr.length)
			return new int[] { -1 };
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i : tmp) {
			int cnt = 0;
			for (int j : arr)
				if (i == j)
					cnt++;
			if (cnt > 1)
				answer.add(cnt);
		}
		return answer.stream().mapToInt(i->i).toArray();
	}
}
