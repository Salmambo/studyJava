//2022.07.14.
package study;

public class S40_Solution_Q1 {

	// Lv.2 - 파일명 정렬
	// 저장소 서버에는 프로그램의 과거 버전을 모두 담고 있어, 이름 순으로 정렬된 파일 목록은 보기가 불편했다.
	// 파일을 이름 순으로 정렬하면 나중에 만들어진 ver-10.zip이 ver-9.zip보다 먼저 표시되기 때문이다.
	// 무지는 단순한 문자 코드 순이 아닌, 파일명에 포함된 숫자를 반영한 정렬 기능을 저장소 관리 프로그램에 구현하기로 했다.
	// 소스 파일 저장소에 저장된 파일명은 100 글자 이내로,
	// 영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")만으로 이루어져 있다.
	// 파일명은 영문자로 시작하며, 숫자를 하나 이상 포함하고 있다.
	/* 파일명은 크게 HEAD, NUMBER, TAIL의 세 부분으로 구성된다.
	 * HEAD는 숫자가 아닌 문자로 이루어져 있으며, 최소한 한 글자 이상이다.
	 * NUMBER는 한 글자에서 최대 다섯 글자 사이의 연속된 숫자로 이루어져 있으며, 앞쪽에 0이 올 수 있다.
	 * TAIL은 그 나머지 부분으로, 여기에는 숫자가 다시 나타날 수도 있으며, 아무 글자도 없을 수 있다.
	 */
	/* 파일명을 세 부분으로 나눈 후, 다음 기준에 따라 파일명을 정렬한다.
	 * 파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬한다. 이때, 문자열 비교 시 대소문자 구분을 하지 않는다.
	 * 파일명의 HEAD 부분이 대소문자 차이 외에는 같을 경우, NUMBER의 숫자 순으로 정렬한다.
	 * 숫자 앞의 0은 무시되며, 012와 12는 정렬 시에 같은 같은 값으로 처리된다.
	 * 두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지한다.
	 */
	// files는 1000 개 이하의 파일명을 포함하는 문자열 배열이다.
	// 각 파일명은 100 글자 이하 길이로, 영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")만으로 이루어져 있다.
	// 중복된 파일명은 없으나, 대소문자나 숫자 앞부분의 0 차이가 있는 경우는 함께 주어질 수 있다.
	/* 예시
	 * 입력												출력
	 * ["img12.png", "img10.png", "img02.png",			["img1.png", "IMG01.GIF", "img02.png",
	 * "img1.png", "IMG01.GIF", "img2.JPG"]				"img2.JPG", "img10.png", "img12.png"]
	 * ["F-5 Freedom Fighter", "B-50 Superfortress",	["A-10 Thunderbolt II", "B-50 Superfortress",
	 * "A-10 Thunderbolt II", "F-14 Tomcat"]			"F-5 Freedom Fighter", "F-14 Tomcat"]
	 */
	public String[] solution(String[] files) {
		String temp;
		for (int i = 0; i < files.length - 1; i++)
			for (int j = 0; j < files.length - 1 - i; j++) {
				String[] once = split(files[j]);
				String[] sonra = split(files[j + 1]);
				if (once[0].compareToIgnoreCase(sonra[0]) > 0) {
					temp = files[j];
					files[j] = files[j + 1];
					files[j + 1] = temp;
				} else if (once[0].compareToIgnoreCase(sonra[0]) == 0)
					if (Integer.parseInt(once[1]) > Integer.parseInt(sonra[1])) {
						temp = files[j];
						files[j] = files[j + 1];
						files[j + 1] = temp;
					}
			}
		return files;
	}

	private String[] split(String file) {
		String[] split = new String[2];
		for (int i = 1; i < file.length(); i++)
			if (file.charAt(i) > 47 && file.charAt(i) < 58) {
				split[0] = file.substring(0, i);
				if (i == file.length() - 1)
					split[1] = file.substring(i);
				for (int j = i + 1; j < file.length(); j++)
					if (file.charAt(j) < 48 || file.charAt(j) > 57) {
						split[1] = file.substring(i, j);
						break;
					} else if (j + 1 == file.length()) {
						split[1] = file.substring(i);
						break;
					}
				break;
			}
		return split;
	}
}
