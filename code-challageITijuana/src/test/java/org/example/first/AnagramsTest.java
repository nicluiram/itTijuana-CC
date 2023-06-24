package org.example.first;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnagramsTest {

    private Anagrams anagrams;
    @Before
    public void before(){
        anagrams = new Anagrams();
    }
    @Test
    public void isAnAnagram() {
        System.out.println("Case 1 heart, earth ---> "+anagrams.isAnAnagram("heart", "earth"));
        System.out.println("Case 2 cars scar ---> "+anagrams.isAnAnagram("cars", "scar"));
        System.out.println("Case 3 star rats ---> "+ anagrams.isAnAnagram("star", "rats"));

        System.out.println("Case 4  Tom Marvolo Riddle I am Lord Voldemort ---> "+anagrams.isAnAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));
        System.out.println("Invalid case ---> "+anagrams.isAnAnagram("dog", "cat"));
    }
}