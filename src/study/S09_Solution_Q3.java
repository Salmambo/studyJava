//2022.04.22.
package study;

public class S09_Solution_Q3 {

//	// Lv1 - 행렬의 덧셈
//	// 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
//	// 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.
//	// 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
//	/* 예시
//	 * arr1				arr2			return
//	 * [[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
//	 * [[1],[2]]		[[3],[4]]		[[4],[6]]
//	 */
//	public int[][] solution(int[][] arr1, int[][] arr2) {
//		int[][] answer = arr1;
//		for (int i = 0; i < arr1.length; i++) {
//			for (int j = 0; j < arr1[i].length; j++) {
//				answer[i][j] = arr1[i][j] + arr2[i][j];
//				// 이미 answer에 arr1을 넣었기 때문에 아래도 가능
//				// answer[i][j] += arr2[i][j];
//			}
//		}
//		return answer;
//	}

	// Lv1 - 핸드폰 번호 가리기
	// 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
	// 전화번호가 문자열 phone_number로 주어졌을 때,
	// 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
	// phone_number는 길이 4 이상, 20이하인 문자열입니다.
	public String solution(String phone_number) {
		String answer = "";
		for (int i = 0; i < phone_number.length() - 4; i++) {
			answer += "*";
		}
		return answer + phone_number.substring(phone_number.length() - 4);

//		// 정규식을 사용한 한 줄 종결
//		// ".(?=.{4})"
//		// 앞 . - String의 제일 첫 문자
//		// (?=) - 전방검색 즉 String의 앞부분을 찾는 정규식
//		// 뒤 . - {4} 앞의 문자
//		// {4} - String의 뒤에서 4개의 문자
//		// String의 제일 첫 문자부터 String의 제일 뒤 4개의 문자들 앞에 있는 문자까지 검색한다
//		return phone_number.replaceAll(".(?=.{4})", "*");
	}

	// Lv1 - 하샤드 수
	// 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
	// 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
	// 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
	// x는 1 이상, 10000 이하인 정수입니다.
	/* 예시
	 * arr	return
	 * 10	true
	 * 12	true
	 * 11	false
	 * 13	false
	 */
	public boolean solution(int x) {
//		int y = x, z = 0;
//		while (y > 0) {
//			z += y % 10;
//			y /= 10;
//		}
//		boolean answer = true;
//		if (x % z != 0)
//			answer = false;
//		return answer;

		// 두 줄로 줄이는 방법 - IntStream
		// String.valueOf(x) - x를 값으로 가진 문자열 생성
		// .chars().map(ch -> ch - '0').sum() - char로 변형해서 각각 '0'의 수만큼 뺀 후 합산
		int sum = String.valueOf(x).chars().map(ch -> ch - '0').sum();
		return x % sum == 0; // 조건식을 만족시 true, 불만족시 false
	}

}
