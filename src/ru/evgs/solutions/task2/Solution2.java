package ru.evgs.solutions.task2;

/*
	Четные числа Фибоначчи
	Каждый следующий элемент ряда Фибоначчи получается при сложении двух предыдущих. Начиная с 1 и 2, первые 10 элементов будут:

	1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

	Найдите сумму всех четных элементов ряда Фибоначчи, которые не превышают четыре миллиона.
*/

public class Solution2 {
	public static void main(String[] args) {
		System.out.println(new Solution2().run());
	}

    protected String run() {
        int sum = 0;
        int fn = 0;
        int f2 = 1;
        int f1 = 1;

        while (true) {
            fn = f2 + f1;

            if (fn % 2 == 0) { sum += fn; }

            f1 = f2;
            f2 = fn;

            if (fn > 4_000_000) break;
        }

        return Integer.toString(sum);
    }
}