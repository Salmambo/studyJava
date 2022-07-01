//2022.07.01.
package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class S35_Mobis {
	/* // Dead or Arrive
	private static String[] speed;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		speed = new String[n];
		long[] power = new long[n];
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			speed[i] = temp[0];
			power[i] = Long.parseLong(temp[1]);
		}
		int idx = 0;
		long answer = 0;
		while (idx < n) {
			if (!speed[idx].isEmpty())
				answer += check(power, idx);
			idx++;
		}
		System.out.println(answer);
	}
	
	private static long check(long[] power, int idx) {
		long result = idx + 1;
		for (int i = idx + 1; i < speed.length; i++)
			if (speed[idx].equals(speed[i])) {
				if (power[idx] <= power[i])
					result = i + 1;
				speed[i] = "";
			}
		return result;
	}*/

	/* // 생성공정 ......다 풀었는데 옮겨적다가 정답 확인 못 함
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] process = new String[n];
		for (int i = 0; i < n; i++)
			process[i] = br.readLine();
		int k = Integer.parseInt(br.readLine());
		String[] research = new String[k];
		for (int i = 0; i < k; i++)
			research[i] = br.readLine();
		String[] answer = new String[k];
		for (int i = 0; i < k; i++) {
			Map<String, Integer> result = new TreeMap<>();
			for (String string : process)
				if (string.startsWith(research[i]))
					result.put(string, result.getOrDefault(string, 0) + 1);
			if (result.isEmpty())
				answer[i] = "0";
			else {
				LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(result.entrySet());
				list.sort(Map.Entry.comparingByValue());
				answer[i] = list.getLast().getKey() + " " + list.getLast().getValue();
				for (int j = list.size() - 2; j >= 0; j--)
					if (list.get(j).getValue() == list.getLast().getValue())
						answer[i] = list.get(j).getKey() + " " + list.get(j).getValue();
					else
						break;
			}
		}
		for (String string : answer)
			System.out.println(string);
	}*/
}
