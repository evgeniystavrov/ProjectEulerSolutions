package ru.evgs.solutions.task13;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class Solution13Test {

    @Test
    void run() throws FileNotFoundException {
        Assert.assertEquals("5537376230", new Solution13().run());
    }
}