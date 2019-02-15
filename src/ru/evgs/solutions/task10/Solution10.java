package ru.evgs.solutions.task10;

/*
	Сумма простых чисел меньше 10 равна 2 + 3 + 5 + 7 = 17.

	Найдите сумму всех простых чисел меньше двух миллионов.
*/


public class Solution10 {
	public static void main(String[] args) {
		System.out.println(new Solution10().run());
	}

	protected String run() {
		int sum = 0;
		for (int i = 1; i < 2_000_001; i++) {
			if (isPrime(i)) {
				sum += i;
			}
		}

		return Integer.toString(sum);
	}

	protected boolean isPrime(int number) {
		if (number % 2 == 0) { return number == 2; }
		if (number % 3 == 0) { return number == 3; }

		int step = 4;
		int m = (int) Math.sqrt(number) + 1;
		for (int i = 5; i < m; step = 6 - step, i += step) {
			if (number % i == 0) { return false; }
		}

		return true;
	}
}