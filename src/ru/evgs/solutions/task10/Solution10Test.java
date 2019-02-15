package ru.evgs.solutions.task10;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution10Test {

    @Test
    void main() {
        Assert.assertEquals("1179908155", new Solution10().run());
    }

    @Test
    void isPrime() {
        Assert.assertFalse(new Solution10().isPrime(4));
    }
}