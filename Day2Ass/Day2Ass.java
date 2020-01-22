
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class Day2Ass {
    HashMap<String, ArrayList<String>> synset = new HashMap<>();
    HashMap<String, ArrayList<String>> hypernym = new HashMap<>();
    int count = 0;
    int count1 = 0;

    public Day2Ass(String synsets, String hypernyms) throws Exception {
        parseSynsets(synsets);
        parseHypernym(hypernyms);
        Digraph obj1 = new Digraph(hypernym.size());
        for (String key: hypernym.keySet()) {
            int v = Integer.parseInt(key);
            count++;
            for (String value: hypernym.get(key)) {
                int w = Integer.parseInt(value);
                obj1.addEdge(v, w);
                count1++;
            }
        }
        System.out.println(count);
        System.out.println(count1);
    }

    public Day2Ass() {
    }

    public void parseSynsets(String fileName) throws Exception {
        String[] arr = Day2Ass.fileToArr(fileName);
        String[] arrSplit = new String[3];
        String[] nouns;
        // String[] store = new String[arr.length];
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
        // System.out.println(synset);
    }

    public void parseHypernym(String fileName) throws Exception {
        String[] arr = Day2Ass.fileToArr(fileName);
        String[] arrSplit = new String[2];
        String[] hypernyms;

        for (int i = 0; i < arr.length; i++) {
            ArrayList<String> s = new ArrayList<>();
            arrSplit = arr[i].split(",", 2);
            if (!arr[i].contains(",")) {
                hypernym.put(arr[i], s);
                continue;
            }
            // System.out.println(arrSplit[0]);
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
        // System.out.println(hypernym);
    }

    public static String[] fileToArr(String filename) throws Exception {
        ArrayList<String> text = new ArrayList<>();
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            text.add(sc.nextLine());
        }
        String[] array = text.toArray(new String[text.size()]);
        sc.close();
        return array;
    }

    public static void main(String[] args) {
        Day2Ass obj = new Day2Ass();
        String fileName = "synsets.txt";
        String fileName1 = "hypernyms.txt";
        try {
            new Day2Ass(fileName, fileName1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
