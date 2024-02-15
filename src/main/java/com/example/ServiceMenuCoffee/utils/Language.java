package com.example.ServiceMenuCoffee.utils;

public enum Language {
    RU,
    EN,
    KG;

    public static Language getLanguage(int ordinal) {
        switch (ordinal) {
            case 1:
                return RU;
            case 2:
                return EN;
            case 3:
                return KG;
            default:
                return RU;
        }
    }
}
