package com.example.ServiceMenuCoffee.utils;

import lombok.NoArgsConstructor;

import java.util.ResourceBundle;

@NoArgsConstructor
public class ResourceBundleLanguage {

    private static final ResourceBundle RU = ResourceBundle.getBundle("language.ru");
    private static final ResourceBundle EN = ResourceBundle.getBundle("language.en");
    private static final ResourceBundle KG = ResourceBundle.getBundle("language.kg");

    public static String periodMessage(Language language, String key) {

        switch (language) {
            case RU -> {
                return RU.getString(key);
            }
            case EN -> {
                return EN.getString(key);
            }
            case KG -> {
                return KG.getString(key);
            }
            default -> {
                return RU.getString(key);
            }
        }
    }
}
