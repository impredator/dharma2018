package com.dharma.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JUnitPlatform.class)
class TranslateServiceTest {

    private TranslateService Translator;

    @BeforeEach
    void setUp() {
        Translator = new TranslateService();
    }

    @Test
    void testTranslateHello() {
        assertEquals("Bonjour", Translator.translate("Hello"));
    }

    @Test
    void testTranslateHelloWithCase() {
        assertEquals("Bonjour", Translator.translate("hEllo"));
    }

    @Test
    void testTranslateYes() {
        assertEquals("Oui", Translator.translate("Yes"));
    }

    @Test
    void testTranslateNo() {
        assertEquals("Non", Translator.translate("No"));
    }

    @Test
    void testTranslateNotExist() {
        assertEquals("Not found", Translator.translate("Dharma"));
    }

    @Test
    void testTranslateBlank() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Translator.translate("");
        });

        assertEquals(exception.getMessage(), "Translated text must not be empty.");
    }

}
