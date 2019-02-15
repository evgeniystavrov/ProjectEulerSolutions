package ru.evgs.solutions.task12;

/*
	Треугольное число с большим количеством делителей
	Последовательность треугольных чисел образуется путем сложения натуральных чисел. 
	К примеру, 7-ое треугольное число равно 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. Первые десять треугольных чисел:
									1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
	Перечислим делители первых семи треугольных чисел:

	 1: 1
	 3: 1, 3
	 6: 1, 2, 3, 6
	10: 1, 2, 5, 10
	15: 1, 3, 5, 15
	21: 1, 3, 7, 21
	28: 1, 2, 4, 7, 14, 28

	Как мы видим, 28 - первое треугольное число, у которого более пяти делителей.
	Каково первое треугольное число, у которого более пятисот делителей?
*/

public class Solution12 {
	public static void main(String[] args){
		System.out.println(new Solution12().run());
	}

	protected String run() {
		int i = 1;
		int trgl_number = 0;
		int counter;

		while(true) {
			// обнуляем счётчик
			counter = 0;
			// вычисляем треугольное число
			trgl_number = (i * (i + 1)) / 2;
			// считаем делители
			for (int j = 1; j < Math.sqrt(trgl_number); j++) {
				if (trgl_number % j == 0) { counter += 2; }
			}
			// ???
			if (Math.sqrt(trgl_number) * Math.sqrt(trgl_number) == trgl_number) { counter++; }
			// если счётчик больше 500 выходим
			if (counter > 500) { break; }
			// переходим к следующему числу
			i++;
		}

		return Integer.toString(trgl_number);
	}
}