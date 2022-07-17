//2022.07.17.
package study;

import java.util.TreeMap;

public class S43_Solution_Q1 {

	// Lv.2 - 방금그곡
	// 네오는 자신이 기억한 멜로디를 가지고 방금그곡을 이용해 음악을 찾는다.
	// 그런데 라디오 방송에서는 한 음악을 반복해서 재생할 때도 있어서
	// 네오가 기억하고 있는 멜로디는 음악 끝부분과 처음 부분이 이어서 재생된 멜로디일 수도 있다.
	// 반대로, 한 음악을 중간에 끊을 경우
	// 원본 음악에는 네오가 기억한 멜로디가 들어있다 해도 그 곡이 네오가 들은 곡이 아닐 수도 있다.
	// 그렇기 때문에 네오는 기억한 멜로디를 재생 시간과 제공된 악보를 직접 보면서 비교하려고 한다.
	/* 다음과 같은 가정을 할 때 네오가 찾으려는 음악의 제목을 구하여라.
	 * 방금그곡 서비스에서는 음악 제목, 재생이 시작되고 끝난 시각, 악보를 제공한다.
	 * 네오가 기억한 멜로디와 악보에 사용되는 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개이다.
	 * 각 음은 1분에 1개씩 재생된다.
	 * 음악은 반드시 처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다.
	 * 음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.
	 * 음악이 00:00를 넘겨서까지 재생되는 일은 없다.
	 * 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다.
	 * 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
	 * 조건이 일치하는 음악이 없을 때에는 “(None)”을 반환한다.
	 */
	/* 입력으로 네오가 기억한 멜로디를 담은 문자열 m과 방송된 곡의 정보를 담고 있는 배열 musicinfos가 주어진다.
	 * m은 음 1개 이상 1439개 이하로 구성되어 있다.
	 * musicinfos는 100개 이하의 곡 정보를 담고 있는 배열로,
	 * 각각의 곡 정보는 음악이 시작한 시각, 끝난 시각, 음악 제목, 악보 정보가 ','로 구분된 문자열이다.
	 * 음악의 시작 시각과 끝난 시각은 24시간 HH:MM 형식이다.
	 * 음악 제목은 ',' 이외의 출력 가능한 문자로 표현된 길이 1 이상 64 이하의 문자열이다.
	 * 악보 정보는 음 1개 이상 1439개 이하로 구성되어 있다.
	 */
	/* 예시
	 * m			musicinfos													answer
	 * "ABCDEFG"	["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"HELLO"
	 * "ABC"		["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"WORLD"
	 */
	public String solution(String m, String[] musicinfos) {
		m = m.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#",
				"a");
		TreeMap<Integer, String> answer = new TreeMap<>();
		answer.put(0, "(None)");
		for (String musicinfo : musicinfos) {
			String[] temp = musicinfo.split(",");
			int time = (Integer.parseInt(temp[1].substring(0, 2)) - Integer.parseInt(temp[0].substring(0, 2))) * 60
					+ (Integer.parseInt(temp[1].substring(3)) - Integer.parseInt(temp[0].substring(3)));
			temp[3] = temp[3].replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g")
					.replaceAll("A#", "a");
			musicinfo = "";
			for (int i = 0; i < time; i++)
				musicinfo += temp[3].charAt(i % temp[3].length());
			if (musicinfo.contains(m))
				answer.putIfAbsent(time, temp[2]);
		}
		return answer.get(answer.lastKey());
	}
}
