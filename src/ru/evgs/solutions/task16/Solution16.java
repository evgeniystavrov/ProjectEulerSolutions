package ru.evgs.solutions.task16;

/*
    2^15 = 32768, сумма цифр этого числа равна 3 + 2 + 7 + 6 + 8 = 26. Какова сумма цифр числа 2^1000?
*/

import java.math.BigInteger;

public class Solution16 {
    public static void main(String[] args) {
        System.out.println(new Solution16().run());
    }

    protected String run() {
        return Integer.toString(bigIntegerPowSum(2, 1000));
    }

    private int bigIntegerPowSum(long base, int power) {
        BigInteger b = BigInteger.valueOf(base);
        BigInteger a = b.pow(power);
        String result = a.toString();
        char[] chars = result.toCharArray();

        int sum = 0;
        for (Character c : chars) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }


}
