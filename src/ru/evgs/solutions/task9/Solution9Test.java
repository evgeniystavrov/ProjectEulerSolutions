package ru.evgs.solutions.task9;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution9Test {

    @Test
    void main() {
        Assert.assertEquals("200 * 375 * 425 = 31875000", new Solution9().run());
    }
}