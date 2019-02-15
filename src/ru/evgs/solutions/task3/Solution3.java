package ru.evgs.solutions.task3;

/*
	Наибольший простой делитель
	Простые делители числа 13195 - это 5, 7, 13 и 29.

	Каков самый большой делитель числа 600851475143, являющийся простым числом?
*/
import java.util.Collections;
import java.util.ArrayList;

public class Solution3 {
	public static void main(String[] args) {
		System.out.println(new Solution3().run());
	}

    protected String run() {
        long target = 600851475143L;
        ArrayList<Long> factors = new ArrayList<Long>();

        factors = findFactors(target);

        long max_factor = Collections.max(factors);

        return Long.toString(max_factor);
    }

    // метод нахождения простых множителей
	private ArrayList<Long> findFactors(long number) {
        ArrayList<Long> factors = new ArrayList<Long>();

        // Проверяем делимость на 2.
        while (number % 2L == 0) {
            factors.add(2L);
            number = number / 2L;
        }

        // Ищем нечетные множители.
        long i = 3;
        long max_factor = (long) Math.sqrt(number);
        while (i <= max_factor) {
            // Проверяем делимость на i.
            while (number % i == 0) {
                // i является множителем. Добавляем его в список.
                factors.add(i);

                // Делим число на i.
                number = number / i;

                // Устанавливаем новую верхнюю границу.
                max_factor = (long) Math.sqrt(number);
            }

            // Проверяем следующий возможный нечетный множитель.
            i += 2;
        }

        // Если от числа что-то осталось, остаток тоже множитель.
        if (number > 1) { factors.add(number); }

        return factors;
    }
}