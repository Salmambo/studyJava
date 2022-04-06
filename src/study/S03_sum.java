package study;
//2022.04.06.

public class S03_sum {
	public static void main(String[] args) {
		// 배열의 항목에서 최대값을 구하시오.
		// 배열의 전체 항목의 합과 평균값을 구하시오.
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int max = 0, sum = 0;
		double avg = 0.0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
				if (array[i][j] > max) {
					max = array[i][j];
				}
			}
			avg += array[i].length;
		}
		avg = sum / avg;

		System.out.println("max: " + max);
		System.out.println("sum: " + sum);
		System.out.println("avg: " + avg);
	}
}
