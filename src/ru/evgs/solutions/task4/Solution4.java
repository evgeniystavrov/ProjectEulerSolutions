package ru.evgs.solutions.task4;

/*
	Наибольшее произведение-палиндром
	Число-палиндром с обеих сторон (справа налево и слева направо) читается одинаково. Самое большое число-палиндром, 
	полученное умножением двух двузначных чисел – 9009 = 91 × 99.

	Найдите самый большой палиндром, полученный умножением двух трехзначных чисел.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution4 {
	public static void main(String[] args) {
		System.out.println(new Solution4().run());
	}

	protected String run() {
		ArrayList<Integer> palindromes = new ArrayList<Integer>();

		for (int i = 999; i > 99; i--) {
			for (int j = 999; j > 99; j--) {
				if (isPalindrome(Integer.toString(i * j))) {
					palindromes.add(i * j);
				}
			}
		}


		return Integer.toString(Collections.max(palindromes));
	}

	private boolean isPalindrome(String str) {
		boolean result = true;

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				result = false;
				break;
			} 
		}

		return result;
	}
}