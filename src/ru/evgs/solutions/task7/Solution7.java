package ru.evgs.solutions.task7;

/*
	10001-ое простое число

	Выписав первые шесть простых чисел, получим 2, 3, 5, 7, 11 и 13. Очевидно, что 6-ое простое число - 13.

	Какое число является 10001-ым простым числом?
*/

public class Solution7 {
	public static void main(String[] args) {
		System.out.println(new Solution7().run());
	}

	protected String run() {
		int target = 14;
		int counter = 0;
		while (true) {
			if (isPrime(target)) { counter++; }
			if (counter == 10001) { break; }
			target++;
		}

		return Integer.toString(target);
	}

	private boolean isPrime(int number) {
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