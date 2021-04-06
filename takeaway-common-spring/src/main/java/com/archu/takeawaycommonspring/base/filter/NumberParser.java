package com.archu.takeawaycommonspring.base.filter;

import java.text.NumberFormat;
import java.text.ParseException;

public class NumberParser {

    private static final NumberParser INSTANCE = new NumberParser();

    private NumberParser() {
        if (INSTANCE != null)
            throw new IllegalStateException("NumberParser is already instantiated");
    }

    public static NumberParser getInstance() {
        return INSTANCE;
    }

    public Number uncheckedParseNumber(final String value) {
        try {
            return NumberFormat.getInstance().parse(value);
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
