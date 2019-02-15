package ru.evgs.solutions.task13;

/*
	Большая сумма

	Найдите первые десять цифр суммы следующих ста 50-значных чисел.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;

public class Solution13 {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(new Solution13().run());
	}

	protected String run() throws FileNotFoundException {
		File file = new File("./res/numbers");
		Scanner input = new Scanner(file);
		ArrayList<String> numbers = new ArrayList<>();

		// вытаскиваем числа из файла
		while (input.hasNextLine()) {
			numbers.add(input.nextLine());
		}
		input.close();

		// вычисляем сумму
		BigInteger summ = BigInteger.ZERO;
		for (String num : numbers)
			summ = summ.add(new BigInteger(num));

		// выводим цифры суммы
		return summ.toString().substring(0, 10);
	}
}