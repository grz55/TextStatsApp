package com.grz55.SpringTextStats;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TextAnalyzer {

    private static final String NEW_LINE = "\n";
    private static final String EMPTY_STRING = "";
    private static final String CARRIAGE_RETURN = "\r";
    private static final String SPACE = " ";
    private static final String[] FORBIDDEN_CHARS = {".", ",", ";", "!", "?"};
    private static final String SPACE_REGEX = "\\s+";

    @NotNull
    private String longText;
    private String tempLongText;
    private Pattern p;

    public TextAnalyzer() {
        p = Pattern.compile(NEW_LINE);
    }

    public int getCharactersCount() {
        tempLongText = longText.replace(NEW_LINE, EMPTY_STRING).replace(CARRIAGE_RETURN, EMPTY_STRING).replace(SPACE, EMPTY_STRING);
        return tempLongText.length();
    }

    public int getWordsCount() {
        for (int i = 0; i < FORBIDDEN_CHARS.length; i++) {
            tempLongText = longText.replace(FORBIDDEN_CHARS[i], SPACE);
        }
        if (tempLongText.isEmpty()) {
            return 0;
        } else {
            return tempLongText.split(SPACE_REGEX).length;
        }
    }

    public int getLinesCount() {
        tempLongText = longText.trim();
        if (tempLongText.isEmpty()) {
            return 0;
        }
        int count = 1;
        Matcher m = p.matcher(tempLongText);
        while (m.find()) {
            count++;
        }
        return count;
    }

    public String getLongText() {
        return longText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }
}
