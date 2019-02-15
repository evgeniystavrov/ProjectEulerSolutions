package ru.evgs.solutions.task15;

/*
	Начиная в левом верхнем углу сетки 2×2 и имея возможность двигаться только вниз или вправо, 
	существует ровно 6 маршрутов до правого нижнего угла сетки.

	Сколько существует таких маршрутов в сетке 20×20?
*/

import java.math.BigInteger;

public class Solution15 {
	// фиксируем количество рёбер образующих строну таблицы
	private static final int EDGE_COUNT = 2;

	public static void main(String[] args){
		System.out.println(new Solution15().run());
	}

	protected String run() {
		/*
			Это классическая проблема комбинаторики.
			Чтобы попасть из верхнего левого угла в нижний правый угол сетки N * N,
			нужно сделать ровно N движений вправо и N движений вниз.
			Поскольку каждое движение вниз или вправо неразличимо,
			существует ровно 2N по N способов организации этих движений.
		*/
		return Solution15.binomial(40, 20).toString();
	}

	private static BigInteger binomial(int n, int k) {
		if (k < 0 || k > n)
			throw new IllegalArgumentException();
		BigInteger product = BigInteger.ONE;
		for (int i = 0; i < k; i++)
			product = product.multiply(BigInteger.valueOf(n - i));
		return product.divide(factorial(k));
	}

	private static BigInteger factorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Factorial of negative number");
		BigInteger prod = BigInteger.ONE;
		for (int i = 2; i <= n; i++)
			prod = prod.multiply(BigInteger.valueOf(i));
		return prod;
	}

}