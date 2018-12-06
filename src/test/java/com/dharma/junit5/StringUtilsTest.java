package com.dharma.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@Disabled
@RunWith(JUnitPlatform.class)
class StringUtilsTest {

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - executes before each test method in this class");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void done() {
        System.out.println("@AfterAll - executed after all test methods.");
    }

    @Test
    void testConvertToDoubleOK() {
        String age = "1990";
        Double expAge = 1990.0;
        Double actual = StringUtils.convertToDouble(age);

        assertAll("Do many assertions.", () -> {
            assertNotNull(actual);
            assertEquals(expAge, actual);
        });

        assertAll("Do many assertions.Java 8 Lambdas style", () -> {
            assertNotNull(actual, () -> "The actual is NULL");
            assertEquals(expAge, actual,
                    () -> "The expected is: " + expAge + " while the actual is:" + actual);
        });

    }

    @Test
    void testConvertToDoubleWithNullArgument() {
        String age = null;
        Double actual = StringUtils.convertToDouble(age);
        assertEquals(null, actual, "The actual is not null");
        assertNull(actual, "The actual is not null");
        assertNull(actual, () -> "The actual is not null");
    }

    @Test
    void testConvertToDoubleThrowException() {
        String age = "N/A";
        assertThrows(NumberFormatException.class, () -> {
            StringUtils.convertToDouble(age);
        });

        assertThrows(NumberFormatException.class, () -> {
            StringUtils.convertToDouble(age);
        });
    }

    @Test
    void testIsNullOrBlankOK() {
        String input = null;

        assertTrue(StringUtils.isNullOrBlank(input));
        assertTrue(StringUtils.isNullOrBlank(input), () -> "The string is not null or blank");

        input = " ";
        assertTrue(StringUtils.isNullOrBlank(input));

        input = "abc";
        assertFalse(StringUtils.isNullOrBlank(input));

    }

    @Test
    void testGetDefaultIfNull() {
        String st = null;
        String defaultSt = "abc";

        String actual = StringUtils.getDefaultIfNull(st, defaultSt);
        assertSame(defaultSt, actual);
        assertSame(defaultSt, actual, () -> "Expected ouput is not same with actual");

        st = "def";

        actual = StringUtils.getDefaultIfNull(st, defaultSt);
        assertNotSame(defaultSt, actual);
        assertNotSame(defaultSt, actual, () -> "Expected ouput is same with actual");

        st = "";
        actual = StringUtils.getDefaultIfNull(st, defaultSt);
        if (actual.equals(defaultSt)) {
            fail("The actual should be empty");

            fail(() -> "The actual should be empty");
        }

    }

    @Test
    void testConcatWithRegularInput() {
        String st1 = "Hello";
        String st2 = "World";
        String st3 = "!";
        String expect = st1 + st2 + st3;
        String actual = StringUtils.concat(st1, st2, st3);
        assertEquals(expect, actual);
    }

    @Test
    void testConcatWithNullInput() {
        String st1 = "Hello";
        String st2 = "World";
        String st3 = null;
        String expect = st1 + st2;
        String actual = StringUtils.concat(st1, st2, st3);
        assertEquals(expect, actual);
    }

    @DisplayName("Test concat with null")
    @Disabled("Not ready to test")
    @Test
    void testConcatWithAllNullInput() {
        String actual = StringUtils.concat();
        assertNull(actual);
    }
}
