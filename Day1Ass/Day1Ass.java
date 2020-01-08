
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class Day1Ass {
    HashMap<String, ArrayList<String>> synset = new HashMap<>();
    HashMap<String, ArrayList<String>> hypernym = new HashMap<>();

    public void parseSynsets(String fileName) throws Exception {
        String[] arr = Day1Ass.fileToArr(fileName);
        String[] arrSplit = new String[3];
        String[] nouns;
        //String[] store = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
           arrSplit = arr[i].split(",");
           nouns = arrSplit[1].split(" ");
           for (int j = 0; j < nouns.length; j++) {
               if (synset.containsKey(nouns[j])) {
                   synset.get(nouns[j]).add(arrSplit[0]);
               } else {
                   ArrayList<String> id = new ArrayList<>();
                   id.add(arrSplit[0]);
                   synset.put(nouns[j], id);
               }
           }
        }
        System.out.println(synset);
    }

    public void parseHypernym(String fileName) throws Exception {
        String[] arr = Day1Ass.fileToArr(fileName);
        String[] arrSplit = new String[2];
        String[] hypernyms;
        
        for (int i = 0; i < arr.length; i++) {
            ArrayList<String> s = new ArrayList<>();
            arrSplit = arr[i].split(",", 2);
            if (! arr[i].contains(",")) {
               hypernym.put(arr[i], s);
                continue;
            }
            //System.out.println(arrSplit[0]);
            hypernyms = arrSplit[1].split(",");
            for (int j = 0; j < hypernyms.length; j++) {
                if (hypernym.containsKey(arrSplit[0])) {
                    hypernym.get(arrSplit[0]).add(hypernyms[j]);
                } else {
                   s.add(hypernyms[j]);
                   hypernym.put(arrSplit[0], s);
                }
            }
        }
        System.out.println(hypernym);
    }

    public static String[] fileToArr(String filename) throws Exception{
        ArrayList<String> text = new ArrayList<>();
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            text.add(sc.nextLine());
        }
        String[] array = text.toArray(new String[text.size()]);
        return array;
    }
    public static void main(String[] args) {
        Day1Ass obj = new Day1Ass();
        String fileName = "synsets6.txt";
        String fileName1 = "hypernyms6InvalidCycle.txt";
        try {
            obj.parseSynsets(fileName);
        } catch(Exception ex) {
            System.out.println("hi");
        }

        try {
            obj.parseHypernym(fileName1);
        } catch(Exception ex) {
            System.out.println("hi");
        }
    }
}
