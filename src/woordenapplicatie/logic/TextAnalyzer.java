package woordenapplicatie.logic;


import java.util.*;

public class TextAnalyzer {

    private String text = "";

    public TextAnalyzer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String CountUniqueAndTotalWords()
    {
        HashMap<String,Integer> words = new HashMap<String,Integer>(); //O(1)
        String[] wordArray = text.split("[, .?\n]+"); //O(n)

        for (String word: wordArray) { //O(n)
            if(words.containsKey(word))
                words.replace(word, words.get(word) + 1); //O(1)
            else
                words.put(word,1); //(O(1)
        }

        Integer uniqueWords = words.entrySet().size();
        Integer totalWords = 0;

        for (Map.Entry<String,Integer> entry: words.entrySet()) {
            totalWords += entry.getValue();
        }

        return String.format("%d unique words and %d total words!",uniqueWords,totalWords);
    }

    public Set<String> SortWordsDesc()
    {
        //using the same hashmap since i need all of the unique words
        HashMap<String,Integer> words = new HashMap<String,Integer>();
        String[] wordArray = text.split("[, .?\n]+");

        for (String word: wordArray) {
            if(words.containsKey(word))
                words.replace(word, words.get(word) + 1);
            else
                words.put(word.toLowerCase(),1);
        }

        SortedSet<String> sortedwords = new TreeSet<String>(Collections.reverseOrder()); //O(log n) sorting efficieny
        for (Map.Entry<String,Integer> entry : words.entrySet()) {
            sortedwords.add(entry.getKey());
        }

        return sortedwords;

    }


    public LinkedHashMap<String,Integer> WordFrequencySort(boolean ascending)
    {

        HashMap<String,Integer> words = new HashMap<String,Integer>();


        String[] wordArray = text.split("[, .?\n]+"); //(O(n)

        for (String word: wordArray) {
            if(words.containsKey(word))
                words.replace(word, words.get(word) + 1);
            else
                words.put(word.toLowerCase(),1); //O(1)
        }

        List<Map.Entry<String,Integer>> list = new LinkedList<>(words.entrySet());

        Comparator<Map.Entry<String,Integer>> valueComp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                Integer w1 = o1.getValue();
                Integer w2 = o2.getValue();
                if(!ascending)
                    return w2.compareTo(w1);
                else
                    return w1.compareTo(w2);
            }
        };

        Collections.sort(list,valueComp);

        LinkedHashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) { //O(n)
            temp.put(aa.getKey(), aa.getValue()); //O(1)
        }
        return temp;
    }

    public LinkedHashMap<String, LinkedList<Integer>> Concordance()
    {
        //because we need the sorted words by frequency, we can reuse the function above, without worrying about the complexity
        HashMap<String,Integer> sortedwords = WordFrequencySort(true);
        LinkedHashMap<String,LinkedList<Integer>> result = new LinkedHashMap<String, LinkedList<Integer>>();
        String[] rows = text.split("[\n]");


        //Pretty print, for real unhindered performance comment out
        System.out.println("Showing Rows: ");
        int rowindex = 0;
        for (String row : rows) {

            System.out.println(rowindex + " " + row);
            rowindex++;
        }

        //
        System.out.println();
        for (Map.Entry<String,Integer> entry: sortedwords.entrySet()) {

            System.out.println("Searching for: " + entry.getKey());
            for(int i=0; i< rows.length;i++) //O(n)
            {

                if(rows[i].contains(entry.getKey())) {
                    System.out.println("Found at: " + i);
                    if (result.containsKey(entry.getKey())) { //O(1)
                        LinkedList<Integer> temp = result.get(entry.getKey());
                        temp.push(i);
                        result.replace(entry.getKey(), temp);
                    } else {
                        LinkedList<Integer> temp = new LinkedList<Integer>();
                        temp.push(i);
                        result.put(entry.getKey(), temp);
                    }
                }
            }

        }

        //Pretty print, for real unhindered performance comment out
        System.out.println();
        for (Map.Entry<String,LinkedList<Integer>> entry : result.entrySet()) {
            System.out.println(entry);
        }
        return result;
    }//O(n)


}
