package com.dharma.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class TranslateServiceTest {

  private TranslateService Translator;

  @BeforeEach
  void setUp() {
    Translator = new TranslateService();
  }

  @Test
  void testTranlsateHello() {
    assertEquals("Bonjour", Translator.tranlate("Hello"));
  }

  @Test
  void testTranlsateYes() {
    assertEquals("Oui", Translator.tranlate("Yes"));
  }

  @Test
  void testTranlsateNo() {
    assertEquals("Non", Translator.tranlate("No"));
  }

}
