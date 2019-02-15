package ru.evgs.solutions.task14;

/*
	Следующая повторяющаяся последовательность определена для множества натуральных чисел:

	n → n/2 (n - четное)
	n → 3n + 1 (n - нечетное)

	Используя описанное выше правило и начиная с 13, сгенерируется следующая последовательность:

	13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
	Получившаяся последовательность (начиная с 13 и заканчивая 1) содержит 10 элементов. 
	Хотя это до сих пор и не доказано (проблема Коллатца (Collatz)), предполагается, что 
	все сгенерированные таким образом последовательности оканчиваются на 1.

	Какой начальный элемент меньше миллиона генерирует самую длинную последовательность?

	Примечание: Следующие за первым элементы последовательности могут быть больше миллиона.
*/

import java.math.BigInteger;

public class Solution14 {
	// можно установить любое неотрицательное число
	private static final int LIMIT = (int) Math.pow(10, 6);
	// запоминание
	private static final BigInteger CACHE_SIZE = BigInteger.valueOf(LIMIT);
	private int[] collatzChainLength = new int[CACHE_SIZE.intValue()];

	public static void main(String[] args) {
		System.out.println(new Solution14().run());
	}
	/*
		вычисляем длину цепи Коллатца для каждого целого числа в диапазоне в соответствии с правилом итерации.
		кроме того, кешируем значение цепочки для маленьких целочисленных аргументов, чтобы ускорить вычисления.
	*/
	protected String run() {
		int chain_max_length = 0;
		int el_max_length = -1;

		for (int i = 1; i < LIMIT; i++) {
			int chain_length = collatzChainLength(BigInteger.valueOf(i));

			if (chain_length > chain_max_length) {
				chain_max_length = chain_length;
				el_max_length = i;
			}
		}

		return Integer.toString(el_max_length);
	}

	// возвращает длину цепочки Коллатца для заданного целого числа с автоматическим кэшированием.
	private int collatzChainLength(BigInteger number) {
		if (number.signum() < 0) {
			throw new IllegalArgumentException();
		}

		if (number.compareTo(CACHE_SIZE) >= 0) { // кеширование недоступно
			return collatzChainLengthDirect(number);
		}

		int index = number.intValue(); // индекс в кеше
		if (collatzChainLength[index] == 0) {
			collatzChainLength[index] = collatzChainLengthDirect(number);
		}

		return collatzChainLength[index];
	}
	/*
		возвращает длину цепочки Коллатца для заданного целого числа,
		причем первый шаг не кэшируется, но остальные шаги с использованием автоматического кэширования.
	*/
	private int collatzChainLengthDirect(BigInteger number) {
		if (number.equals(BigInteger.ONE)) { // базовый вариант
			return 1;
		} else if (!number.testBit(0)) { // если n чётно
			return collatzChainLength(number.shiftRight(1)) + 1;
		} else {
			return collatzChainLength(number.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE)) + 1;
		}
	}
}