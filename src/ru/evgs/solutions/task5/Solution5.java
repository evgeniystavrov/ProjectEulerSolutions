package ru.evgs.solutions.task5;

/*
	Наименьшее кратное

	2520 - самое маленькое число, которое делится без остатка на все числа от 1 до 10.

	Какое самое маленькое число делится нацело на все числа от 1 до 20?
*/

public class Solution5 {
	public static void main(String[] args) {
		System.out.println(new Solution5().run());
	}

	protected String run() {
		int target = 1;

		while (true) {
			if (isMinimalDividend(target)) { break; }

			target++;
		}

		return Integer.toString(target);
	}

	private boolean isMinimalDividend(int number) {
		boolean result = true;

		for (int i = 1; i < 21; i++) {
			if (number % i != 0) {
				result = false;
				break;
			}
		}

		return result;
	}
}