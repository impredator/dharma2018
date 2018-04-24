package com.dharma.junit5;

import org.junit.platform.commons.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class TranslateService {

    private Map<String, String> dictionary = new HashMap<>();

    TranslateService() {
        initDict();
    }

    public String translate(String text) {
        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException("Translated text must not be empty.");
        }
        return fromEnglishToFrench(text);
    }

    private void initDict() {
        dictionary.put("hello", "Bonjour");
        dictionary.put("yes", "Oui");
        dictionary.put("no", "Non");
        dictionary.put("goodbye", "Au revoir");
        dictionary.put("good night", "Bonne nuit");
        dictionary.put("thank you", "Merci");
    }

    private String fromEnglishToFrench(String text) {
        String textLowerCase = text.toLowerCase();
        return dictionary.getOrDefault(textLowerCase, "Not found");
    }
}