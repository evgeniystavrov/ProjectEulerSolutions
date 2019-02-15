package ru.evgs.solutions.task6;

/*
	Разность между суммой квадратов и квадратом суммы

	Сумма квадратов первых десяти натуральных чисел равна
				1^2 + 2^2 + ... + 10^2 = 385
	Квадрат суммы первых десяти натуральных чисел равен
			(1 + 2 + ... + 10)^2 = 552 = 3025
	Следовательно, разность между суммой квадратов и квадратом суммы первых десяти натуральных чисел составляет 3025 − 385 = 2640.
	Найдите разность между суммой квадратов и квадратом суммы первых ста натуральных чисел.
*/

import static java.lang.Math.pow;

public class Solution6 {
	public static void main(String[] args) {
		System.out.println(new Solution6().run());
	}

	protected String run() {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 1; i < 101; i++) {
			sum1 += pow(i, 2);
			sum2 += i;
		}

		return Long.toString((long)(pow(sum2, 2) - sum1));
	}
}