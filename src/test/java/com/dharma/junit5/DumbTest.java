package com.dharma.junit5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@RunWith(JUnitPlatform.class)
class DumbTest {
    private static Dumb dumb;

    @BeforeAll
    static void init() {
        dumb = new Dumb();
    }

    @Test
    void lambdaExpressions() {
        assertTrue(dumb.getSum(1,2,3) > 5, "Sum should be greater than 5");
    }

    @Test
    void groupAssertions() {
        int[] numbers = dumb.getNumbers();
        assertAll("numbers",
                () -> assertEquals(numbers[0], 0),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 4)
        );
    }

    @Test
    void trueAssumption() {
        assumeTrue(true);
        assertEquals(5 + 2, 7);
    }

    @Test
    void falseAssumption() {
        assumeFalse(5 < 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void assumptionThatOne() {
        String someString = "Just a string".concat("!");
        assumingThat(
                someString.equals("Just a string"),
                () -> assertEquals(2 + 2, 2)
        );

        assumingThat(
                someString.equals("Just a string!"),
                () -> System.out.println("happens if assume condition is true"));
    }
}
