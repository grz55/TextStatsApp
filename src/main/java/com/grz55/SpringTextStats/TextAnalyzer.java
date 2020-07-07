package com.grz55.SpringTextStats;

import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAnalyzer {

    @NotNull
    private String longText;

    public int getCharactersCount(){
        String tempLongText = longText;
        tempLongText = tempLongText.replace("\n", "").replace("\r", "").replace(" ","");
        return tempLongText.length();
    }


    public int getWordsCount() {
        String tempLongText = longText;
        char[] forbiddenChars = {'.',',',';','!','?'};
        for(int i=0;i<forbiddenChars.length;i++)
            tempLongText = tempLongText.replace(forbiddenChars[i],' ');

        tempLongText = tempLongText.trim();
        if (tempLongText.isEmpty())
            return 0;
        return tempLongText.split("\\s+").length;
    }

    public int getLinesCount(){
        if(longText.equals("")){
            return 0;
        }
        String tempLongText = longText;
        tempLongText = tempLongText.trim();
        if(tempLongText.equals("")){
            return 0;
        }

        int count = 1;
        Pattern p = Pattern.compile("\n");
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
