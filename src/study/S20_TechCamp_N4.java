//2022.05.14.
package study;

public class S20_TechCamp_N4 {

	// 4번
	/* 다음과 같이 숫자를 알파벳 대소문자, 숫자, 기호를 조합해서 표현할 수 있습니다.
	 * 숫자	기호
	 * 0	O(알파벳 대문자 오), ()
	 * 1	I(알파벳 대문자 아이)
	 * 2	Z, S, 7_
	 * 3	E, B
	 * 4	A
	 * 5	Z, S
	 * 6	b, G
	 * 7	T, Y
	 * 8	B, E3
	 * 9	g, q
	 */
	/* 이때, 숫자로 이루어진 문자열을 표현하는 방법은 다음과 같습니다.
	 * 각 숫자는 정해진 방식에 따라 비슷한 모양의 다른 기호로 치환해서 적습니다.
	 * 이때, 다른 기호로 치환하지 않고 그대로 적어도 됩니다.
	 * 한 숫자가 서로 다른 기호로 치환될 수 있습니다.
	 * 단, 서로 다른 숫자가 같은 기호로 치환되지는 않습니다.
	 */
	/* 예를 들어 숫자 "2455373"의 경우 다음과 같은 방식으로 치환됩니다.
	 * "ZASSETE", "S4Z537B", "7_ASZEYB", ...
	 * 다음은 "2455373"을 치환한 결과가 아닙니다.
	 * "ZAZZ373"
	 * 첫 번째 숫자 2와 세 번째 숫자 5가 같은 기호 'Z'로 치환되어 3번 규칙에 맞기 않기 때문입니다.
	 * 따라서 위 문자열의 경우 원래 문자열은 "2422373" 또는 "5455373"입니다.
	 */
	/* 또 다른 예시로 숫자 "225"의 경우 다음과 같이 치환할 수 있습니다.
	 * "ZZ5", "ZZS", "SSZ", "Z7_S", "S7_Z", "SZ5" ...
	 * 그러나 "225"를 "ZSZ" 나 "SSS"와 같이 치환할 수는 없습니다.
	 */
	// 문자열들이 담긴 배열 numstrs와 숫자로된 단어들이 담긴 배열 words가 매개변수로 주어질 때,
	// 각 단어가 포함된 문자열은 몇개인지 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
	// numstrs의 길이는 1 이상 100 이하입니다.
	// numstrs의 각 원소는 길이가 1 이상 100 이하인 문자열입니다.
	// numstrs의 문자열은 알파벳 대소문자와 숫자, 특수 문자 (, ), _로만 이루어져 있습니다.
	// 규칙에 맞게 치환한 문자열만 입력으로 주어집니다.
	// words의 길이는 1 이상 10 이하입니다.
	// words의 원소는 길이가 1 이상 8 이하인 문자열입니다.
	// words의 문자열은 숫자로만 이루어져 있습니다.
	// 숫자 문자열은 0으로 시작할 수 있습니다.
	// 매칭된 부분 문자열을 제외한 나머지 문자열들이 올바르게 치환된 문자열이 아니어도 괜찮습니다.
	// 예를 들어 "B7_"에서, "37"를 검색한 경우, "B7"가 "37"를 치환한 문자열로 검색되고 "_"는 매칭되는 문자가 없지만 무시해도
	// 됩니다.
	/* 예시
	 * numstrs								words								result
	 * ["ZASSETE", "S4Z537B", "7_ASZEYB"]	["2455373", "425", "373", "378"]	[3, 2, 3, 2]
	 * ["ZAZZ373"]							["2422373", "5455373", "2455373"]	[1, 1, 0]
	 */
	public int[] solution(String[] numstrs, String[] words) {
		int[] answer = new int[words.length];
		// numstrs를 숫자로 치환 (예외: E, E3, Z, S, 7_, B)
		for (int i = 0; i < numstrs.length; i++)
			numstrs[i] = numstrs[i].replace('O', '0').replace('I', '1').replace('A', '4').replace('b', '6')
					.replace('G', '6').replace('T', '7').replace('Y', '7').replace('g', '9').replace('q', '9')
					.replace('(', '0').replaceAll("[)]", "");
		// 위 예외 문자로 만들 수 있는 경우의 수를 고려하여 numstrs와 words(temp)를 비교
		for (int i = 0; i < words.length; i++)
			for (int j = 0; j < numstrs.length; j++) {
				boolean exist = false;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "2").replace('E', '3').replace('Z', '2')
						.replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "2").replace('E', '3').replace('Z', '2')
						.replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "7").replace('E', '3').replace('Z', '2')
						.replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "7").replace('E', '3').replace('Z', '2')
						.replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "2").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '2').replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "2").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '2').replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "7").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '2').replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "7").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '2').replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "2").replace('E', '3').replace('Z', '5')
						.replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "2").replace('E', '3').replace('Z', '5')
						.replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "7").replace('E', '3').replace('Z', '5')
						.replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "7").replace('E', '3').replace('Z', '5')
						.replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "2").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '5').replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "2").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '5').replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "7").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '5').replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "7").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '5').replace('S', '2').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "2").replace('E', '3').replace('Z', '2')
						.replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "2").replace('E', '3').replace('Z', '2')
						.replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "7").replace('E', '3').replace('Z', '2')
						.replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "7").replace('E', '3').replace('Z', '2')
						.replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "2").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '2').replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "2").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '2').replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "7").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '2').replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "7").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '2').replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "2").replace('E', '3').replace('Z', '5')
						.replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "2").replace('E', '3').replace('Z', '5')
						.replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "7").replace('E', '3').replace('Z', '5')
						.replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "7").replace('E', '3').replace('Z', '5')
						.replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "2").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '5').replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "2").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '5').replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '3').replaceAll("7_", "7").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '5').replace('S', '5').contains(words[i]))
					exist = true;
				if (numstrs[j].replace('B', '8').replaceAll("7_", "7").replaceAll("E3", "8").replace('E', '3')
						.replace('Z', '5').replace('S', '5').contains(words[i]))
					exist = true;
				if (exist)
					answer[i]++;
			}
		return answer;
	}
}
