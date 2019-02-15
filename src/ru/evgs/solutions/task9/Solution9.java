package ru.evgs.solutions.task9;

/*
	Тройка Пифагора - три натуральных числа a < b < c, для которых выполняется равенство

	a^2 + b^2 = c^2
	Например, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

	Существует только одна тройка Пифагора, для которой a + b + c = 1000.
	Найдите произведение abc.
*/

public class Solution9 {
	public static void main(String[] args) {
		System.out.println(new Solution9().run());
	}

	protected String run() {
		String string = "";

		outer:
		for (int a = 4; a < 500; a++) {
			for (int b = 4; b < 500; b++) {
				if (((int)Math.pow(a, 2) + (int)Math.pow(b, 2)) == ((int)Math.pow((1000 - a - b), 2))) {
					string = a + " * " + b + " * " + (1000 - a - b) + " = " + (a * b * (1000 - a - b));
					break outer;
				}
			}
		}

		return string;
	}
}