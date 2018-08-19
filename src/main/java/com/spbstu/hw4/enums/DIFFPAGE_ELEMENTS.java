package com.spbstu.hw4.enums;

public enum DIFFPAGE_ELEMENTS {
    CHECK_BOXES(new String[]{"Water", "Earth", "Wind", "Fire"}),
    RADIOS(new String[]{"Gold", "Silver", "Bronze", "Selen"}),
    DROP_COLORS(new String[]{"Red", "Green", "Blue", "Yellow"}),
    SELECT_ELEMENTS(new String[]{"Wind: condition changed to false", "Water: condition changed to false",
            "Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true"});

    public String[] strAr;
    public String str;

    DIFFPAGE_ELEMENTS(String[] strings) {
        strAr = strings;
    }
}