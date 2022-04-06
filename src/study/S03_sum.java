package study;
//2022.04.06.

public class S03_sum {
	public static void main(String[] args) {
		// 배열의 항목에서 최대값을 구하시오.
		// 배열의 전체 항목의 합과 평균값을 구하시오.
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int max = 0, sum = 0;
		double avg = 0.0;

		for (int i = 0; i < array.length; i++) { // array의 행 추출
			for (int j = 0; j < array[i].length; j++) { // 각 행의 값 추출
				avg++; // 평균의 분모 자리에 들어갈, 배열 속 개수
				sum += array[i][j]; // 전체 항목의 합
				if (array[i][j] > max) { // 최대값
					max = array[i][j];
				}
			}
//			avg += array[i].length; // 평균의 분모 자리에 들어갈, 배열 속 개수
		}
		avg = sum / avg; // 평균값

		System.out.println("max: " + max);
		System.out.println("sum: " + sum);
		System.out.println("avg: " + avg);
	}
}
