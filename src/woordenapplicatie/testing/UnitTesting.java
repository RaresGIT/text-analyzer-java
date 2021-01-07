package woordenapplicatie.testing;

import org.junit.jupiter.api.Test;
import woordenapplicatie.logic.TextAnalyzer;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTesting {


    @Test
    void TestTextInit()
    {
        System.out.println("-- TESTING INIT METHOD --");
        TextAnalyzer tester = new TextAnalyzer("testing new words");

        assertEquals(tester.getText(),"testing new words");
    }

    @Test
    void TestCountUniqueWords()
    {
        long starttime = System.currentTimeMillis();
        System.out.println("-- TESTING COUNT UNIQUE WORDS --");
        TextAnalyzer tester = new TextAnalyzer("testing new words");
        System.out.println(tester.CountUniqueAndTotalWords());
        assertEquals(tester.CountUniqueAndTotalWords(),"3 unique words and 3 total words!");
        long endtime = System.currentTimeMillis();
        System.out.println("FINISHED TEST IN: " + (endtime-starttime) + " ms!");
    }

    @Test
    void SortWordsDesc()
    {
        long starttime = System.currentTimeMillis();
        System.out.println("-- TESTING SORTING WORDS DESC --");
        TextAnalyzer tester = new TextAnalyzer("testing new words");
        Set<String> expectedresult = new HashSet<>();
        expectedresult.add("words");
        expectedresult.add("testing");
        expectedresult.add("new");

        assertEquals(expectedresult,tester.SortWordsDesc());

        long endtime = System.currentTimeMillis();
        System.out.println("FINISHED TEST IN: " + (endtime-starttime) + " ms!");

    }

    @Test
    void TestWordFreqSortAsc()
    {
        long starttime = System.currentTimeMillis();
        System.out.println("-- TESTING SORTING BY FREQ ASC --");
        TextAnalyzer tester = new TextAnalyzer("testing testing new words");
        LinkedHashMap<String,Integer> expectedresult = new LinkedHashMap<String,Integer>();
        expectedresult.put("words",1);
        expectedresult.put("new",1);
        expectedresult.put("testing",2);

        assertEquals(expectedresult,tester.WordFrequencySort(true));

        long endtime = System.currentTimeMillis();
        System.out.println("FINISHED TEST IN: " + (endtime-starttime) + " ms!");
    }

    @Test
    void TestWordFreqSortDesc()
    {
        long starttime = System.currentTimeMillis();
        System.out.println("-- TESTING SORTING BY FREQ DESC --");
        TextAnalyzer tester = new TextAnalyzer("testing testing new words");
        LinkedHashMap<String,Integer> expectedresult = new LinkedHashMap<String,Integer>();
        expectedresult.put("testing",2);
        expectedresult.put("words",1);
        expectedresult.put("new",1);


        assertEquals(expectedresult,tester.WordFrequencySort(false));

        long endtime = System.currentTimeMillis();
        System.out.println("FINISHED TEST IN: " + (endtime-starttime) + " ms!");
    }

    @Test
    void TestConcordance()
    {
        long starttime = System.currentTimeMillis();
        System.out.println("-- TESTING CONCORDANCE --");

        TextAnalyzer tester = new TextAnalyzer
                (
                        "testing testing new words\n" +
                        "blah blah testing is boring\n"
                );

        //System.out.println(tester.Concordance());

        LinkedHashMap<String, LinkedList<Integer>> expectedresult = new LinkedHashMap<>();

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();
        list1.add(0);
        list2.add(1);
        list3.add(1);
        list3.add(0);


        expectedresult.put("new",list1);
        expectedresult.put("boring",list2);
        expectedresult.put("words",list1);
        expectedresult.put("is",list2);
        expectedresult.put("blah",list2);
        expectedresult.put("testing",list3);


        assertEquals(expectedresult,tester.Concordance());

        long endtime = System.currentTimeMillis();
        System.out.println("FINISHED TEST IN: " + (endtime-starttime) + " ms!");

    }




}
