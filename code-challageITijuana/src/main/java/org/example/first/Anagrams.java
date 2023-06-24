package org.example.first;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;



public class Anagrams {

    public boolean isAnAnagram(String firstWord, String secondWord){

        String cleanFirstWord = firstWord.replaceAll("\\s", "").toLowerCase();
        String cleanSecondWord = secondWord.replaceAll("\\s", "").toLowerCase();

        if (cleanFirstWord.length() != cleanSecondWord.length()){
            return  false;
        }
        char[] arrFirst = cleanFirstWord.toCharArray();
        char[] arrSecond = cleanSecondWord.toCharArray();


        Arrays.sort(arrFirst);
        Arrays.sort(arrSecond);



        return Arrays.equals(arrFirst, arrSecond);
    }


}
