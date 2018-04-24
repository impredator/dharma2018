package com.dharma.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslationEngineDynamicTest {

  private TranslateService translatorEngine;

  @BeforeEach
  public void setUp() {
    translatorEngine = new TranslateService();
  }

  public void translateDynamicTestsRaw() {

    List<String> inPhrases = new ArrayList<>(Arrays.asList("Hello", "Yes", "No"));
    List<String> outPhrases = new ArrayList<>(Arrays.asList("Bonjour", "Oui", "Non"));
    Collection<DynamicTest> dynamicTests = new ArrayList<>();

    for (int i = 0; i < inPhrases.size(); i++) {

      String phr = inPhrases.get(i);
      String outPhr = outPhrases.get(i);

      // create an test execution
      Executable exec = () -> assertEquals(outPhr, translatorEngine.translate(phr));

      // create a test display name
      String testName = "Test translate " + phr;
      // create dynamic test
      DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);

      // add the dynamic test to collection
      dynamicTests.add(dTest);
    }
  }

  @Disabled
  // @TestFactory
  public Collection<DynamicTest> translateDynamicTests() {

    List<String> inPhrases =
        new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
    List<String> outPhrases =
        new ArrayList<>(Arrays.asList("Bonjour", "Oui", "Non", "Au revoir", "Bonne nuit", "Merci"));

    Collection<DynamicTest> dynamicTests = new ArrayList<>();

    for (int i = 0; i < inPhrases.size(); i++) {

      String phr = inPhrases.get(i);
      String outPhr = outPhrases.get(i);

      // create an test execution
      Executable exec = () -> assertEquals(outPhr, translatorEngine.translate(phr));

      // create a test display name
      String testName = "Test translate " + phr;
      // create dynamic test
      DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);

      // add the dynamic test to collection
      dynamicTests.add(dTest);
    }
    return dynamicTests;
  }

  // @Disabled
  @TestFactory
  public Stream<DynamicTest> translateDynamicTestsFromStream() {

    List<String> inPhrases =
        new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
    List<String> outPhrases =
        new ArrayList<>(Arrays.asList("Bonjour", "Oui", "Non", "Au revior", "Bonne nuit", "Merci"));

    return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest("Test translate " + phrs, () -> {
      int idx = inPhrases.indexOf(phrs);
      assertEquals(outPhrases.get(idx), translatorEngine.translate(phrs));
    }));
  }

  @Disabled
  // @TestFactory
  public Iterator<DynamicTest> translateDynamicTestsFromIterator() {

    List<String> inPhrases =
        new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
    List<String> outPhrases =
        new ArrayList<>(Arrays.asList("Bonjour", "Oui", "Non", "Au revoir", "Bonne nuit", "Merci"));

    return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest("Test translate " + phrs, () -> {
      int idx = inPhrases.indexOf(phrs);
      assertEquals(outPhrases.get(idx), translatorEngine.translate(phrs));
    })).iterator();
  }

  // @TestFactory
  public Iterable<DynamicTest> translateDynamicTestsFromIterate() {

    List<String> inPhrases =
        new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
    List<String> outPhrases =
        new ArrayList<>(Arrays.asList("Bonjour", "Oui", "Non", "Au revoir", "Bonne nuit", "Merci"));

    return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest("Test translate " + phrs, () -> {
      int idx = inPhrases.indexOf(phrs);
      assertEquals(outPhrases.get(idx), translatorEngine.translate(phrs));
    })).collect(Collectors.toList());
  }
}
